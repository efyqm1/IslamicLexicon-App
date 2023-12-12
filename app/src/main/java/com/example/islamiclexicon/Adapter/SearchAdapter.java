package com.example.islamiclexicon.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.islamiclexicon.Model.IslamicWord;
import com.example.islamiclexicon.R;

import java.util.List;

class SearchViewHolder extends RecyclerView.ViewHolder{

    public TextView arabic_word;
    public TextView transliteration;
    public TextView literal_translation;
    public TextView technical_meaning;
    public TextView arabic_root_word;
    public SearchViewHolder(View itemView) {
        super(itemView);
        arabic_word = (TextView) itemView.findViewById(R.id.arabic_word);
        transliteration = (TextView) itemView.findViewById(R.id.transliteration);
        literal_translation = (TextView) itemView.findViewById(R.id.literal_translation);
        technical_meaning = (TextView) itemView.findViewById(R.id.technical_meaning);
        arabic_root_word = (TextView) itemView.findViewById(R.id.arabic_root_word);
    }
}
public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder>{

    private Context context;
    private List<IslamicWord> islamicWords;

    public SearchAdapter(Context context, List<IslamicWord> islamicWords){
        this.context = context;
        this.islamicWords = islamicWords;
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.layout_item, parent, false);
        return new SearchViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {

        holder.arabic_word.setText(islamicWords.get(position).getArabic_word());
        holder.transliteration.setText(islamicWords.get(position).getTransliteration());
        holder.literal_translation.setText(islamicWords.get(position).getLiteral_translation());
        holder.literal_translation.setText(islamicWords.get(position).getLiteral_translation());
        holder.arabic_root_word.setText(islamicWords.get(position).getArabic_root_word());

    }

    @Override
    public int getItemCount() {
        return islamicWords.size();
    }
}