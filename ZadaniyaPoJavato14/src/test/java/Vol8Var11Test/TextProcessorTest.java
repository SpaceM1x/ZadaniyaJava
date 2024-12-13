package Vol8Var11Test;

import Vol8Var11.TextProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TextProcessorTest {
    @Test
    public void testAnalyzeSentence_moreVowels() {
        Assertions.assertEquals("More vowels", TextProcessor.analyzeSentence("A simple example."));
    }

    @Test
    public void testAnalyzeSentence_moreConsonants() {
        assertEquals("More consonants", TextProcessor.analyzeSentence("This is a test."));
    }

    @Test
    public void testAnalyzeSentence_equalVowelsAndConsonants() {
        assertEquals("Equal vowels and consonants", TextProcessor.analyzeSentence("ABab"));
    }
}
