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

    private static final String DB_NAME = "IslamicWords.db";
    private static final int DB_VER = 1;

    public Database(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    // Function get all IslamicWords
    @SuppressLint("Range")
    public List<IslamicWord> getIslamicWord(){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        // Make sure all is column name in your Table
        String[] sqlSelect = {"arabic_word", "transliteration","literal_translation", "technical_meaning", "arabic_root_word"};
        String tableName = "IslamicWords"; //Make sure this is your table name

        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, null, null, null, null, null);
        List<IslamicWord> result = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                IslamicWord islamicWord = new IslamicWord();
                islamicWord.setArabic_word(cursor.getString(cursor.getColumnIndex("arabic_word")));
                islamicWord.setTransliteration(cursor.getString(cursor.getColumnIndex("transliteration")));
                islamicWord.setLiteral_translation(cursor.getString(cursor.getColumnIndex("literal_translation")));
                islamicWord.setTechnical_meaning(cursor.getString(cursor.getColumnIndex("technical_meaning")));
                islamicWord.setArabic_root_word(cursor.getString(cursor.getColumnIndex("arabic_root_word")));

                result.add(islamicWord);
            }while (cursor.moveToNext());
        }
        return result;
    }

    // Function get all IslamicWord's arabic_word
    @SuppressLint("Range")
    public List<String> getArabic_word(){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        // Make sure all is column name in your Table
        String[] sqlSelect = {"arabic_word"};
        String tableName = "IslamicWords"; //Make sure this is your table name

        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, null, null, null, null, null);
        List<String> result = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                result.add(cursor.getString(cursor.getColumnIndex("arabic_word")));
            }while (cursor.moveToNext());
        }
        return result;
    }

    // Function get IslamicWord by arabic_word
    @SuppressLint("Range")
    public List<IslamicWord> getIslamicWordbyArabic_word(String arabic_word){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        // Make sure all is column name in your Table
        String[] sqlSelect = {"arabic_word", "transliteration","literal_translation", "technical_meaning", "arabic_root_word"};
        String tableName = "IslamicWords"; //Make sure this is your table name

        qb.setTables(tableName);
        // If you want to get extract name, just change
        // Cursor cursor = qb.query(db, sqlSelect, "arabic_word = ?", new String[]{arabic_word}, null, null, null);

        // This will like query: Select * from IslamicWords where arabic_word LIKE %pattern%
        Cursor cursor = qb.query(db, sqlSelect, "arabic_word LIKE ?", new String[]{"%"+arabic_word+"%"}, null, null, null);
        List<IslamicWord> result = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                IslamicWord islamicWord = new IslamicWord();
                islamicWord.setArabic_word(cursor.getString(cursor.getColumnIndex("arabic_word")));
                islamicWord.setTransliteration(cursor.getString(cursor.getColumnIndex("transliteration")));
                islamicWord.setLiteral_translation(cursor.getString(cursor.getColumnIndex("literal_translation")));
                islamicWord.setTechnical_meaning(cursor.getString(cursor.getColumnIndex("technical_meaning")));
                islamicWord.setArabic_root_word(cursor.getString(cursor.getColumnIndex("arabic_root_word")));

                result.add(islamicWord);
            }while (cursor.moveToNext());
        }
        return result;
    }

}