package com.tural.pc.service;

import com.tural.pc.entities.VideoCard;

import java.util.List;
import java.util.Set;

public interface CardEvaluate {
    Set<VideoCard> evaluateBestOffers(List<VideoCard> cards);
}
