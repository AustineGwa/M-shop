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

    List<ShopItem> regDataList;

    public CartItemsAdapter(List<ShopItem> regDataList) {
        this.regDataList = regDataList;
    }

    @NonNull
    @Override
    public CartDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reg_data_row, parent, false);
        CartDataViewHolder regDataViewHolder = new CartDataViewHolder(view);
        return regDataViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartDataViewHolder holder, int position) {
        holder.name.setText(regDataList.get(position).getItemName());
        holder.price.setText(regDataList.get(position).getItemPrice());
       // holder.county.setText(regDataList.get(position).getCounty());

    }

    @Override
    public int getItemCount() {
        return regDataList.size();
    }


    class CartDataViewHolder extends RecyclerView.ViewHolder{
        public  TextView name, price;

        public CartDataViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.gender);
           // image = itemView.findViewById(R.id.county);
        }


    }

}
