package com.parser.az.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.parser.az.constant.UrlHolder;
import com.parser.az.entities.Product;
import com.parser.az.entities.lalafo.ItemsItem;
import com.parser.az.entities.lalafo.Response;
import com.parser.az.service.interfaces.LalafoCollectorService;
import com.parser.az.service.schedule.SchedulerService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LalafoCollectorServiceImpl implements LalafoCollectorService {

    private static List<Product> mapLalafoItemsToProduct(List<ItemsItem> items) {
        List<Product> products = new ArrayList<>();
        for (ItemsItem item : items) {
            Product product = new Product();
            product.setName(item.getTitle());
            product.setPrice(String.valueOf(item.getPrice()));
            product.setCurr(item.getCurrency());
            product.setHref(generateHrefToItemInLalafo(item));
            products.add(product);
        }
        return products;
    }

    private static String generateHrefToItemInLalafo(ItemsItem item) {
        String beginOfUrl = item.getTitle()
                .replace(" ", "-")
                .replace(".","")
                .replace(",","")
                .replace("ü","u")
                .replace("ç","c")
                .replace("ğ","g")
                .replace("ə","");
        String prefix = UrlHolder.LALAFO_GPU_PREFIX_FOR_PRODUCT;
        String[] split = beginOfUrl.split("-");
        if (split.length > 6) {
            String[] cut = Arrays.copyOfRange(split, 0, 5);
            return prefix + String.join("", cut) + "-id-" + item.getId();
        }
        return prefix + beginOfUrl + "-id-" + item.getId();
    }

    @Override
    public List<Product> getProductFromLalafoSite(String uri) {
        ObjectMapper mapper = new ObjectMapper();
        List<Product> resultList = new ArrayList<>();
        try (WebClient webClient = new WebClient()) {
            webClient.addRequestHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36");
            webClient.addRequestHeader("Accept", "application/json, text/plain, */*");
            webClient.addRequestHeader("device", "pc");
            webClient.addRequestHeader("country-id", "13");
            Page page = webClient.getPage(uri);
            WebResponse response = page.getWebResponse();
            if (response.getContentType().equals("application/json")) {
                String json = response.getContentAsString();
                Response products = mapper.readValue(json, Response.class);
                resultList.addAll(mapLalafoItemsToProduct(products.getItems()));
                //if we have url to next page we set it to startPageSearchLalafo
                //if we have not, we set first search page and then only refresh it
                if (products.get_links().getNext() != null) {
                    SchedulerService.startPageSearch_Lalafo =
                            UrlHolder.LALAFO_START_PREFIX_GPU_URL + products.get_links().getNext().getHref();
                    SchedulerService.hrefCounterLalafo++;
                    System.out.println(SchedulerService.startPageSearch_Lalafo);
                } else {
                    SchedulerService.startPageSearch_Lalafo =
                            UrlHolder.LALAFO_START_GPU_URL;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
