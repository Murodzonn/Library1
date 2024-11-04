package com.example.library1;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

public interface  BookDao {
    @Insert
    void insert(book book_my);

    @Query("SELECT * FROM books WHERE genre_id = :genreId")
    List<book> getBooksByGenre(int genreId);

    @Query("SELECT * FROM books")
    List<book> getAllBooks();
}
