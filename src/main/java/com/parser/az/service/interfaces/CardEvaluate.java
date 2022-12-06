package com.parser.az.service.interfaces;

import com.parser.az.entities.Product;

import java.util.List;
import java.util.Set;

public interface CardEvaluate {
    Set<Product> evaluateBestOffers(List<Product> cards);
}
