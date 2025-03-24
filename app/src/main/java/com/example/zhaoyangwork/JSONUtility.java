package com.example.zhaoyangwork;


import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JSONUtility {

    public static List<Movie> parseJSON(Context context) {
        List<Movie> movies = new ArrayList<>();

        try {
            // Load the JSON file
            InputStream is = context.getAssets().open("movie.json");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();

            String json = new String(buffer, "UTF-8");

            // Parse JSON array
            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);

                String title = obj.optString("title", "Unknown Title");
                int year = obj.optInt("year", 0);
                String genre = obj.optString("genre", "Unknown Genre");
                String poster = obj.optString("poster", null);

                // Placeholder poster if missing
                int posterRes = (poster != null) ? R.drawable.placeholder : R.drawable.placeholder;

                movies.add(new Movie(title, year, genre, posterRes));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return movies;
    }
}