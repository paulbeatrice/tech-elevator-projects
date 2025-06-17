import com.techelevator.MaxEnd3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MaxEnd3Test {

    @Test
    public void testMakeArray_firstElementIsLarger() {
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int [] input = {9, 2, 3};
        int [] expected = {9, 9, 9};
        assertArrayEquals(expected, maxEnd3.makeArray(input));
    }
    @Test
    public void testMakeArray_lastElementIsLarger() {
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int[] input = {1, 2, 5};
        int[] expected = {5, 5, 5};
        assertArrayEquals(expected, maxEnd3.makeArray(input));
    }
    @Test
    public void testMakeArray_firstAndLastAreEqual() {
        MaxEnd3 maxEnd3 = new MaxEnd3();
        int[] input = {3, 2, 3};
        int[] expected = {3, 3, 3};
        assertArrayEquals(expected, maxEnd3.makeArray(input));
    }
}
