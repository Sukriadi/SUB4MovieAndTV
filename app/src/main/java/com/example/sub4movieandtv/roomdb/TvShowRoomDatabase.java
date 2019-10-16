package com.example.sub4movieandtv.roomdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.sub4movieandtv.roomtvshow.TvShow;
import com.example.sub4movieandtv.roomtvshow.TvShowDao;

@Database(entities = {TvShow.class}, version = 1, exportSchema = false)
public abstract class TvShowRoomDatabase extends RoomDatabase {
    public abstract TvShowDao tvShowDao();

    private static TvShowRoomDatabase INSTANCE;

    public static TvShowRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TvShowRoomDatabase.class) {
                if (INSTANCE == null) { //create database name, my db name is : mymovies_database
                    INSTANCE = Room.databaseBuilder(context, TvShowRoomDatabase.class, "mytvshow_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}