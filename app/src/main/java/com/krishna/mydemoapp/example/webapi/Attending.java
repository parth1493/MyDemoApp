package com.krishna.mydemoapp.example.webapi;

import java.util.List;

/**
 * Created by krishna on 2017-08-26.
 */

class Attending {
    private long id;
    private String picture;
    private String first_name;
    private  List<Languages> languages;

    public Attending(long id, String picture, String first_name, List<Languages> languages) {
        this.id = id;
        this.picture = picture;
        this.first_name = first_name;
        this.languages = languages;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public List<Languages> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Languages> languages) {
        this.languages = languages;
    }
}
