package com.parser.az.service;

import com.parser.az.entities.VideoCard;

import java.util.List;
import java.util.Set;

public interface CardEvaluate {
    Set<VideoCard> evaluateBestOffers(List<VideoCard> cards);
}
