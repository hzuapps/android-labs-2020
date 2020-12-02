package com.example.thefirst.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class STORE {
    @PrimaryKey
    @ColumnInfo(name="storeID")
    private int storeId;
    @ColumnInfo(name="storeName")
    private String storeName;
    @ColumnInfo(name="phone")
    private String phone;
    @ColumnInfo(name="address")
    private String address;
    @ColumnInfo(name="introduction")
    private String introduction;
    @ColumnInfo(name="picture")
    private String picture;
}
