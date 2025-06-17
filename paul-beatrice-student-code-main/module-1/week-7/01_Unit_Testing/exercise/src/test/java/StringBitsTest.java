import com.techelevator.StringBits;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringBitsTest {

    @Test
    public void testGetBits() {
        StringBits stringBits = new StringBits();
        assertEquals("Hlo", stringBits.getBits("Hello"));
        assertEquals("H", stringBits.getBits("Hi"));
        assertEquals("Hello", stringBits.getBits("Heeololeo"));
        assertEquals("", stringBits.getBits(""));

    }
}
