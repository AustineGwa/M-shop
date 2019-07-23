package com.gwazasoftwares.uhcregistration.utils;

import android.content.Context;
import android.widget.Toast;

public class Functions {

    public static void addItemToCart(Context context, int position){
        Toast.makeText(context,"Item added to cart "+position, Toast.LENGTH_LONG).show();
    };
}
