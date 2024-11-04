package com.example.library1;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
@Entity(tableName = "books", foreignKeys = @ForeignKey(entity = genre.class,
        parentColumns = "id",
        childColumns = "genreId",
        onDelete = ForeignKey.CASCADE))
public class book {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String Year;

    private int genre_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }
}
