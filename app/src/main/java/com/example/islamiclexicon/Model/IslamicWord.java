package com.example.islamiclexicon.Model;

public class IslamicWord {

    // Properties representing different attributes of an Islamic word
    public String arabic_word;
    public String transliteration;
    public String literal_translation;
    public String technical_meaning;
    public String arabic_root_word;

    // Constructor to initialize an IslamicWord object with specific attributes
    public IslamicWord(String arabic_word, String transliteration, String literal_translation, String technical_meaning, String arabic_root_word) {
        this.arabic_word = arabic_word;
        this.transliteration = transliteration;
        this.literal_translation = literal_translation;
        this.technical_meaning = technical_meaning;
        this.arabic_root_word = arabic_root_word;
    }

    // Default constructor for an empty IslamicWord object
    public IslamicWord() {

    }

    // Getter and setter methods for the 'arabic_root_word' property
    public String getArabic_root_word() {
        return arabic_root_word;
    }

    public void setArabic_root_word(String arabic_root_word) {
        this.arabic_root_word = arabic_root_word;
    }

    // Getter and setter methods for the 'technical_meaning' property
    public String getTechnical_meaning() {
        return technical_meaning;
    }

    public void setTechnical_meaning(String technical_meaning) {
        this.technical_meaning = technical_meaning;
    }

    // Getter and setter methods for the 'literal_translation' property
    public String getLiteral_translation() {
        return literal_translation;
    }

    public void setLiteral_translation(String literal_translation) {
        this.literal_translation = literal_translation;
    }

    // Getter and setter methods for the 'transliteration' property
    public String getTransliteration() {
        return transliteration;
    }

    public void setTransliteration(String transliteration) {
        this.transliteration = transliteration;
    }

    // Getter and setter methods for the 'arabic_word' property
    public String getArabic_word() {
        return arabic_word;
    }

    public void setArabic_word(String arabic_word) {
        this.arabic_word = arabic_word;
    }
}
