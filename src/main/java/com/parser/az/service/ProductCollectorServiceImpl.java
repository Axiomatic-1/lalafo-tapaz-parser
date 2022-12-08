package com.parser.az.service;

import com.parser.az.constant.DomElements;
import com.parser.az.entities.Product;
import com.parser.az.exceptions.UnexpectedExceptionWhileConnecting;
import com.parser.az.service.interfaces.ProductCollector;
import com.parser.az.service.schedule.SchedulerService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductCollectorServiceImpl implements ProductCollector {

    @Override
    public List<Product> getProductFromTapAzSite(String url) {
        List<Product> products = new ArrayList<>();
        List<String> hrefs = new ArrayList<>();
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new UnexpectedExceptionWhileConnecting(e.getMessage());
        }
        Elements container = doc.getElementsByClass(DomElements.CONTAINER);
        for (Element cn : container) {
            Elements cards = cn.getElementsByClass(DomElements.PRODUCTS);
            //getting every videocard
            for (Element card : cards) {
                String name = card.select(DomElements.PRODUCT_NAME).text();
                String price = card.getElementsByClass(DomElements.PRODUCT_PRICE).text();
                String curr = card.getElementsByClass(DomElements.PRODUCT_PRICE_CURRENCY).text();
                Product product = new Product();
                product.setName(name.replace("Video", "")
                        .replace("kart", ""));
                product.setPrice(price);
                product.setCurr(curr);
                products.add(product);
            }
            //collecting all hrefs
            hrefs = cn.select("[href]").eachAttr("href")
                    .parallelStream()
                    .filter(x -> !(x.contains("bookmark")))
                    .distinct()
                    .collect(Collectors.toUnmodifiableList());
        }
        //setting each card his url(href) by order (i know, it's terrible)
        if (hrefs.size() - 1 == products.size()) {
            int counterForCardAndHrefList = 0;
            //last ref in list is reference for next page
            for (String href : hrefs.subList(0, hrefs.size() - 1)) {
                products.get(counterForCardAndHrefList).setHref("ru.tap.az" + href);
                if (counterForCardAndHrefList != products.size() - 1) {
                    counterForCardAndHrefList++;
                }
            }
            //marching to next page till depth is not 0
            if (SchedulerService.hrefCounter > 0) {
                SchedulerService.startPageSearch = "https://ru.tap.az" + hrefs.get(hrefs.size() - 1);
                SchedulerService.hrefCounter--;
            }
        }
        return products;
    }
}
