package interview.exercises.wordcount;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * Main class of the Exercise 3 Word Count example, goal is to find files in a known directory name and 
 * then coun the words of the files present.
 *
 * dfgriffith
 */
public class ExerciseWordCountMain {

    public static void main(String args[]) {
        if(args.length > 0) {
            File file = new File(args[0]);
            try {
                Path path = Paths.get(file.toURI());
                WordCount wordCounter = new WordCount();
                System.out.println(path.getFileName());
                Map<String, Long> wordMap=wordCounter.wordCount(path.getFileName());
                for(String key:wordMap.keySet()) {
                    System.out.println(key + " " + wordMap.get(key).longValue());
                }
            } catch(IOException ex){
                System.out.println("IOException trying to count the words in file");
                ex.printStackTrace();
            } catch(URISyntaxException uriEx) {
                System.out.println("URIException trying to ccount the words in provided file");
                uriEx.printStackTrace();
            }
        } else {
            System.out.println("Error:  No file name provided");
        }

  }
}

