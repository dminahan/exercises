package interview.exercises.wordcount;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class WordCounterTest {

    @Test
    /**
     * Simple line count test of a 2 line file
     */
    public void testWordCount() {
        WordCount wordCount = new WordCount();
        Map<String, Long> words=null;
        try {
            URL resource = Thread.currentThread().getContextClassLoader().getResource("sayings.txt");
            Path textFile = Paths.get(resource.toURI());
            words = wordCount.wordCount(textFile);
            Set<String> wordKeys=words.keySet();
            for(String key:wordKeys) {
                System.out.println(key + " " + words.get(key).longValue());
            }
            assertEquals(11,words.size());
            assertEquals(Long.valueOf(4), words.get("the"));
            assertEquals(Long.valueOf(2), words.get("over"));
            assertEquals(Long.valueOf(1), words.get("dog"));
            assertEquals(Long.valueOf(1), words.get("fox"));
            assertEquals(Long.valueOf(1), words.get("cow"));
            assertEquals(Long.valueOf(1), words.get("moon"));
        } catch(IOException | URISyntaxException e) {
            fail();
        }
    }

    @Test
    /**
     * Unit test to verify that blank lines in a file and case do not skew word count,
     * was a problem before added logic on defining a word better as was case.
     */
    public void testWordCountWithBlankLines() {
        WordCount wordCount = new WordCount();
        Map<String, Long> words=null;
        try {
            URL resource = Thread.currentThread().getContextClassLoader().getResource("loremIpsum.txt");
            Path textFile = Paths.get(resource.toURI());
            words = wordCount.wordCount(textFile);
            assertEquals(16,words.size());
            for(String key:words.keySet()) {
                System.out.println(key + " " + words.get(key).longValue());
            }
            assertEquals(Long.valueOf(2), words.get("sit"));
            assertEquals(Long.valueOf(2), words.get("amet"));
            assertEquals(Long.valueOf(1), words.get("lorem"));
            assertEquals(Long.valueOf(2), words.get("consectetur"));
        } catch(IOException | URISyntaxException e) {
            fail();
        }
    }

    @Test
    /**
     * Unit test to verify special characters and actual numbers do not get counted per definition of word that was chosen.
     *
     * Word:  actual character onlh words, no punctionation, case does not matter and numeric numbers are not allwoed either.
     *
     */
    public void testCharactersAndExtraWhiteSpace() {
        WordCount wordCount = new WordCount();
        Map<String, Long> words=null;
        try {
            URL resource = Thread.currentThread().getContextClassLoader().getResource("characterTest.txt");
            Path textFile = Paths.get(resource.toURI());
            words = wordCount.wordCount(textFile);
            for(String key:words.keySet()) {
                System.out.println(key + " " + words.get(key).longValue());
            }
            assertEquals(7,words.size());
            assertEquals(Long.valueOf(3), words.get("test"));
            Assert.assertNull(words.get("###"));
            Assert.assertNull(words.get("2"));
        } catch(IOException | URISyntaxException e) {
            fail();
        }
    }
}
