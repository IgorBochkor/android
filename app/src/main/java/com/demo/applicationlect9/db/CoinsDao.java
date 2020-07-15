package com.demo.applicationlect9.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.demo.applicationlect9.Coin;

import java.util.List;

@Dao
public interface CoinsDao {

    @Insert
    void insert(Coin coin);

    @Insert
    void insertAll(List<Coin> coin);

    @Delete
    void delete(Coin coin);

    @Query("SELECT * from coins")
    List<Coin> getAll();

    @Query("SELECT * from coins WHERE simbol = :id")
    Coin get (String id);
}
