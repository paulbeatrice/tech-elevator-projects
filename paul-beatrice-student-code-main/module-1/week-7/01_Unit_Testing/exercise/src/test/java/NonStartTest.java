import com.techelevator.NonStart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NonStartTest {
    private NonStart nonStart;

    @BeforeEach
    public void setUp() {
        nonStart = new NonStart();
    }

    @Test
    public void testGetPartialString_bothStringsPresent() {
        String a = "Hello";
        String b = "There";
        String expected = "ellohere";
        assertEquals(expected, nonStart.getPartialString(a, b));
    }
    @Test
    public void testGetPartialString_firstStringEmpty() {
        String a = "";
        String b = "There";
        String expected = "here";
        assertEquals(expected, nonStart.getPartialString(a, b));
    }
    @Test
    public void testGetPartialString_secondStringEmpty() {
        String a = "Hello";
        String b = "";
        String expected = "ello";
        assertEquals(expected, nonStart.getPartialString(a, b));
    }
    @Test
    public void testGetPartialString_bothStringSingleChar() {
        String a = "A";
        String b = "B";
        String expected = "";
        assertEquals(expected, nonStart.getPartialString(a, b));
    }
    @Test
    public void testGetPartialString_nullStrings() {
        String a = null;
        String b = null;
        String expected = "";
        assertEquals(expected, nonStart.getPartialString(a, b));
    }
}
