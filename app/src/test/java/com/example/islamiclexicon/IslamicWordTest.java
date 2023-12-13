package com.example.islamiclexicon;

import org.junit.Test;
import static org.junit.Assert.*;

import com.example.islamiclexicon.Model.IslamicWord;

/**
 * JUnit tests for the IslamicWord class.
 */
public class IslamicWordTest {

    /**
     * Test getters and setters of the IslamicWord class.
     */
    @Test
    public void testGettersAndSetters() {
        IslamicWord word = new IslamicWord();
        word.setArabic_word("TestArabicWord");
        word.setTransliteration("TestTransliteration");
        word.setLiteral_translation("TestLiteralTranslation");
        word.setTechnical_meaning("TestTechnicalMeaning");
        word.setArabic_root_word("TestArabicRootWord");

        assertEquals("TestArabicWord", word.getArabic_word());
        assertEquals("TestTransliteration", word.getTransliteration());
        assertEquals("TestLiteralTranslation", word.getLiteral_translation());
        assertEquals("TestTechnicalMeaning", word.getTechnical_meaning());
        assertEquals("TestArabicRootWord", word.getArabic_root_word());
    }

    /**
     * Test the empty constructor of the IslamicWord class.
     */
    @Test
    public void testEmptyConstructor() {
        IslamicWord word = new IslamicWord();
        assertNull(word.getArabic_word());
        assertNull(word.getTransliteration());
        assertNull(word.getLiteral_translation());
        assertNull(word.getTechnical_meaning());
        assertNull(word.getArabic_root_word());
    }

    /**
     * Test the non-null constructor of the IslamicWord class.
     */
    @Test
    public void testNonNullConstructor() {
        IslamicWord word = new IslamicWord("Word", "Translit", "Literal", "Tech", "Root");
        assertNotNull(word);
        assertEquals("Word", word.getArabic_word());
        assertEquals("Translit", word.getTransliteration());
        assertEquals("Literal", word.getLiteral_translation());
        assertEquals("Tech", word.getTechnical_meaning());
        assertEquals("Root", word.getArabic_root_word());
    }

}