package com.parser.az.service.schedule;

import com.parser.az.constant.UrlHolder;
import com.parser.az.entities.Product;
import com.parser.az.entities.ProductType;
import com.parser.az.service.CardEvaluateImpl;
import com.parser.az.service.ProductCollectorServiceImpl;
import com.parser.az.service.interfaces.CardEvaluate;
import com.parser.az.service.interfaces.ExcelManager;
import com.parser.az.service.interfaces.ProductCollector;
import com.parser.az.service.output.ExcelManagerImpl;

import java.util.List;
import java.util.Set;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SchedulerService extends TimerTask {

    public static String startPageSearch;
    public static String productType;
    //provides depth of searching, not recommended more than 8
    public static int hrefCounter = 7;
    private static String cachedUrl;
    private final Logger logger = Logger.getLogger(SchedulerService.class.getName());

    private static void initStartUrl() {
        if (hrefCounter == 7) {
            if (productType.equalsIgnoreCase(ProductType.VIDEOCARD.name())) {
                startPageSearch = UrlHolder.VIDEOCARD_START_PAGE;
                cachedUrl = UrlHolder.VIDEOCARD_START_PAGE;
            }
            if (productType.equalsIgnoreCase(ProductType.CPU.name())) {
                startPageSearch = UrlHolder.PROCESSOR_START_PAGE;
                cachedUrl = UrlHolder.PROCESSOR_START_PAGE;
            }
            if (productType.equalsIgnoreCase(ProductType.MOTHERBOARD.name())) {
                startPageSearch = UrlHolder.MOTHERBOARD_START_PAGE;
                cachedUrl = UrlHolder.MOTHERBOARD_START_PAGE;
            }
        }
    }

    @Override
    public void run() {
        initStartUrl();
        if (hrefCounter == 0) {
            startPageSearch = cachedUrl;
        }
        ExcelManager manager = new ExcelManagerImpl();
        manager.writeExcelWithBestOffers(CardEvaluateImpl.bestPrices, "");
        ProductCollector productCollector = new ProductCollectorServiceImpl();
        CardEvaluate cardEvaluate = new CardEvaluateImpl();
        List<Product> cardsFromTapAzSite = productCollector.getProductFromTapAzSite(startPageSearch);
        for (Product card : cardsFromTapAzSite) {
            logger.log(Level.INFO, card.toString());
        }
        Set<Product> products = cardEvaluate.evaluateBestOffers(cardsFromTapAzSite);
        products.forEach(x -> System.out.println("Best prices: " + x));
    }

}
