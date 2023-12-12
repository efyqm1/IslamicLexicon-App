package com.example.islamiclexicon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.islamiclexicon.Adapter.SearchAdapter;
import com.example.islamiclexicon.Database.Database;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // RecyclerView to display search results
    RecyclerView recyclerView;

    // LayoutManager for RecyclerView
    RecyclerView.LayoutManager layoutManager;

    // Adapter for populating RecyclerView with search results
    SearchAdapter adapter;

    // MaterialSearchBar for search input and suggestions
    MaterialSearchBar materialSearchBar;

    // List to store search suggestions
    List<String> suggestList = new ArrayList<>();

    // Database instance to handle data operations
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recycler_search);

        // Set up the LayoutManager for the RecyclerView
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        // Initialize MaterialSearchBar
        materialSearchBar = (MaterialSearchBar) findViewById(R.id.search_bar);

        // Initialize the database
        database = new Database(this);

        // Set up MaterialSearchBar properties
        materialSearchBar.setHint("Search");
        materialSearchBar.setCardViewElevation(10);

        // Load initial suggestions for the search bar
        loadSuggestList();

        // Add a TextWatcher to dynamically update search suggestions
        materialSearchBar.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not used in this implementation
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Dynamically update suggestions based on user input
                List<String> suggest = new ArrayList<>();
                for (String search : suggestList) {
                    if (search.toLowerCase().contains(materialSearchBar.getText().toLowerCase())) {
                        suggest.add(search);
                    }
                }
                materialSearchBar.setLastSuggestions(suggest);
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Not used in this implementation
            }
        });

        // Set up MaterialSearchBar listeners for search actions
        materialSearchBar.setOnSearchActionListener(new MaterialSearchBar.OnSearchActionListener() {
            @Override
            public void onSearchStateChanged(boolean enabled) {
                // If search is closed, restore default adapter with all results
                if (!enabled) {
                    adapter = new SearchAdapter(getBaseContext(), database.getIslamicWords());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onSearchConfirmed(CharSequence text) {
                // When search is confirmed, initiate search with entered text
                startSearch(text.toString());
            }

            @Override
            public void onButtonClicked(int buttonCode) {
                // Not used in this implementation
            }
        });

        // Initialize the adapter with default results
        adapter = new SearchAdapter(this, database.getIslamicWords());
        recyclerView.setAdapter(adapter);
    }

    // Method to initiate a search based on transliteration
    private void startSearch(String text) {
        adapter = new SearchAdapter(this, database.getIslamicWordbyTransliteration(text));
        recyclerView.setAdapter(adapter);
    }

    // Method to load initial suggestions for the search bar
    private void loadSuggestList() {
        suggestList = database.getTransliteration();
        materialSearchBar.setLastSuggestions(suggestList);
    }
}
