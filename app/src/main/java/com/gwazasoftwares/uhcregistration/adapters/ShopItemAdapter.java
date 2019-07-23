package com.gwazasoftwares.uhcregistration.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gwazasoftwares.uhcregistration.R;
import com.gwazasoftwares.uhcregistration.models.ShopItem;
import com.gwazasoftwares.uhcregistration.utils.Functions;

import java.util.List;

public class ShopItemAdapter extends RecyclerView.Adapter<ShopItemAdapter.ShopItemViewHolder> {

    List<ShopItem> shopItemList;
    Context context;

    public ShopItemAdapter(List<ShopItem> shopItemList, Context context) {
        this.shopItemList = shopItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ShopItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_item_row, parent,false);
        ShopItemViewHolder shopItemViewHolder = new ShopItemViewHolder(view);
        return shopItemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShopItemViewHolder holder, int position) {
        holder.image.setImageResource(shopItemList.get(position).getItemImage());
        holder.name.setText(shopItemList.get(position).getItemName());
        holder.price.setText(shopItemList.get(position).getItemPrice());
    }

    @Override
    public int getItemCount() {
        return shopItemList.size();
    }


    class ShopItemViewHolder extends RecyclerView.ViewHolder{

        ImageButton btnAddCart;
        TextView name,price;
        ImageView image;
        public ShopItemViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            image = itemView.findViewById(R.id.image);
            btnAddCart = itemView.findViewById(R.id.btn_add_cart);

            btnAddCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Functions.addItemToCart(context,getAdapterPosition());
                }
            });
        }
    }
}
