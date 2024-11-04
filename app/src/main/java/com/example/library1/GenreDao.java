package com.example.library1;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

public class GenreDao {

    void insert(genre genre_my){

    }

    @Query("SELECT * FROM genres")

    List<genre> getAllGenres() {
        return null;
    }
}
