import com.techelevator.Lucky13;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Lucky13Test {

    private Lucky13 lucky13 = new Lucky13();

    @AfterEach
    public void reset(){
        lucky13 = null; // reset to null after each test
    }
    @Test
    public void testArrayWithNo1sOr3s() {
        assertTrue(lucky13.getLucky(new int[] { 0, 8, 5}));
    }
    @Test
    public void testArrayWith1() {
        assertFalse(lucky13.getLucky(new int[] {1, 2, 4}));
    }
    @Test
    public void testArrayWith3() {
        assertFalse(lucky13.getLucky(new int[] {0, 3, 20}));
    }
    @Test
    public void testArrayWith1And3() {
        assertFalse(lucky13.getLucky(new int[] {1, 3, 8}));
    }
    @Test
    public void testEmptyArray() {
        assertTrue(lucky13.getLucky(new int[] {}));
    }
}
