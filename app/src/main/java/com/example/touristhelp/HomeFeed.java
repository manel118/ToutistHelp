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
   private final int numberOfPlaces=15 ;



//هذا الملف تع الصفحة الثانية لي فيها جميع الأماكن

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_feed);
        setTitle("Home Feed");
        touristicPlaces = findViewById(R.id.touristplaces);
        searchview = findViewById(R.id.searchv);


//هنا القائمة لي تحطو فيها المعلومات تع الأماكن ومنهم الصورة الأولى اللي تظهر مع الأول
// طلعو التصاور تع جميع الأماكن في البروجي وحددو id تع البلاسة في constructeur
        //like that : R.id.NomDePhoto
        places = new ArrayList<PlaceModel>();
        places.add(new PlaceModel("benshkaw","medea","Algeria","forest",R.drawable.benshkaw1,5,"this is the place disctiption"));
        places.add(new PlaceModel("Ain Errich","M'sila","Algeria","chutes",R.drawable.ain_errich,5,"this is the place disctipition"));
        places.add(new PlaceModel("Beni Add","Tlemcen","Algeria","grotte",R.drawable.beni_add,5,"this is the place disctipition"));
        places.add(new PlaceModel("Bordj Zemoura","Bordj Bou Arreridj","Algeria","Tour",R.drawable.borj_zemoura,5,"this is the place disctipition"));
        places.add(new PlaceModel("Ziama mansouria","Jijel","Algeria","vallée",R.drawable.mansouriah,5,"this is the place disctipition"));
        places.add(new PlaceModel("Tassili","Illizi","Algeria","montagnes",R.drawable.tassili,5,"this is the place disctipition"));
        places.add(new PlaceModel("Tamezgida","medea","Algeria","forest",000,5,"this is the place disctiption"));
        places.add(new PlaceModel("jourjoura","medea","Algeria","mountains",000,9,"this is the place disctiption"));
        places.add(new PlaceModel("Tibhirin","medea","Algeria","monumant",000,10,"this is the place disctiption"));

        //كل بلاسة عندها 5 صور حطو الصور كلها في القائمة 5 ب5 معناها تع كل بلاسة يجو بالترتيب

        images = new ArrayList<>();
        //تع المكان 1
        images.add(new Images(R.drawable.benshkaw1));
        images.add(new Images(R.drawable.benshkaw2));
        images.add(new Images(R.drawable.benshkaw3));
        images.add(new Images(R.drawable.benshkaw4));
        images.add(new Images(R.drawable.benshkaw5));
        //تع المكان الثاني ....
        images.add(new Images(R.drawable.ain_errich1));
        images.add(new Images(R.drawable.ain_errich2));
        images.add(new Images(R.drawable.ain_errich3));
        images.add(new Images(R.drawable.ain_errich4));
        images.add(new Images(R.drawable.ain_errich5));
        //المكان الثالث
        images.add(new Images(R.drawable.beni_add1));
        images.add(new Images(R.drawable.beni_add2));
        images.add(new Images(R.drawable.beni_add3));
        images.add(new Images(R.drawable.beni_add4));
        images.add(new Images(R.drawable.beni_add5));
        //المكان الرابع
        images.add(new Images(R.drawable.borj_zemoura1));
        images.add(new Images(R.drawable.borj_zemoura2));
        images.add(new Images(R.drawable.borj_zemoura3));
        images.add(new Images(R.drawable.borj_zemoura4));
        images.add(new Images(R.drawable.borj_zemoura5));
        //المكان الخامس
        images.add(new Images(R.drawable.mansouriah1));
        images.add(new Images(R.drawable.mansouriah2));
        images.add(new Images(R.drawable.mansouriah3));
        images.add(new Images(R.drawable.mansouriah4));
        images.add(new Images(R.drawable.mansouriah5));
        //المكان السادس
        images.add(new Images(R.drawable.tassili1));
        images.add(new Images(R.drawable.tassili2));
        images.add(new Images(R.drawable.tassili3));
        images.add(new Images(R.drawable.tassili4));
        images.add(new Images(R.drawable.tassili5));

        //هنا نحطو لكل مكان الصور تاوعو
        //تأكدو بلي كل مكان عندو بالضبط 5 صور غير الصورة اللي تبان مع الأول
    fillImages();


        //the recycleveiw managing to view all places
        touristicPlaces.setLayoutManager(new LinearLayoutManager(HomeFeed.this));
        adapter = new RecycleviewAdapter(this,places);
       adapter.setPlaces(places);
        touristicPlaces.setAdapter(adapter);

// هنا الإعدادات تع البحث
    searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
       //this is the method of research
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
    //هنا الإعدادات تع البحث عند ضغط علامة x
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

    public void fillImages(){
        int j=0 ;
        for(int i=0;i<numberOfPlaces;i++){
            while(j<(i+1)*5){
                places.get(i).addImages(images.get(j));
            }
            j++;
        }
    }
}