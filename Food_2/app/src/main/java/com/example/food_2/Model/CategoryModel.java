package com.example.food_2.Model;

import java.io.Serializable;
import java.util.Date;

public class CategoryModel implements Serializable {
    private int id;
    private String title;
    private String img;

    public CategoryModel(){

    }

    public CategoryModel(int id,String title, String img) {
        this.id = id;
        this.img = img;
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
