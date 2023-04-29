package com.example.touristhelp;

import java.io.Serializable;

public class Images implements Serializable {
    int id ;
    int imageName ;
    int place_id ;

    public Images(int id, int imagePath, int place_id) {
        this.id = id;
        this.imageName = imagePath;
        this.place_id = place_id;
    }

    public Images(int imageName) {
        this.imageName = imageName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImageName(int imageName) {
        this.imageName = imageName;
    }

    public void setPlace_id(int place_id) {
        this.place_id = place_id;
    }

    public int getImageName() {
        return imageName;
    }

    public int getId() {
        return id;
    }


    public int getPlace_id() {
        return place_id;
    }
}
