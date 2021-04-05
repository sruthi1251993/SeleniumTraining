package com.netcore.FlipkartMobileSearch.model;

public class Mobile {

  private String name;

  private String price;

  private String numberOfRatings;

  private Integer priceInInt;

  private Integer ratingsInInt;

  private Integer storage;


  public Mobile(String name, String price, String numberOfRatings) {
    this.name = name;
    this.price = price;
    this.numberOfRatings = numberOfRatings;
  }

  public String getPrice() {
    return price;
  }

  public Mobile setPrice(String price) {
    this.price = price;
    return this;
  }

  public String getNumberOfRatings() {
    return numberOfRatings;
  }

  public Mobile setNumberOfRatings(String numberOfRatings) {
    this.numberOfRatings = numberOfRatings;
    return this;
  }

  public String getName() {
    return name;
  }

  public Mobile setName(String name) {
    this.name = name;
    return this;
  }

  public Integer getPriceInInt() {
    return priceInInt;
  }

  public Mobile setPriceInInt(Integer priceInInt) {
    this.priceInInt = priceInInt;
    return this;
  }

  public Integer getRatingsInInt() {
    return ratingsInInt;
  }

  public Mobile setRatingsInInt(Integer ratingsInInt) {
    this.ratingsInInt = ratingsInInt;
    return this;
  }

  public Integer getStorage() {
    return storage;
  }

  public Mobile setStorage(Integer storage) {
    this.storage = storage;
    return this;
  }

  @Override
  public String toString() {
    return "Mobile{" +
        "name='" + name + '\'' +
        ", price='" + price + '\'' +
        ", numberOfRatings='" + numberOfRatings + '\'' +
        ", priceInInt=" + priceInInt +
        ", ratingsInInt=" + ratingsInInt +
        ", storage=" + storage +
        '}';
  }
}
