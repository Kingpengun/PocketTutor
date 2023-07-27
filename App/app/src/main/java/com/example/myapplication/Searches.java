package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.util.ArrayList;

public class Searches extends AppCompatActivity {

    ImageView imageView;
    RecyclerView recyclerView;
    ArrayList<SearchResultRow> SearchResultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searches);


        Intent intent = getIntent();
        Uri imageUri = intent.getData();
        imageView = (ImageView)findViewById(R.id.image_display);
        Bitmap bitmap = null;
        if (imageUri != null) {
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Bundle bundle = intent.getExtras();
            bitmap = bundle.getParcelable("data");
        }
        imageView.setImageBitmap(bitmap);

        searchResult("5 - 4 / 3");
        recyclerView = findViewById(R.id.SearchRV);
        SearchesAdapterClass adapterClass = new SearchesAdapterClass(this, SearchResultList);
        recyclerView.setAdapter(adapterClass);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
    public void fillSearchResult() {
        SearchResultList = new ArrayList<>();
        SearchResultRow row1 = new SearchResultRow("Cat Wiki Page", "https://en.wikipedia.org/wiki/Cat");
        SearchResultRow row2 = new SearchResultRow("Dog Wiki Page", "https://en.wikipedia.org/wiki/Dog");
        SearchResultRow row3 = new SearchResultRow("Bird Wiki Page", "https://en.wikipedia.org/wiki/Bird");
        SearchResultRow row4 = new SearchResultRow("Penguin Wiki Page", "https://en.wikipedia.org/wiki/Penguin");
        SearchResultRow row5 = new SearchResultRow("Fish Wiki Page", "https://en.wikipedia.org/wiki/Fish");
        SearchResultList.add(row1);
        SearchResultList.add(row2);
        SearchResultList.add(row3);
        SearchResultList.add(row4);
        SearchResultList.add(row5);

    }
    public void searchResult(String s) {
        SearchResultList = new ArrayList<>();
        if (s.contains("+")){
            SearchResultRow row1 = new SearchResultRow("How to add", "https://en.wikipedia.org/wiki/add");
            SearchResultList.add(row1);
        }
        if (s.contains("-")){
            SearchResultRow row1 = new SearchResultRow("How to subtract", "https://en.wikipedia.org/wiki/subtract");
            SearchResultList.add(row1);
        }
        if (s.contains("*")){
            SearchResultRow row1 = new SearchResultRow("How to multiply", "https://en.wikipedia.org/wiki/multiply");
            SearchResultList.add(row1);
        }
        if (s.contains("/")){
            SearchResultRow row1 = new SearchResultRow("How to divide", "https://en.wikipedia.org/wiki/divide");
            SearchResultList.add(row1);
        }
    }

}