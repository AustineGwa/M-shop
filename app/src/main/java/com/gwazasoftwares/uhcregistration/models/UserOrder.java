package com.gwazasoftwares.uhcregistration.models;

import java.util.List;

public class UserOrder {

    private String name;
    private String hallOfResidence;
    private String room;
    private ShopItem shopItem;

    public UserOrder() {
    }

    public UserOrder(String name, String hallOfResidence, String room, ShopItem shopItem) {
        this.name = name;
        this.hallOfResidence = hallOfResidence;
        this.room = room;
        this.shopItem = shopItem;
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

    public ShopItem getShopItem() {
        return shopItem;
    }

    public void setShopItem(ShopItem shopItem) {
        this.shopItem = shopItem;
    }
}
