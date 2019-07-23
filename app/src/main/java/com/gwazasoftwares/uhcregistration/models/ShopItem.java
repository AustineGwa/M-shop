package com.gwazasoftwares.uhcregistration.models;

import android.widget.ImageView;
import android.widget.TextView;

public class ShopItem {
    private int itemImage;
    private String itemName, itemPrice;

    public ShopItem() {
    }

    public ShopItem(int itemImage, String itemName, String itemPrice) {
        this.itemImage = itemImage;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }
}
