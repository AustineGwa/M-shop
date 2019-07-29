package com.gwazasoftwares.uhcregistration.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gwazasoftwares.uhcregistration.R;
import com.gwazasoftwares.uhcregistration.models.ShopItem;

import java.util.List;

public class CartItemsAdapter extends RecyclerView.Adapter<CartItemsAdapter.CartDataViewHolder> {

    private List<ShopItem> shopItemList;

    public CartItemsAdapter(List<ShopItem> regDataList) {
        this.shopItemList = regDataList;
    }

    @NonNull
    @Override
    public CartDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_row, parent, false);
        return new CartDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartDataViewHolder holder, int position) {
        holder.name.setText(shopItemList.get(position).getItemName());
        holder.price.setText(shopItemList.get(position).getItemPrice());
       // holder.county.setText(regDataList.get(position).getCounty());

    }

    @Override
    public int getItemCount() {
        return shopItemList.size();
    }


    class CartDataViewHolder extends RecyclerView.ViewHolder{
        public  TextView name, price;

        public CartDataViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);

        }


    }

}
