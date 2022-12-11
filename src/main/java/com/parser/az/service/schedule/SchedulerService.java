package com.parser.az.service.schedule;

import com.parser.az.constant.UrlHolder;
import com.parser.az.entities.Product;
import com.parser.az.entities.ProductType;
import com.parser.az.service.CardEvaluateImpl;
import com.parser.az.service.LalafoCollectorServiceImpl;
import com.parser.az.service.ProductCollectorServiceImpl;
import com.parser.az.service.interfaces.CardEvaluate;
import com.parser.az.service.interfaces.ExcelManager;
import com.parser.az.service.interfaces.LalafoCollectorService;
import com.parser.az.service.interfaces.ProductCollector;
import com.parser.az.service.output.ExcelManagerImpl;

import java.util.List;
import java.util.Set;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SchedulerService extends TimerTask {

    public static String startPageSearch_Tapaz;
    public static String startPageSearch_Lalafo;
    public static String productType;
    //provides depth of searching, not recommended more than 8
    public static int hrefCounterTapaz = 7;
    public static int hrefCounterLalafo = 0;
    private static String cachedUrlTapAz;
    private final Logger logger = Logger.getLogger(SchedulerService.class.getName());

    private static void initStartUrl() {
        if (hrefCounterTapaz == 7) {
            if (productType.equalsIgnoreCase(ProductType.VIDEOCARD.name())) {
                startPageSearch_Tapaz = UrlHolder.VIDEOCARD_START_PAGE;
                cachedUrlTapAz = UrlHolder.VIDEOCARD_START_PAGE;
            }
            if (productType.equalsIgnoreCase(ProductType.CPU.name())) {
                startPageSearch_Tapaz = UrlHolder.PROCESSOR_START_PAGE;
                cachedUrlTapAz = UrlHolder.PROCESSOR_START_PAGE;
            }
            if (productType.equalsIgnoreCase(ProductType.MOTHERBOARD.name())) {
                startPageSearch_Tapaz = UrlHolder.MOTHERBOARD_START_PAGE;
                cachedUrlTapAz = UrlHolder.MOTHERBOARD_START_PAGE;
            }
        }
        if (hrefCounterLalafo == 0 &&
                startPageSearch_Lalafo == null &&
                    productType.equalsIgnoreCase(ProductType.VIDEOCARD.name())) {
            startPageSearch_Lalafo = UrlHolder.LALAFO_START_GPU_URL;
        }
    }

    @Override
    public void run() {
        initStartUrl();
        if (hrefCounterTapaz == 0) {
            startPageSearch_Tapaz = cachedUrlTapAz;
        }
        ExcelManager manager = new ExcelManagerImpl();
        manager.writeExcelWithBestOffers(CardEvaluateImpl.bestPrices, "");
        ProductCollector productCollector = new ProductCollectorServiceImpl();
        LalafoCollectorService lalafoCollectorService = new LalafoCollectorServiceImpl();
        CardEvaluate cardEvaluate = new CardEvaluateImpl();
        List<Product> cardsFromTapAzSite = productCollector.getProductFromTapAzSite(startPageSearch_Tapaz);
        if (startPageSearch_Lalafo != null) {
            List<Product> productsFromLalafo = lalafoCollectorService.getProductFromLalafoSite(startPageSearch_Lalafo);
            cardsFromTapAzSite.addAll(productsFromLalafo);
        }
        for (Product product: cardsFromTapAzSite) {
            logger.log(Level.INFO,product.toString());
        }
        Set<Product> products = cardEvaluate.evaluateBestOffers(cardsFromTapAzSite);

        products.forEach(x -> System.out.println("Best prices: " + x));
    }

}
