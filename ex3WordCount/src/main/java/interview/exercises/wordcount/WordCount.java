package interview.exercises.wordcount;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Map;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Class to count the words of a fileName provided
 * dfgriffith
 */
public class WordCount {

//    public long countWords(String fileName) {
//      long wordCount = Files.lines(Paths.get(fileName))
//       .flatMap(str->Stream.of(str.split("[ ,.!?\r\n]")))
//       .filter(s->s.length()>0).count();
//      logger.info("wordCount is: " + wordCount);
//      System.out.println(wordsCount);
//      return wordCount;
//    }

    public Map<String, Long> wordCount(Path filename) throws IOException, URISyntaxException {
System.out.println("filename: " + filename.toString());
        //Read all lines and filter out blank lines so they do not add to word count
        Map<String, Long> wordMap =
                Files.lines(filename)
                        .filter(line -> !line.isEmpty())
                        .flatMap(line -> Arrays.stream(line.trim().split(" ")))
                        .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim())
                        .filter(word -> word.length() > 0)
                        .map(word -> new SimpleEntry<>(word, 1))
                        //.collect(Collectors.toMap(s -> s, s -> 1, Integer::sum));
                        .collect(groupingBy(SimpleEntry::getKey, counting()));

//        wordMap.forEach((k, v) -> System.out.println(String.format(k,v)));
//        System.out.println("count: " + count);

        return wordMap;

    }

}

