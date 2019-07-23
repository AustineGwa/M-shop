package com.gwazasoftwares.uhcregistration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.gwazasoftwares.uhcregistration.adapters.ShopItemAdapter;
import com.gwazasoftwares.uhcregistration.models.ShopItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShopHome extends AppCompatActivity {

    private ImageView itemImage;
    private TextView  itemName, itemPrice;
    private Button addCartButton;
    private List<ShopItem> shopItemList;
    private Adapter adapter;

    private RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_home);

        recyclerview = findViewById(R.id.items_rv);
        recyclerview.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerview.setHasFixedSize(true);

        shopItemList = new ArrayList<>();
        ShopItem item1 = new ShopItem(R.drawable.mandazi,"Fresh mazi","Ksh 5");
        ShopItem item2 = new ShopItem(R.drawable.tea,"Milk tea","Ksh 15");
        ShopItem item3 = new ShopItem(R.drawable.mandazi,"Fresh mazi","Ksh 5");
        ShopItem item4 = new ShopItem(R.drawable.tea,"Milk tea","Ksh 15");

        shopItemList.addAll(Arrays.asList(item1,item2,item3,item4));
        ShopItemAdapter shopItemAdapter = new ShopItemAdapter(shopItemList, getApplicationContext());

        recyclerview.setAdapter(shopItemAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.mycart){
            startActivity(new Intent(getApplicationContext(), ViewCart.class));
        }
        return super.onOptionsItemSelected(item);
    }

}
