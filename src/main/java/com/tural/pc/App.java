package com.tural.pc;

import com.tural.pc.entities.VideoCard;
import com.tural.pc.service.VideocardCollector;
import com.tural.pc.service.VideocardCollectorServiceImpl;


public class App {

  public static final String URL =
      "https://ru.tap.az/elanlar/elektronika/komputer-avadanliqi?utf8=%E2%9C%93&order=&q"
          + "%5Buser_id%5D=&q%5Bcontact_id%5D=&q%5Bprice%5D%5B%5D=&q%5Bprice%5D%5B%5D=&p%5B834%5D=7400"
          + "&p%5B833%5D=&p%5B856%5D=&q%5Bregion_id%5D=&q%5Bkeywords%5D=";

  public static void main(String[] args) {
    VideocardCollector videocardCollector = new VideocardCollectorServiceImpl();
    for (VideoCard card : videocardCollector.getCardsFromTapAzSite(URL)) {
      System.out.println(card);
    }
  }
}
