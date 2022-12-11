package com.parser.az.service.interfaces;

import com.parser.az.entities.Product;

import java.util.Set;

public interface ExcelManager {
    void writeExcelWithBestOffers(Set<Product> productSet, String path);
}
