package com.example.touristhelp;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class HomeFeed extends AppCompatActivity {
private RecyclerView touristicPlaces ;
private SearchView searchview ;
public  TouristDataBase db ;
   private ArrayList<PlaceModel> places = new ArrayList<>() ;
   private RecycleviewAdapter adapter ;
   private ArrayList<PlaceModel> searchList ;
   private ArrayList<Images> images;
   private ArrayList PLace1images;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_feed);
        setTitle("Home Feed");
        touristicPlaces = findViewById(R.id.touristplaces);
        searchview = findViewById(R.id.searchv);


        ContentValues values =new ContentValues();

        places = new ArrayList<PlaceModel>();
        places.add(new PlaceModel("benshkaw","medea","Algeria","forest",R.drawable.benshkaw1,5,"this is the place disctiption"));
        places.add(new PlaceModel("Tamezgida","medea","Algeria","forest",000,5,"this is the place disctiption"));
        places.add(new PlaceModel("jourjoura","medea","Algeria","mountains",000,9,"this is the place disctiption"));
        places.add(new PlaceModel("Tibhirin","medea","Algeria","monumant",000,10,"this is the place disctiption"));
 //idea put all image in list and for each place give 5 place and make a loop
        images = new ArrayList<>();
        images.add(new Images(R.drawable.benshkaw1));
        images.add(new Images(R.drawable.benshkaw2));
        images.add(new Images(R.drawable.benshkaw3));
        images.add(new Images(R.drawable.benshkaw4));
        images.add(new Images(R.drawable.benshkaw5));
        places.get(0).setImages(images);

         //  db = new TouristDataBase(this);
//
//       for(int i=0 ;i<places.size();i++){
//           db.addOnePlace(places.get(i));
//       }
//




             //the recycleveiw managing to view all places
        touristicPlaces.setLayoutManager(new LinearLayoutManager(HomeFeed.this));
        adapter = new RecycleviewAdapter(this,places);
       adapter.setPlaces(places);
        touristicPlaces.setAdapter(adapter);


    searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
         //   places= (ArrayList<PlaceModel>) db.viewAll();
            searchList =new ArrayList<>();
            for(int a =0 ;a<places.size(); a++){
                if(places.get(a).getName().toUpperCase().contains(query.toUpperCase())){
                    searchList.add(places.get(a));
                }
            }
            touristicPlaces.setLayoutManager(new LinearLayoutManager(HomeFeed.this));
            adapter.setPlaces(searchList);
            touristicPlaces.setAdapter(adapter);
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    });
    searchview.setOnCloseListener(new SearchView.OnCloseListener() {
        @Override
        public boolean onClose() {
            touristicPlaces.setLayoutManager(new LinearLayoutManager(HomeFeed.this));
            adapter.setPlaces(places);
            touristicPlaces.setAdapter(adapter);
            return true;
        }
    });
    }

    public void fillin(){
        PLace1images.add(R.drawable.background2);
    }
}