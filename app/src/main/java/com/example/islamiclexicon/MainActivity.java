package com.example.islamiclexicon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.islamiclexicon.Adapter.SearchAdapter;
import com.example.islamiclexicon.Database.Database;
import com.google.android.material.search.SearchBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    SearchAdapter adapter;

    com.google.android.material.search.SearchBar searchBar;
    List<String> suggestList = new ArrayList<>();

    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init View
        recyclerView = (RecyclerView)findViewById(R.id.recycler_search);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        searchBar  = (com.google.android.material.search.SearchBar) findViewById(R.id.search_bar);

        //Init DB
        database = new Database(this);

        //Setup Search bar
        searchBar.setHint("Search");
        loadSuggestList();
        searchBar.setOnS

    }

    private void loadSuggestList() {
        suggestList = database.getArabic_word();

    }
}