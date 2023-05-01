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

        SharedPreferences sharedPreferences = getSharedPreferences("PREFERECE", MODE_PRIVATE);
        String FirstTime = sharedPreferences.getString("FirstTimeInstall", "");
        if (FirstTime.equals("Yes")) {
            Intent intent = new Intent(MainActivity.this, HomeFeed.class);
            startActivity(intent);

        }
        else {
            //هاذي تتكزيكوتا فقط في المرة الأولى لي يطلع فيا التطبيق في التيليفون

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
                        while (progressbar.getProgress() != progressbar.getMax());
                        h.post(new Runnable() {
                            @Override
                            public void run() {
                                Intent i = new Intent(MainActivity.this, HomeFeed.class);
                                startActivity(i);
                            }
                        });
                    }
                });
                t.start();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("FirstTimeInstall", "Yes");
                editor.apply();
            }



    }
        protected void onDestroy () {
            super.onDestroy();
            // Close the database
            db.close();
        }


    }
