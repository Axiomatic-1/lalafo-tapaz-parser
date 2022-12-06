package com.parser.az.service;

import com.parser.az.entities.VideoCard;
import java.util.List;

public interface VideocardCollector {

  List<VideoCard> getCardsFromTapAzSite(String url);

}
