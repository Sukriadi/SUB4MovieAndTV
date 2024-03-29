package com.example.sub4movieandtv.roomtvshow;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TvShowDao {
    @Insert
    void insert(TvShow tvShow);

    @Query("SELECT * FROM tvshows ORDER BY name")
    LiveData<List<TvShow>> getAllTvShowVm();

    @Query("DELETE FROM tvshows WHERE name= :name_tvshow")
    void deleteByTitle(String name_tvshow);

    @Query("DELETE FROM tvshows WHERE id= :id")
    void deleteById(int id);
}