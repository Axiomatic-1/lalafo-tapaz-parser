package com.parser.az.service.videocard;

import com.parser.az.entities.VideoCard;
import com.parser.az.exceptions.UnexpectedExceptionWhileConnecting;
import com.parser.az.service.SchedulerService;
import com.parser.az.service.videocard.interfaces.VideocardCollector;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class VideocardCollectorServiceImpl implements VideocardCollector {

  private static final String CONTAINER = "js-endless-container products endless-products";
  private static final String PRODUCTS = "products-link";
  private static final String VIDEOCARD_NAME = "div.products-name";
  private static final String VIDEOCARD_PRICE = "price-val";
  private static final String VIDEOCARD_PRICE_CURRENCY = "price-cur";

  @Override
  public List<VideoCard> getCardsFromTapAzSite(String url) {
    List<VideoCard> videoCards = new ArrayList<>();
    List<String> hrefs = new ArrayList<>();
    Document doc = null;
    try {
      doc = Jsoup.connect(url).get();
    } catch (IOException e) {
      throw new UnexpectedExceptionWhileConnecting(e.getMessage());
    }
    Elements container = doc.getElementsByClass(CONTAINER);
    for (Element cn : container) {
      Elements cards = cn.getElementsByClass(PRODUCTS);
      //getting every videocard
      for (Element card : cards) {
        String name = card.select(VIDEOCARD_NAME).text();
        String price = card.getElementsByClass(VIDEOCARD_PRICE).text();
        String curr = card.getElementsByClass(VIDEOCARD_PRICE_CURRENCY).text();
        VideoCard videoCard = new VideoCard();
        videoCard.setName(name.replace("Video", "")
            .replace("kart", ""));
        videoCard.setPrice(price);
        videoCard.setCurr(curr);
        videoCards.add(videoCard);
      }
      //collecting all hrefs
      hrefs = cn.select("[href]").eachAttr("href")
          .parallelStream()
          .filter(x -> !(x.contains("bookmark")))
          .distinct()
          .collect(Collectors.toUnmodifiableList());
    }
    //setting each card his href by order (i know, it's terrible)
    if (hrefs.size() - 1 == videoCards.size()) {
      int counterForCardAndHrefList = 0;
      //last ref in list is reference for next page
      for (String href : hrefs.subList(0, hrefs.size() - 1)) {
        videoCards.get(counterForCardAndHrefList).setHref("ru.tap.az" + href);
        if (counterForCardAndHrefList != videoCards.size() - 1) {
          counterForCardAndHrefList++;
        }
      }
      if (SchedulerService.hrefCounter > 0) {
        SchedulerService.urlTapAz = "https://ru.tap.az" + hrefs.get(hrefs.size() - 1);
        SchedulerService.hrefCounter--;
      }
    }
    return videoCards;
  }
}
