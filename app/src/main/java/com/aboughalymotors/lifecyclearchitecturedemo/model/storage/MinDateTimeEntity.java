package com.aboughalymotors.lifecyclearchitecturedemo.model.storage;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Toqa on 11/9/2017.
 */

@Entity
public class MinDateTimeEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String date;

    ////CONSTRUCTORS
    public MinDateTimeEntity(String date) {
        this.date = date;
    }

    ////GETTERS & SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
