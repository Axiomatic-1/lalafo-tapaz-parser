package com.parser.az.service;

import com.parser.az.entities.Product;
import com.parser.az.entities.ProductType;
import com.parser.az.service.interfaces.CardEvaluate;
import com.parser.az.service.schedule.SchedulerService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CardEvaluateImpl implements CardEvaluate {
    private static final Set<Product> allCards = new HashSet<>();
    private static HashMap<String, Integer> avgPriceForProduct;
    private final Set<Product> bestPrices = new HashSet<>();

    @Override
    public Set<Product> evaluateBestOffers(List<Product> products) {
        //fulfill our map with avg prices to products if its empty
        initMapWithBestPriceForProduct();
        initVideoCards();
        allCards.addAll(products);
        allCards.forEach(product -> avgPriceForProduct.forEach((productName, price) -> {
            if (product.getName().toLowerCase().contains(productName.toLowerCase())) {
                String name = product.getPrice().replace(" ", "").replace(",", ".");
                if (Double.parseDouble(name.trim()) < price) {
                    bestPrices.add(product);
                }
            }
        }));
        return bestPrices;
    }

    private void initMapWithBestPriceForProduct() {
        if (SchedulerService.productType.equalsIgnoreCase(ProductType.VIDEOCARD.name())) {
            initVideoCards();
        }
        if (SchedulerService.productType.equalsIgnoreCase(ProductType.CPU.name())) {
            initProcessors();
        }
        if (SchedulerService.productType.equalsIgnoreCase(ProductType.MOTHERBOARD.name())) {
            //TODO init for motherboards
            throw new RuntimeException("Motherboard search not implemented yet");
        }
    }

    private static void initProcessors() {
        if (avgPriceForProduct == null) {
            avgPriceForProduct = new HashMap<>();
            avgPriceForProduct.put("12100 ", 350);
            avgPriceForProduct.put("12100f", 400);
            avgPriceForProduct.put("11400", 351);
            avgPriceForProduct.put("11600", 351);
            avgPriceForProduct.put("11100 ", 400);
            avgPriceForProduct.put("11100f", 400);
            avgPriceForProduct.put("10100", 400);
            avgPriceForProduct.put("10600", 400);
            avgPriceForProduct.put("9400f", 250);
            avgPriceForProduct.put("9400 ", 251);
            avgPriceForProduct.put("9100 ", 251);

            avgPriceForProduct.put("5700", 400);
            avgPriceForProduct.put("5600", 400);
            avgPriceForProduct.put("3700", 400);
            avgPriceForProduct.put("3600", 400);
            avgPriceForProduct.put("2700", 400);
            avgPriceForProduct.put("2600", 400);
        }
    }

    private static void initVideoCards() {
        if (avgPriceForProduct == null) {
            avgPriceForProduct = new HashMap<>();
            avgPriceForProduct.put("580 ", 250);
            avgPriceForProduct.put("570 ", 150);
            avgPriceForProduct.put("2060", 350);
            avgPriceForProduct.put("2060s", 400);
            avgPriceForProduct.put("2060 s", 400);
            avgPriceForProduct.put("2060super", 400);
            avgPriceForProduct.put("2060 super", 400);
            avgPriceForProduct.put("2060ti", 500);
            avgPriceForProduct.put("2060 ti", 500);
            avgPriceForProduct.put("1660", 300);
            avgPriceForProduct.put("1660s", 350);
            avgPriceForProduct.put("1660 s", 350);
            avgPriceForProduct.put("1660ti", 400);
            avgPriceForProduct.put("1660 ti", 400);
            avgPriceForProduct.put("3060", 500);
            avgPriceForProduct.put("3060ti", 500);
            avgPriceForProduct.put("3060 ti", 500);
            avgPriceForProduct.put("6600", 400);
            avgPriceForProduct.put("6600xt", 450);
            avgPriceForProduct.put("6600 xt", 450);
            avgPriceForProduct.put("1080", 500);
            avgPriceForProduct.put("1080ti", 500);
            avgPriceForProduct.put("1080 ti", 500);
            avgPriceForProduct.put("3080", 1000);
            avgPriceForProduct.put("3080ti", 1000);
            avgPriceForProduct.put("3080 ti", 1000);
        }
    }
}
