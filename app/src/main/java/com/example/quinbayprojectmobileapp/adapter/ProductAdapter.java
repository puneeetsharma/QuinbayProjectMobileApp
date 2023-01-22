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

public class ProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.linear_card_layout, parent, false);
        return new CoustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CoustomViewHolder extends RecyclerView.ViewHolder
    {
        View itemView;
        Button seeDetailsButton;

        public CoustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView=itemView;

            //seeDetailsButton=itemView.findViewById(R.id.btn_see_details);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
            seeDetailsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        }
        public void bind()
        {

        }
    }


    public interface OnClickInterface
    {
        void onCardClick(int position);
        void onButtonClick(int position);
    }

}

