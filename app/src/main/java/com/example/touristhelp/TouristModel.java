package com.example.touristhelp;

public class TouristModel {
    int id ;
    String name ;
    String preference ;

    public TouristModel(int id, String name, String preference) {
        this.id = id;
        this.name = name;
        this.preference = preference;
    }

    public TouristModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPreference() {
        return preference;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }
}
