package com.example.islamiclexicon.Adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.islamiclexicon.Model.IslamicWord;
import com.example.islamiclexicon.R;

import java.util.List;

// ViewHolder class to hold the views for each item in the RecyclerView
class SearchViewHolder extends RecyclerView.ViewHolder {

    // TextViews to display different attributes of IslamicWord
    public TextView arabic_word;
    public TextView transliteration;
    public TextView literal_translation;
    public TextView technical_meaning;
    public TextView arabic_root_word;

    // Constructor to initialize the views
    public SearchViewHolder(View itemView) {
        super(itemView);

        // Initialize TextViews by finding views by their IDs
        arabic_word = (TextView) itemView.findViewById(R.id.arabic_word);
        transliteration = (TextView) itemView.findViewById(R.id.transliteration);
        literal_translation = (TextView) itemView.findViewById(R.id.literal_translation);
        technical_meaning = (TextView) itemView.findViewById(R.id.technical_meaning);
        arabic_root_word = (TextView) itemView.findViewById(R.id.arabic_root_word);
    }
}

// Adapter class to bind the data to the RecyclerView
public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {

    private Context context;
    private List<IslamicWord> islamicWords;

    // Constructor to initialize the adapter with context and data
    public SearchAdapter(Context context, List<IslamicWord> islamicWords) {
        this.context = context;
        this.islamicWords = islamicWords;
    }

    // Called when RecyclerView needs a new ViewHolder
    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the layout for each item and return a new SearchViewHolder
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.layout_item, parent, false);
        return new SearchViewHolder(itemView);
    }

    // Called to bind the data to a ViewHolder
    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {
        // Set the data for each TextView in the ViewHolder
        holder.arabic_word.setText(islamicWords.get(position).getArabic_word());
        holder.transliteration.setText(islamicWords.get(position).getTransliteration());
        holder.literal_translation.setText(islamicWords.get(position).getLiteral_translation());
        holder.technical_meaning.setText(islamicWords.get(position).getTechnical_meaning());
        holder.arabic_root_word.setText(islamicWords.get(position).getArabic_root_word());
    }

    // Returns the total number of items in the data set
    @Override
    public int getItemCount() {
        return islamicWords.size();
    }
}
