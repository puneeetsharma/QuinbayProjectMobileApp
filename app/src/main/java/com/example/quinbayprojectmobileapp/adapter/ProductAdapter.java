package com.example.quinbayprojectmobileapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.quinbayprojectmobileapp.R;
import com.example.quinbayprojectmobileapp.model.Products;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Products> productsItems;

    OnClickInterface onClickInterface;

    public ProductAdapter(List<Products> productsItems,OnClickInterface onClickInterface)
    {
        this.productsItems=productsItems;
        this.onClickInterface=onClickInterface;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.linear_card_layout, parent, false);
        return new CoustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //holder.bind(productsItems.get(position));
    }

    @Override
    public int getItemCount() {
        return productsItems.size();
    }

    public class CoustomViewHolder extends RecyclerView.ViewHolder
    {
        View itemView;
        Button seeDetailsButton;

        public CoustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView=itemView;

            seeDetailsButton=itemView.findViewById(R.id.btn_see_details);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickInterface.onCardClick(productsItems.get(getAdapterPosition()),getAdapterPosition());
                }
            });
            seeDetailsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickInterface.onButtonClick(productsItems.get(getAdapterPosition()),getAdapterPosition());
                }
            });
        }
        public void bind(Products productsItem)
        {
            TextView productName = itemView.findViewById(R.id.product_name);
            TextView productRating = itemView.findViewById(R.id.product_rating);
            TextView productPrice = itemView.findViewById(R.id.price);
            ImageView productImage = itemView.findViewById(R.id.product_image);
            productName.setText(productsItem.getProductName());
            productRating.setText(String.valueOf(productsItem.getProductRating()));
            productPrice.setText(String.valueOf(productsItem.getProductPrice()));
            Glide.with(productImage.getContext())
                    .load(productsItem.getImageUrl().get(0))
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(productImage);

        }
    }


    public interface OnClickInterface
    {
        void onCardClick(Products productsItem,int position);
        void onButtonClick(Products productsItem,int position);
    }

}

