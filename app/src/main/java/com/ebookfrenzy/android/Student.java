package com.ebookfrenzy.android;

/**
 * Created by tjsrk on 2017-12-04.
 */

public class Student {

    private int _id;
    private String _productname;
    private int _quantity;

    public Student() {
    }

    public Student(int id, String productname, int quantity) {
        this._id = id;
        this._productname = productname;
        this._quantity = quantity;
    }

    public Student(String productname, int quantity) {
        this._productname = productname;
        this._quantity = quantity;
    }

    public void setID(int id) {
        this._id = id;
    }

    public int getID() {
        return this._id;
    }

    public void setProductName(String productname) {
        this._productname = productname;
    }

    public String getProductName() {
        return this._productname;
    }

    public void setQuantity(int quantity) {
        this._quantity = quantity;
    }

    public int getStudent() {
        return this._quantity;
    }
}