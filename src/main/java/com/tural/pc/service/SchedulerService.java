package com.tural.pc.service;

import com.tural.pc.constant.SearchVideoKartURL;
import com.tural.pc.entities.VideoCard;

import java.util.List;
import java.util.Set;
import java.util.TimerTask;

public class SchedulerService extends TimerTask {
    public static String URL = SearchVideoKartURL.START_PAGE;
    public static int hrefCounter = 5;

    @Override
    public void run() {
        if (hrefCounter == 0) {
            URL = SearchVideoKartURL.START_PAGE;
        }
        VideocardCollector videocardCollector = new VideocardCollectorServiceImpl();
        CardEvaluate cardEvaluate = new CardEvaluateImpl();
        List<VideoCard> cardsFromTapAzSite = videocardCollector.getCardsFromTapAzSite(URL);
        for (VideoCard card : cardsFromTapAzSite) {
            if(Double.parseDouble(card.getPrice().replace(" ", "").replace(",", ".")) < 500)
                System.out.println(card);
        }
        Set<VideoCard> videoCards = cardEvaluate.evaluateBestOffers(cardsFromTapAzSite);
        videoCards.forEach(x -> System.out.println("Best prices: " + x));
    }
}
