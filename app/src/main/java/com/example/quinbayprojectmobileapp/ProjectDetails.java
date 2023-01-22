package com.example.quinbayprojectmobileapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.quinbayprojectmobileapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ProjectDetails extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_details);

        ImageSlider imageSlider;

        imageSlider =findViewById(R.id.image_slider);

        ArrayList<SlideModel> imageList = new ArrayList<>();


        imageList.add(new SlideModel(R.drawable.ic_launcher_background,null));
        imageList.add(new SlideModel(R.drawable.ic_launcher_foreground,"Add Title here",null));
        imageList.add(new SlideModel(R.drawable.ic_launcher_background,null));
        imageList.add(new SlideModel("image_url","Tittle Here",null));
        imageSlider.setImageList(imageList, ScaleTypes.CENTER_CROP);

        bottomNavigationView = findViewById(R.id.bottomNavigationMenuProductDetails);
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.cart_product_details:
                        return true;

                    case R.id.buy_now:
                        return true;
                }
                return false;
            }
        });
    }
}