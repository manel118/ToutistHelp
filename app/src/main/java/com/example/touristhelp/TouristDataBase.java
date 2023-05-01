package com.example.touristhelp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.text.Format;
import java.util.ArrayList;
import java.util.List;

public class TouristDataBase extends SQLiteOpenHelper {
    public static final String IMAGES_TABLE = "images_table";
    public static final String PLACE_DICTIPTION = "Place_dictiption";
    public static final String IMAGE_ID = "image_id";
    public static final String IMAGE_PATH = "image_path";
    private Context context ;

    public final static String Place_Table = "Place_Table" ;
    public static final String Place_id = "Place_id";

    public final static String Place_Name = "Place_Name" ;
    public final static String Place_Country = "Place_Country" ;
    public final static String Place_Provence = "Place_Provence" ;
    public final static String Place_img = "Place_img" ;
    public final static String Place_Ctegory = "Place_Ctegory" ;
    public final static String Place_Rate = "Place_Rate" ;

    public final static String Tourist_Table = "Guide_Table" ;
    public final static String Tourist_Name = "Tourist_Name" ;
    public final static String Tourist_Preference = "Guide_Preference" ;

    public final static String Guide_Table = "Guide_Table" ;
    public final static String Guide_id = "Guide_id" ;

    public final static String Guide_Name = "Guide_Name" ;
    public final static String Guide_Country = "Guide_Country" ;
    public final static String Guide_Provence = "Guide_Provence" ;
    public final static String Guide_Phone = "Guide_Phone" ;
    public final static String Guide_Email = "Guide_Email" ;
    public final static String Tourist_Prefernce = "Guide_prefernce" ;

    public final static String Prefernce = "Prefernce" ;
    public static final String PREFERENCE_ID = "Preference_ID";


    public TouristDataBase(@Nullable Context context) {
        super(context,"tourist.db",null,1);
        this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      String CreateDataBaseStatement1 = "CREATE TABLE "+Tourist_Table+" ("+Tourist_Name+" TEXT , "+Tourist_Preference+" TEXT )";
      String CreateDataBaseStatement2 = "CREATE TABLE "+ Place_Table+" ("+Place_id+" INTEGER PRIMARY KEY AUTOINCREMENT,"+Place_Name+" TEXT unique ,"+Place_Country+" TEXT,"+Place_Provence+" TEXT, "+Place_Ctegory+" TEXT, "+Place_img+" INTEGER ,"+Place_Rate+ " INTEGER ," + PLACE_DICTIPTION + " TEXT )";
      String CreateDataBaseStatement3 = "CREATE TABLE " + IMAGES_TABLE + " (" + IMAGE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + IMAGE_PATH + " TEXT NOT NULL ," + Place_id + " Integer , FOREIGN KEY ( "+Place_id+" ) REFERENCES " + Place_Table +" ( "+Place_id+" ))";
     // String CreateDataBaseStatement4 = "CREATE TABLE " + Guide_Table+ "("+ Guide_id + " INTEGER PRIMARY KEY AUTOINCREMENT,"+Guide_Name+" TEXT,"+Guide_Country +" TEXT, "+Guide_Provence+" TEXT,"+Guide_Email+" EMAIL ,"+Guide_Phone+" NUMBER,"+Guide_Provence+" TEXT)";
    //  String CreateDataBaseStatement5 = " CREATE TABLE "+ Prefernce + "( " + PREFERENCE_ID + "INTEGER PRIMARY KEY , FOREINKEY "+PREFERENCE_ID+ " REFERENCES "+Place_id;
      db.execSQL(CreateDataBaseStatement1);
      db.execSQL(CreateDataBaseStatement2);
      db.execSQL(CreateDataBaseStatement3);
     // db.execSQL(CreateDataBaseStatement4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Place_Table+";");
        db.execSQL("DROP TABLE IF EXISTS " + Guide_Table+";");
        db.execSQL("DROP TABLE IF EXISTS " + IMAGES_TABLE+";");
        db.execSQL("DROP TABLE IF EXISTS " + Tourist_Table+";");
        onCreate(db);
    }

    public void addOnePlace(PlaceModel model){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Place_id, "NUll");
        cv.put(Place_Name,model.getName());
        cv.put(Place_Provence,model.getProvence());
        cv.put(Place_Country,model.getCountry());
        cv.put(Place_Ctegory,model.getCategory());
        cv.put(Place_img,model.getImagUrl());

        long PlaceID = db.insert(Place_Table,null,cv);
//
//        ArrayList<Images> imgs = model.getImages();
//        if(imgs!=null)
//        {
//            for(Images i:imgs){
//                ContentValues imgvalu = new ContentValues();
//                 imgvalu.put(Place_id,PlaceID);
//                 imgvalu.put(IMAGE_PATH,i.imageName);
//                 db.insert(IMAGES_TABLE,null,imgvalu);
//            }
//        }


    }
    public ArrayList<Images> getTheImages(int placeID){
        ArrayList<Images> result = new ArrayList<>();
        SQLiteDatabase  db = this.getReadableDatabase();
        String query = "SELECT "+IMAGE_PATH+" FROM "+IMAGES_TABLE +" WHERE "+Place_id +"="+placeID;
               Cursor cursor =db.rawQuery(query,null);

               if(cursor.moveToFirst()){
                   do{
                       int path = cursor.getInt(1);
                   result.add(new Images(path));

                   }while (cursor.moveToNext());
               }
               cursor.close();
               return result ;
    }

    public ArrayList<PlaceModel> viewAll () {
        ArrayList<PlaceModel> result = new ArrayList<PlaceModel>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = " SELECT * FROM "+ Place_Table;
        Cursor cursor = db.rawQuery(query,null);

        if( cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String name=cursor.getString(1) ;
                String provence=cursor.getString(2) ;
                String country=cursor.getString(3) ;
                String category =cursor.getString(4);
                int imagUrl=cursor.getInt(5) ;
                int rate=cursor.getInt(6) ;
                String disc = cursor.getString(7);
                PlaceModel placemodel = new PlaceModel(id,name,provence,country,category,imagUrl,rate,disc);
                result.add(placemodel);
            }while (cursor.moveToNext());
        }
       cursor.close();

        return result ;
    }


    public List<PlaceModel> searchPlace(String filter){
        List<PlaceModel> result = new ArrayList<PlaceModel>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query ;
        query=" SELECT * FROM "+Place_Table+" WHERE "+Place_Name+" LIKE '"+filter+"'%";
        Cursor cursor = db.rawQuery(query,null);

        if( cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String name=cursor.getString(1) ;
                String provence=cursor.getString(2) ;
                String country=cursor.getString(3) ;
                String category =cursor.getString(4);
               int imagUrl=cursor.getInt(5) ;
                int rate=cursor.getInt(6) ;
                String disc = cursor.getString(7);

        PlaceModel placemodel = new PlaceModel(id,name,provence,country,category,imagUrl,rate,disc);
           result.add(placemodel);
            }while (cursor.moveToNext());
        }
        return result ;
    }

  public void delete(){
        SQLiteDatabase db =this.getWritableDatabase();
        String qyery="DELETE FROM "+Place_Table;
                db.delete(Place_Table,null,null);

  }

}
