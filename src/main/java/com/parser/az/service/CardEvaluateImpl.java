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
    public static final Set<Product> bestPrices = new HashSet<>();

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
            initMotherboards();
        }
    }

    private static void initProcessors() {
        if (avgPriceForProduct == null) {
            //intel
            avgPriceForProduct = new HashMap<>();
            avgPriceForProduct.put("12400 ", 301);
            avgPriceForProduct.put("12100 ", 275);
            avgPriceForProduct.put("12100f", 271);
            avgPriceForProduct.put("11600", 311);
            avgPriceForProduct.put("11400", 311);
            avgPriceForProduct.put("11100 ", 241);
            avgPriceForProduct.put("11100f", 231);
            avgPriceForProduct.put("10600", 351);
            avgPriceForProduct.put("10400", 211);
            avgPriceForProduct.put("10100", 201);
            avgPriceForProduct.put("9400f", 200);
            avgPriceForProduct.put("9400 ", 201);
            avgPriceForProduct.put("9100 ", 161);
            //amd ryzen
            avgPriceForProduct.put("5700", 401);
            avgPriceForProduct.put("5600", 271);
            avgPriceForProduct.put("5500", 221);
            avgPriceForProduct.put("4100", 201);
            avgPriceForProduct.put("4100x", 221);
            avgPriceForProduct.put("3700x", 311);
            avgPriceForProduct.put("3700", 301);
            avgPriceForProduct.put("3600 ", 211);
            avgPriceForProduct.put("3600x", 221);
            avgPriceForProduct.put("3500", 201);
            avgPriceForProduct.put("3500x", 211);
            avgPriceForProduct.put("3300", 181);
            avgPriceForProduct.put("3300x", 191);
            avgPriceForProduct.put("2700", 211);
            avgPriceForProduct.put("2700x", 231);
            avgPriceForProduct.put("2600", 171);
            avgPriceForProduct.put("2600x", 175);
            avgPriceForProduct.put("1700x", 175);
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

    private static void initMotherboards() {
        if (avgPriceForProduct == null) {
            //amd am4
            avgPriceForProduct = new HashMap<>();
            avgPriceForProduct.put("570", 230);
            avgPriceForProduct.put("520", 180);
            avgPriceForProduct.put("510", 180);
            avgPriceForProduct.put("450", 180);
            avgPriceForProduct.put("410", 160);
            avgPriceForProduct.put("320", 150);
            //amd am5
            avgPriceForProduct = new HashMap<>();
            avgPriceForProduct.put("650", 280);
            //intel lga 1200
            avgPriceForProduct.put("590", 250);
            avgPriceForProduct.put("560", 200);
            avgPriceForProduct.put("510", 200);
            avgPriceForProduct.put("490", 200);
            //intel lga 1700
            avgPriceForProduct.put("690", 270);
            avgPriceForProduct.put("660", 230);
            avgPriceForProduct.put("610", 200);
        }
    }
}
