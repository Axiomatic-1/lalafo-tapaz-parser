package com.parser.az.service.output;

import com.parser.az.entities.Product;
import com.parser.az.service.interfaces.ExcelManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class ExcelManagerImpl implements ExcelManager {
    // spreadsheet object
    XSSFSheet spreadsheet;
    // creating a row object
    XSSFRow row;
    XSSFWorkbook workbook;

    public ExcelManagerImpl() {
        this.workbook = new XSSFWorkbook();
        this.spreadsheet = workbook.createSheet(" Tap.az Product Data ");
    }

    @Override
    public void writeExcelWithBestOffers(Set<Product> productSet, String path) {
        if (!path.isBlank()) {
            //TODO implementation for custom path
        }
        AtomicInteger rowId = new AtomicInteger();
        File file = new File("");
        String absolutePath = file.getAbsolutePath();
        productSet.forEach(product -> {
            row = spreadsheet.createRow(rowId.getAndIncrement());
            String[] attrs = getSplit(product);
            for (int i = 0; i < attrs.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(attrs[i]);
            }
            try {
                FileOutputStream stream = new FileOutputStream(
                        new File(absolutePath + "/TapazProducts.xlsx")
                );
                workbook.write(stream);
                stream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static String[] getSplit(Product product) {
        return product.toString()
                .replace("Product{name=", "")
                .replace("price=", "")
                .replace("curr=", "")
                .replace("href=", "")
                .replace("'","")
                .replace("}","")
                .split(",");
    }
}
