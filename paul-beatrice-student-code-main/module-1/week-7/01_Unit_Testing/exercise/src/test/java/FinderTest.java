import com.techelevator.Finder;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FinderTest {

    @Test
    public void testFindLargest_WithPositiveNumbers() {
        Finder finder = new Finder();
        List<Integer> numbers = Arrays.asList(1, 10, 7, 2, 25);
        assertEquals(25, finder.findLargest(numbers));
        //Expected Largest Number to be 25
    }

    @Test
    public void testFindLargest_WithNegativeNumbers() {
        Finder finder = new Finder();
        List<Integer> numbers = Arrays.asList(-16, -3, -9, -8);
        assertEquals(-3, finder.findLargest(numbers));
        //Expected largest number to be -3
    }
    @Test
    public void testFindLargest_WithSingleElement() {
        Finder finder = new Finder();
        List<Integer> numbers = Collections.singletonList(65);
        assertEquals(65, finder.findLargest(numbers));
        //Expected the largest number to be 65 when only one number is present
    }
    @Test
    public void testFindLargest_MixedNumbers() {
        Finder finder = new Finder();
        List<Integer> numbers = Arrays.asList(-10, 5, -18 , 3, -2);
        assertEquals(4, finder.findLargest(numbers));
        // Expected largest number to be 5
    }
    @Test
    public void testFindLargest_WithEmptyList() {
        Finder finder = new Finder();
        List<Integer> numbers = Collections.emptyList();
        assertNull(finder.findLargest(numbers));
        //expected to be null when the list is empty
    }

}
