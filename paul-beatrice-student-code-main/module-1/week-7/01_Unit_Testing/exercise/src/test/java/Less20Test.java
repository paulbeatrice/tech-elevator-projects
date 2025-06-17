import com.techelevator.Less20;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Less20Test {

    Less20 less20 = new Less20();

    @Test
    public void testOneLessThanAMultipleOf20() {
        assertTrue(less20.isLessThanMultipleOf20(19)); //Expected true for 19 since it is one less than 20
        assertTrue(less20.isLessThanMultipleOf20(59)); // Expected true for one less than 60
    }

    @Test
    public void testTwoLessThanAMultipleOf20() {
        assertTrue(less20.isLessThanMultipleOf20(18)); //Expected true for 18 since it is two less than 20
        assertTrue(less20.isLessThanMultipleOf20(78)); //Expected true for 78 since its two less than 80
    }

    @Test
    public void testExactlyMultiplesOf20() {
        assertFalse(less20.isLessThanMultipleOf20(20)); //Expected false for 20 since its divisible 20
        assertFalse(less20.isLessThanMultipleOf20(100)); //Expected to be false for 100 since its divisible by 20
    }
    @Test
    public void testOtherExamples() {
        assertFalse(less20.isLessThanMultipleOf20(17)); //not close to a multiple of 20
        assertFalse(less20.isLessThanMultipleOf20(32)); // not close to multiple of 20
        assertFalse(less20.isLessThanMultipleOf20(0)); // expected to be false since 0 is not multiple of 20
    }
}
