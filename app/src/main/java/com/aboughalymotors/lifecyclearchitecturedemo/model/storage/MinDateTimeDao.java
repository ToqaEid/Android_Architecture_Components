package com.aboughalymotors.lifecyclearchitecturedemo.model.storage;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Toqa on 11/9/2017.
 */

@Dao
public interface MinDateTimeDao {

    @Insert
    void insertDate(MinDateTimeEntity date);

    @Query("SELECT date FROM MinDateTimeEntity")
    List<String> getMinDateTime();

}
