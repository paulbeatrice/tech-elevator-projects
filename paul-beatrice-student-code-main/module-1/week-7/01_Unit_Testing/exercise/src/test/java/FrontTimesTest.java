import com.techelevator.FrontTimes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrontTimesTest {

    FrontTimes frontTimes = new FrontTimes();

    @Test
    public void testNormalCase() {
        assertEquals("ChoCho", frontTimes.generateString("Chocolate", 2));
    }

    @Test
    public void testShortString() {
        assertEquals("AbcAbcAbc", frontTimes.generateString("Abc", 3));
    }

    @Test
    public void testLessThanThreeChars() {
        assertEquals("SoSoSo", frontTimes.generateString("So", 3));
    }

    @Test
    public void testEmptyString() {
        assertEquals("", frontTimes.generateString("", 4));
    }

    @Test
    public void testZeroTimes() {
        assertEquals("", frontTimes.generateString("Welcome", 0));
    }
}
