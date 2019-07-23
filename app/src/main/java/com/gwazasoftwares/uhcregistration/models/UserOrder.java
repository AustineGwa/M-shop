package com.gwazasoftwares.uhcregistration.models;

import java.util.List;

public class UserOrder {

    private String name;
    private String hallOfResidence;
    private String room;
    private String price;
    private List<ShopItem> shopItemList;

    public UserOrder() {
    }

    public UserOrder(String name, String hallOfResidence, String room, String price, List<ShopItem> shopItemList) {
        this.name = name;
        this.hallOfResidence = hallOfResidence;
        this.room = room;
        this.price = price;
        this.shopItemList = shopItemList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHallOfResidence() {
        return hallOfResidence;
    }

    public void setHallOfResidence(String hallOfResidence) {
        this.hallOfResidence = hallOfResidence;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<ShopItem> getShopItemList() {
        return shopItemList;
    }

    public void setShopItemList(List<ShopItem> shopItemList) {
        this.shopItemList = shopItemList;
    }
}
