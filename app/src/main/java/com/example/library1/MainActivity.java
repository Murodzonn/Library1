package com.example.library1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppDatabase db;
    private GenreDao genreDao;
    private BookDao bookDao;

    private ListView listView;
    private ImageButton btnAdd;
    private ArrayAdapter<String> adapter;
    private List<book> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getDatabase(getApplicationContext());
        genreDao = db.genreDao();
        bookDao = db.bookDao();

        listView = findViewById(R.id.listView);
        btnAdd = findViewById(R.id.btnAdd);

        loadBooks();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Открытие активности для добавления книги
                Intent intent = new Intent(MainActivity.this, AddBook.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Открытие активности для отображения деталей книги
                Intent intent = new Intent(MainActivity.this, MyBook.class);
                intent.putExtra("bookId", bookList.get(position).getId()); // Передаем id книги
                startActivity(intent);
            }
        });
    }

    private void loadBooks() {
        new Thread(() -> {
            bookList = bookDao.getAllBooks();
            runOnUiThread(() -> {
                String[] bookTitles = new String[bookList.size()];
                for (int i = 0; i < bookList.size(); i++) {
                    bookTitles[i] = bookList.get(i).getTitle();
                }
                adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, bookTitles);
                listView.setAdapter(adapter);
            });
        }).start();
    }
}
