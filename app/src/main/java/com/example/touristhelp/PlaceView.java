package com.example.touristhelp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlaceView extends AppCompatActivity {
RecyclerView recyclerView ;
ImagesRecycleview adapter ;
TextView name ;
TextView country ;
TextView provence ;
TextView category ;
TextView discription ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_view);
        name=findViewById(R.id.Name);
        provence= findViewById(R.id.provence);
        country=findViewById(R.id.country);
        category=findViewById(R.id.category);
        discription =findViewById(R.id.disciption);
        recyclerView= findViewById(R.id.rec);
        Intent in = getIntent();
        PlaceModel place = (PlaceModel) in.getSerializableExtra("Place_model");
        ArrayList<Images> imgs =place.getImages();

         //set the values of ui
        name.setText(place.getName());
        country.setText("Paye : "+place.getCountry());
        provence.setText("ville : "+place.getProvence());
        category.setText("Catégory : "+place.getCategory());
        discription.setText(place.getDiscription());

        //set the adapter with the images we get from the database
        adapter = new ImagesRecycleview(this,imgs);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapter.setImages(imgs);
        recyclerView.setAdapter(adapter);

        Toast.makeText(getApplication(),"the img R "+ imgs.get(0).imageName,Toast.LENGTH_LONG).show();
    }
}