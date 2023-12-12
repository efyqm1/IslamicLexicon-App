package com.example.islamiclexicon.Database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.example.islamiclexicon.Model.IslamicWord;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteAssetHelper {

    // Database name and version
    private static final String DB_NAME = "IslamicWords.db";
    private static final int DB_VER = 1;

    // Constructor to initialize the database
    public Database(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    // Function to get all IslamicWords
    @SuppressLint("Range")
    public List<IslamicWord> getIslamicWords() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        // Define the columns to be retrieved from the table
        String[] sqlSelect = {"arabic_word", "transliteration","literal_translation", "technical_meaning", "arabic_root_word"};
        String tableName = "IslamicWords";

        // Set up the query builder
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, null, null, null, null, null);
        List<IslamicWord> result = new ArrayList<>();

        // Iterate through the cursor to retrieve IslamicWords
        if(cursor.moveToFirst()){
            do{
                IslamicWord islamicWord = new IslamicWord();
                islamicWord.setArabic_word(cursor.getString(cursor.getColumnIndex("arabic_word")));
                islamicWord.setTransliteration(cursor.getString(cursor.getColumnIndex("transliteration")));
                islamicWord.setLiteral_translation(cursor.getString(cursor.getColumnIndex("literal_translation")));
                islamicWord.setTechnical_meaning(cursor.getString(cursor.getColumnIndex("technical_meaning")));
                islamicWord.setArabic_root_word(cursor.getString(cursor.getColumnIndex("arabic_root_word")));

                result.add(islamicWord);
            } while (cursor.moveToNext());
        }
        return result;
    }

    // Function to get all IslamicWord's transliteration
    @SuppressLint("Range")
    public List<String> getTransliteration() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        // Define the columns to be retrieved from the table
        String[] sqlSelect = {"transliteration"};
        String tableName = "IslamicWords";

        // Set up the query builder
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, null, null, null, null, null);
        List<String> result = new ArrayList<>();

        // Iterate through the cursor to retrieve transliterations
        if(cursor.moveToFirst()){
            do{
                result.add(cursor.getString(cursor.getColumnIndex("transliteration")));
            } while (cursor.moveToNext());
        }
        return result;
    }

    // Function to get IslamicWord by transliteration
    @SuppressLint("Range")
    public List<IslamicWord> getIslamicWordbyTransliteration(String transliteration){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        // Define the columns to be retrieved from the table
        String[] sqlSelect = {"arabic_word", "transliteration","literal_translation", "technical_meaning", "arabic_root_word"};
        String tableName = "IslamicWords";

        // Set up the query builder
        qb.setTables(tableName);
        // Query to retrieve IslamicWords based on transliteration pattern
        Cursor cursor = qb.query(db, sqlSelect, "transliteration LIKE ?", new String[]{"%"+transliteration+"%"}, null, null, null);
        List<IslamicWord> result = new ArrayList<>();

        // Iterate through the cursor to retrieve IslamicWords
        if(cursor.moveToFirst()){
            do{
                IslamicWord islamicWord = new IslamicWord();
                islamicWord.setArabic_word(cursor.getString(cursor.getColumnIndex("arabic_word")));
                islamicWord.setTransliteration(cursor.getString(cursor.getColumnIndex("transliteration")));
                islamicWord.setLiteral_translation(cursor.getString(cursor.getColumnIndex("literal_translation")));
                islamicWord.setTechnical_meaning(cursor.getString(cursor.getColumnIndex("technical_meaning")));
                islamicWord.setArabic_root_word(cursor.getString(cursor.getColumnIndex("arabic_root_word")));

                result.add(islamicWord);
            } while (cursor.moveToNext());
        }
        return result;
    }
}
