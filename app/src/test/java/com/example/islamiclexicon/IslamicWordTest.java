package com.example.islamiclexicon;

import org.junit.Test;
import static org.junit.Assert.*;

import com.example.islamiclexicon.Model.IslamicWord;

public class IslamicWordTest {

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

    // Add more tests based on specific methods or behavior in the IslamicWord class.
}

