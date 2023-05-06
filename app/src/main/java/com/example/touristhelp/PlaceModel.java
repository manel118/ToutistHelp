package com.example.touristhelp;

import android.content.res.Resources;

import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;

import java.io.Serializable;
import java.util.ArrayList;

public class PlaceModel implements Serializable {
    int id;
    String name;
    String provence;
    String country;
    int imagUrl;

    String category;
    int rate;
    ArrayList<Images> Images  ;
    String discription ;
    String LinkToMaps ;

    public void setLinkToMaps(String linkToMaps) {
        LinkToMaps = linkToMaps;
    }

    public String getLinkToMaps() {
        return LinkToMaps;
    }

    public PlaceModel(int id, String name, String provence, String country, String category, int imagUrl, int rate , String discription ) {
        this.id = id;
        this.name = name;
        this.provence = provence;
        this.country = country;
        this.imagUrl = imagUrl;
        this.category = category;
        this.rate = rate;


    }

    public PlaceModel(String name, String provence, String country,  String category,int imagUrl ,int rate, String discription) {
        this.name = name;
        this.provence = provence;
        this.country = country;
        this.imagUrl = imagUrl;
        this.category = category;
        this.rate = rate;
        this.discription = discription;
        Images=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProvence() {
        return provence;
    }

    public String getCountry() {
        return country;
    }

    public String getCategory() {
        return category;
    }

    public int getRate() {
        return rate;
    }

    public int getImagUrl() {
        return imagUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProvence(String provence) {
        this.provence = provence;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setImagUrl(int imagUrl) {
        this.imagUrl = imagUrl;
    }

    public ArrayList<com.example.touristhelp.Images> getImages() {
        return Images;
    }

    public void addImages(Images images) {
        this.Images.add(images);

    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}

