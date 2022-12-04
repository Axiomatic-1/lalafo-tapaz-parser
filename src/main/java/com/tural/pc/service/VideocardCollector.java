package com.tural.pc.service;

import com.tural.pc.entities.VideoCard;
import java.util.List;

public interface VideocardCollector {

  List<VideoCard> getCardsFromTapAzSite(String url);

}
