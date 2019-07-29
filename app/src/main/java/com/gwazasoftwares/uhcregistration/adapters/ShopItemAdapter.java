package com.gwazasoftwares.uhcregistration.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.gwazasoftwares.uhcregistration.R;
import com.gwazasoftwares.uhcregistration.SubmitOrder;
import com.gwazasoftwares.uhcregistration.ViewCart;
import com.gwazasoftwares.uhcregistration.models.ShopItem;
import com.gwazasoftwares.uhcregistration.tasks.OnCartButtonClickListener;

import java.util.List;

public class ShopItemAdapter extends RecyclerView.Adapter<ShopItemAdapter.ShopItemViewHolder> {

    private List<ShopItem> shopItemList;
    private Context context;

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
    public void onBindViewHolder(@NonNull final ShopItemViewHolder holder, int position) {
        holder.image.setImageResource(shopItemList.get(position).getItemImage());
        holder.name.setText(shopItemList.get(position).getItemName());
        holder.price.setText(shopItemList.get(position).getItemPrice());
        holder.btnAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShopItem shopItem = shopItemList.get(holder.getAdapterPosition());
                Intent intent = new Intent(context, ViewCart.class);
                intent.putExtra("shopItem", shopItem);
                context.startActivity(intent);
            }
        });
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
        }
    }
}
