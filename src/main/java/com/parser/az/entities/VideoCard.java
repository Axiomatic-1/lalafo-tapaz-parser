package com.parser.az.entities;

import java.util.Objects;

public class VideoCard {

  private String name;
  private String price;
  private String curr;
  private String href;

  public VideoCard() {
  }

  public VideoCard(String name, String price, String curr, String href) {
    this.name = name;
    this.price = price;
    this.curr = curr;
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

  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VideoCard videoCard = (VideoCard) o;
    return Objects.equals(name, videoCard.name) && Objects.equals(href, videoCard.href);
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

  @Override
  public int hashCode() {
    return 31 * Objects.hash(name, href);
  }
}

