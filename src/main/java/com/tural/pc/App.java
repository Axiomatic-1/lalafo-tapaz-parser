package com.tural.pc;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String url = "https://ru.tap.az/elanlar/elektronika/komputer-avadanliqi?utf8=%E2%9C%93&order=&q%5Buser_id%5D=&q%5Bcontact_id%5D=&q%5Bprice%5D%5B%5D=&q%5Bprice%5D%5B%5D=&p%5B834%5D=7400&p%5B833%5D=&p%5B856%5D=&q%5Bregion_id%5D=&q%5Bkeywords%5D=";
        getAllCards(url);
    }

    private static void getAllCards(String url) {
        try{
            Document doc = Jsoup.connect(url).get();
            for (Element row :
                    doc.getElementsByClass("products-link")){
                VideoCard videoCard = new VideoCard();
                String name = row.select("div.products-name").text();
                String price = row.getElementsByClass("price-val").text();
                String curr = row.getElementsByClass("price-cur").text();
                videoCard.setName(name);
                videoCard.setPrice(price);
                videoCard.setCurr(curr);
//                videoCard.setHref(row.select("href").text());
                System.out.println(videoCard);
//                System.out.println(row.text());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
