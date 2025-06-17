import com.techelevator.WordCount;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class WordCountTest {

    @Test
    public void GetCount_withMultipleOccurences() {
        WordCount wordCount = new WordCount();
        String[] words = {"pizza", "pie", "chicken", "hamburger", "pizza", "hamburger", "pie", "pizza"};
        Map<String, Integer> expected = new HashMap<>();
        expected.put("pizza", 3);
        expected.put("chicken", 1);
        expected.put("pie", 2);
        expected.put("hmaburger", 2);
    }
}
