package com.aboughalymotors.lifecyclearchitecturedemo.model.storage;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Toqa on 11/9/2017.
 */

@Database(entities = {MinDateTimeEntity.class}, version = 1)

public abstract class AppDataBase extends RoomDatabase {

    public abstract MinDateTimeDao minDateTimeDao();
}
