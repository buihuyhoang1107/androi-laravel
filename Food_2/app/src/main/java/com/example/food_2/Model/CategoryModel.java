package com.example.food_2.Model;

import java.util.Date;

public class CategoryModel {
    private int id;
    private String title;
    private int action;
    private Date created_at;
    private Date updated_at;
    private String img;

    public CategoryModel(){

    }

    public CategoryModel(int id, int action, Date created_at, Date updated_at, String img) {
        this.id = id;
        this.action = action;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.img = img;
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

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
