package com.parser.az.service.videocard;

import com.parser.az.entities.VideoCard;

import com.parser.az.service.videocard.interfaces.CardEvaluate;
import java.util.*;

public class CardEvaluateImpl implements CardEvaluate {
    private static final Set<VideoCard> allCards = new HashSet<>();
    private static HashMap<String, Integer> avgPriceForCard;
    private final Set<VideoCard> bestPrices = new HashSet<>();

    @Override
    public Set<VideoCard> evaluateBestOffers(List<VideoCard> cards) {
        //fulfill our map with avg prices to cards if its empty
        initPrices();
        allCards.addAll(cards);
        allCards.forEach(card -> {
            avgPriceForCard.forEach((cardName, price) -> {
                if(card.getName().toLowerCase().contains(cardName.toLowerCase())) {
                    String name = card.getPrice().replace(" ", "").replace(",",".");
                    if (Double.parseDouble(name.trim()) < price) {
                        bestPrices.add(card);
                    }
                }
            });
        });
        return bestPrices;
    }

    private static void initPrices() {
        if (avgPriceForCard == null) {
            avgPriceForCard = new HashMap<>();
            avgPriceForCard.put("580 ", 250);
            avgPriceForCard.put("570 ", 150);
            avgPriceForCard.put("2060", 350);
            avgPriceForCard.put("2060s", 400);
            avgPriceForCard.put("2060 s", 400);
            avgPriceForCard.put("2060super", 400);
            avgPriceForCard.put("2060 super", 400);
            avgPriceForCard.put("2060ti", 500);
            avgPriceForCard.put("2060 ti", 500);
            avgPriceForCard.put("1660", 300);
            avgPriceForCard.put("1660s", 350);
            avgPriceForCard.put("1660 s", 350);
            avgPriceForCard.put("1660ti", 400);
            avgPriceForCard.put("1660 ti", 400);
            avgPriceForCard.put("3060", 500);
            avgPriceForCard.put("3060ti", 500);
            avgPriceForCard.put("3060 ti", 500);
            avgPriceForCard.put("6600", 400);
            avgPriceForCard.put("6600xt", 450);
            avgPriceForCard.put("6600 xt", 450);
            avgPriceForCard.put("1080", 500);
            avgPriceForCard.put("1080ti", 500);
            avgPriceForCard.put("1080 ti", 500);
            avgPriceForCard.put("3080", 1000);
            avgPriceForCard.put("3080ti", 1000);
            avgPriceForCard.put("3080 ti", 1000);
        }
    }
}
