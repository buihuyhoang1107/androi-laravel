package com.example.food_2.Model;

import java.io.Serializable;

public class
VungMienModel implements Serializable {
    private int id;
    private String ten_vungmien;
    private String noidung;

    public VungMienModel() {
    }

    public VungMienModel(int id, String ten_vungmien, String noidung) {
        this.id = id;
        this.ten_vungmien = ten_vungmien;
        this.noidung = noidung;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen_vungmien() {
        return ten_vungmien;
    }

    public void setTen_vungmien(String ten_vungmien) {
        this.ten_vungmien = ten_vungmien;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }
}
