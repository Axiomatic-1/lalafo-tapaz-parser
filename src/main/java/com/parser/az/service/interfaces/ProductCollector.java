package com.parser.az.service.interfaces;

import com.parser.az.entities.Product;
import java.util.List;

public interface ProductCollector {

  List<Product> getProductFromTapAzSite(String url);

}
