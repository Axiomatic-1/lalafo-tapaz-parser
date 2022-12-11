package com.parser.az.service.interfaces;

import com.parser.az.entities.Product;

import java.io.IOException;
import java.util.List;

public interface LalafoCollectorService {
    List<Product> getProductFromLalafoSite(String uri);
}
