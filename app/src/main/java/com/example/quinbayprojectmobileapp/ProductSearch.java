package com.example.quinbayprojectmobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quinbayprojectmobileapp.adapter.ProductAdapter;
import com.example.quinbayprojectmobileapp.application.ApplicationClass;
import com.example.quinbayprojectmobileapp.model.Products;
import com.example.quinbayprojectmobileapp.network.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductSearch extends AppCompatActivity implements ProductAdapter.OnClickInterface {

    int page=1;
    List<Products> productsItems = new ArrayList<>();
    ProgressBar progressBarStart;
    ProgressBar progressBarEnd;
    RecyclerView ProductRv;

    ProductAdapter productAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_search);
        ProductRv = findViewById(R.id.product_recycler_view);

        //<---------------Progress Bar----------------------------------->

        progressBarStart=findViewById(R.id.pb_start_progress_bar);
        progressBarEnd=findViewById(R.id.pb_end_progress_bar);

        //<---------------Progress Bar----------------------------------->


        //<---------------Toolbar----------------------------------->
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //<---------------Toolbar----------------------------------->



        //<---------------Search Term----------------------------------->
        Intent intent = getIntent();
        String searchValue = intent.getStringExtra("searchValue");
        EditText setSearchValue = findViewById(R.id.et_search_Value_rv);
        setSearchValue.setText(searchValue);
        ImageView searchImage = findViewById(R.id.search_image_view);
        //TextView searchText = findViewById(R.id.et_search_Value_rv);
        //String searchValueRv = searchText.getText().toString();
        //<---------------Search Term----------------------------------->

        //<---------------on click listener----------------------------------->
        searchImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //searchValue=searchText;
            }
        });

        //<---------------on click listener----------------------------------->

        ApiInterface apiInterface = ((ApplicationClass) getApplication()).retrofit.create(ApiInterface.class);
        progressBarStart.setVisibility(View.VISIBLE);
        apiInterface.getProducts(searchValue,20,0).enqueue(new Callback<Products>() {
            @Override
            public void onResponse(Call<Products> call, Response<Products> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.i("success", "" + response.body().toString());


                    if (productsItems != null) {
                        productsItems.add(response.body());
                        ProductRv.setAdapter(productAdapter);
                        //ProductRv.setAdapter(new ProductAdapter(productsItems, ProductRecyclerView.this,"linear"));
                        //ProductRv.setAdapter(new ProductAdapter(productsItems, ProductRecyclerView.this));
                        //ProductRv.setLayoutManager(new LinearLayoutManager(ProductRv.getContext()));
                        progressBarStart.setVisibility(View.GONE);
                    } else {
                        Toast.makeText(ProductSearch.this, "Not Found", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } else {
                    Toast.makeText(ProductSearch.this, "Not Found", Toast.LENGTH_SHORT).show();
                    //finish();
                }
            }

            @Override
            public void onFailure(Call<Products> call, Throwable t) {
                Log.i("Failed here", "failure " + t.getMessage());

            }
        });
        ProductRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (!recyclerView.canScrollVertically(1)) {
                    progressBarEnd.setVisibility(View.VISIBLE);

                    //Toast.makeText(ProductRecyclerView.this, "Last", Toast.LENGTH_LONG).show();
                    apiInterface.getProducts(searchValue,20,0).enqueue(new Callback<Products>() {
                        @Override
                        public void onResponse(Call<Products> call, Response<Products> response) {
                            if (response.isSuccessful() && response.body() != null) {
                                Log.i("success", "" + response.body().toString());
                                int positionStart = productsItems.size();
                                    productsItems.add(response.body());
                                progressBarEnd.setVisibility(View.GONE);
                                //productAdapterLiner.notifyItemRangeInserted(positionStart, data.getProducts().size());
                                //productAdapterGrid.notifyItemRangeInserted(positionStart, data.getProducts().size());
                                //productAdapterStaggered.notifyItemRangeInserted(positionStart, data.getProducts().size());
                                ProductRv.setAdapter(new ProductAdapter(productsItems, ProductSearch.this));
                                //ProductRv.setLayoutManager(new LinearLayoutManager(ProductRv.getContext()));
                                page = page + 1;
                            } else {
                                Toast.makeText(ProductSearch.this, "Not Found", Toast.LENGTH_SHORT).show();
                                progressBarEnd.setVisibility(View.GONE);
                            }
                        }

                        @Override
                        public void onFailure(Call<Products> call, Throwable t) {
                            Log.e("Failed here", "failure " + t.getMessage());

                        }
                    });

                }
            }
        });


         ProductRv.setLayoutManager(new LinearLayoutManager(ProductRv.getContext()));


    }

    @Override
    public void onCardClick(Products productsItem,int position) {
        Intent cardClickIntent = new Intent(ProductSearch.this, ProjectDetails.class);
        cardClickIntent.putExtra("productName", productsItem.getProductName());
        cardClickIntent.putExtra("productRating", String.valueOf(productsItem.getProductRating()));
        cardClickIntent.putExtra("productPrice", productsItem.getProductPrice());
        cardClickIntent.putExtra("productImage", productsItem.getImageUrl().get(0));
        cardClickIntent.putExtra("productObject", productsItem);
        cardClickIntent.putExtra("whereFrom", "fromProduct");

        startActivity(cardClickIntent);

    }

    @Override
    public void onButtonClick(Products productsItem,int position) {

        Intent cardButtonIntent = new Intent(ProductSearch.this, ProjectDetails.class);
        cardButtonIntent.putExtra("productName", productsItem.getProductName());
        cardButtonIntent.putExtra("productRating", String.valueOf(productsItem.getProductRating()));
        cardButtonIntent.putExtra("productPrice", productsItem.getProductPrice());
        cardButtonIntent.putExtra("productImage", productsItem.getImageUrl().get(0));
        cardButtonIntent.putExtra("productObject", productsItem);
        cardButtonIntent.putExtra("whereFrom", "fromProduct");

        startActivity(cardButtonIntent);

    }
}