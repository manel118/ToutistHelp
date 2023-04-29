package com.example.touristhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
private ProgressBar progressbar ;

private TouristDataBase db ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("PREFERECE",MODE_PRIVATE);
        String FirstTime = sharedPreferences.getString( "FirstTimeInstall", "");
        if(FirstTime.equals("Yes"))
        {
            Intent intent = new Intent(  MainActivity.this,HomeFeed.class);
            startActivity(intent);

        }else
        {

//            ArrayList<PlaceModel> places = new ArrayList<PlaceModel>();
//            places.add(new PlaceModel("benshkaw","medea","Algeria","forest","https://www.wisaplywood.com/contentassets/d4b728c319fa4182941ec06139e6115c/upm-plywood-healthy-trees.jpg",5,"this is the place disctiption"));
//            places.add(new PlaceModel("Tamezgida","medea","Algeria","forest","https://insideclimatenews.org/wp-content/uploads/2022/11/forests-beech.jpg",5,"this is the place disctiption"));
//            places.add(new PlaceModel("jourjoura","medea","Algeria","mountains","https://crosscut.com/sites/default/files/images/articles/old_growth_hero.jpg",9,"this is the place disctiption"));
//            places.add(new PlaceModel("Tibhirin","medea","Algeria","monumant","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRELa3BpZlKXtyUwgUueydSlBPoUyiZLfFmRLFa_Sdf&s",10,"this is the place disctiption"));
//
//            //inintialize the database
//            db =new TouristDataBase(this);
//            //fill in the database
//            for(int i=0 ;i<places.size();i++){
//                db.addOnePlace(places.get(i));
//            }


            progressbar = findViewById(R.id.progress);

            setTitle("Home");
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    Handler h = new Handler(Looper.getMainLooper());
                    do {
                        progressbar.incrementProgressBy(30);
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    while(progressbar.getProgress()!=progressbar.getMax());
                    h.post(new Runnable() {
                        @Override
                        public void run() {
                            Intent i = new Intent(MainActivity.this,HomeFeed.class);
                            startActivity(i);
                        }
                    });
                }
            }); t.start();

            SharedPreferences.Editor editor =sharedPreferences.edit();
            editor.putString( "FirstTimeInstall","Yes");
            editor.apply();
        }


        }

    protected void onDestroy() {
        super.onDestroy();
        // Close the database
        db.close();
    }



}