package com.example.food_2.Model;

public class BaiVietModel {
    private int id;
    private String ten;
    private String nguyenlieu;
    private String soche;
    private String thuchien;
    private String cachdung;
    private int category_id;
    private int vungmien_id;
    private String noidung;
    private String hinhanh;

    public BaiVietModel() {
    }

    public BaiVietModel(int id, String ten, String nguyenlieu, String soche, String thuchien, String cachdung, int category_id, int vungmien_id, String noidung, String hinhanh) {
        this.id = id;
        this.ten = ten;
        this.nguyenlieu = nguyenlieu;
        this.soche = soche;
        this.thuchien = thuchien;
        this.cachdung = cachdung;
        this.category_id = category_id;
        this.vungmien_id = vungmien_id;
        this.noidung = noidung;
        this.hinhanh = hinhanh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNguyenlieu() {
        return nguyenlieu;
    }

    public void setNguyenlieu(String nguyenlieu) {
        this.nguyenlieu = nguyenlieu;
    }

    public String getSoche() {
        return soche;
    }

    public void setSoche(String soche) {
        this.soche = soche;
    }

    public String getThuchien() {
        return thuchien;
    }

    public void setThuchien(String thuchien) {
        this.thuchien = thuchien;
    }

    public String getCachdung() {
        return cachdung;
    }

    public void setCachdung(String cachdung) {
        this.cachdung = cachdung;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getVungmien_id() {
        return vungmien_id;
    }

    public void setVungmien_id(int vungmien_id) {
        this.vungmien_id = vungmien_id;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }
}
