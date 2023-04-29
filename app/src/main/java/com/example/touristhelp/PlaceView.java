package com.example.touristhelp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class PlaceView extends AppCompatActivity {
RecyclerView recyclerView ;
ImagesRecycleview adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_view);
        Intent in = getIntent();
        PlaceModel place = (PlaceModel) in.getSerializableExtra("Place_model");

       ArrayList<Images> imgs =place.getImages();
        recyclerView= findViewById(R.id.rec);

        //set the adapter with the images we get from the database

        adapter = new ImagesRecycleview(this,imgs);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapter.setImages(imgs);
        recyclerView.setAdapter(adapter);
        Toast.makeText(getApplication(),"the img R "+ imgs.get(0).imageName,Toast.LENGTH_LONG).show();
    }
}