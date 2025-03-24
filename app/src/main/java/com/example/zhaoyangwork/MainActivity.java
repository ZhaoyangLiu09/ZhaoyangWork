package com.example.zhaoyangwork;


import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        try {
            // Load movies
            List<Movie> movies = JSONUtility.parseJSON(this);

            // Handle empty list
            if (movies.isEmpty()) {
                Toast.makeText(this, "No movies available", Toast.LENGTH_SHORT).show();
            } else {
                adapter = new MovieAdapter(movies);
                recyclerView.setAdapter(adapter);
            }
        } catch (Exception e) {
            Toast.makeText(this, "Error loading movies", Toast.LENGTH_SHORT).show();
        }
    }
}