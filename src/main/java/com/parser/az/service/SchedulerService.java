package com.parser.az.service;

import com.parser.az.constant.UrlHolder;
import com.parser.az.entities.VideoCard;
import com.parser.az.service.videocard.CardEvaluate;
import com.parser.az.service.videocard.CardEvaluateImpl;
import com.parser.az.service.videocard.VideocardCollector;
import com.parser.az.service.videocard.VideocardCollectorServiceImpl;
import java.util.List;
import java.util.Set;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SchedulerService extends TimerTask {

  public static String urlTapAz = UrlHolder.VIDEOCARD_START_PAGE;
  public static int hrefCounter = 5;
  private final Logger logger = Logger.getLogger(SchedulerService.class.getName());

  @Override
  public void run() {
    if (hrefCounter == 0) {
      urlTapAz = UrlHolder.VIDEOCARD_START_PAGE;
    }
    VideocardCollector videocardCollector = new VideocardCollectorServiceImpl();
    CardEvaluate cardEvaluate = new CardEvaluateImpl();
    List<VideoCard> cardsFromTapAzSite = videocardCollector.getCardsFromTapAzSite(urlTapAz);
    for (VideoCard card : cardsFromTapAzSite) {
      logger.log(Level.INFO,card.toString());
    }
    Set<VideoCard> videoCards = cardEvaluate.evaluateBestOffers(cardsFromTapAzSite);
    videoCards.forEach(x -> System.out.println("Best prices: " + x));
  }
}
