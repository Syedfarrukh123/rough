package com.example.newcatalogapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void addicon(View view) {
        Intent show = new Intent(DashboardActivity.this,AddproductActivity.class) ;
        startActivity(show);
    }

    public void addproduct(View view) {
        Intent show = new Intent(DashboardActivity.this,ProductMainActivity.class) ;
        startActivity(show);

    }

    public void addcategory(View view) {
        Intent show = new Intent(DashboardActivity.this,CategoriesActivity.class) ;
        startActivity(show);
    }

    public void addshow(View view) {
        Intent show = new Intent(DashboardActivity.this,AddCategoryActivity.class) ;
        startActivity(show);
    }
}