import com.techelevator.SameFirstLast;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SameFirstLastTest {

    @Test
    public void testIsItTheSame_arrayWithSameFirstAndLastElement() {
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] nums = { 1, 2, 3, 1};
        assertTrue(sameFirstLast.isItTheSame(nums));
    }
    @Test
    public void testIsItTheSame_arrayWithDifferentFirstAndLastElement() {
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] nums = { 1, 2, 3, 4};
        assertFalse(sameFirstLast.isItTheSame(nums));
    }
    @Test
    public void testIsItTheSame_singleElementArray() {
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] nums = {5};
        assertTrue(sameFirstLast.isItTheSame(nums));
    }
    @Test
    public void testIsItTheSame_emptyArray() {
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] nums = {};
        assertFalse(sameFirstLast.isItTheSame(nums));
    }
}
