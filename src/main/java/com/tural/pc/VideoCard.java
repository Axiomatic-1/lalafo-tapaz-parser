package com.tural.pc;


public class VideoCard {

    private String name;
    private String price;
    private String curr;
    private String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    @Override
    public String toString() {
        return "VideoCard{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", curr='" + curr + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}
