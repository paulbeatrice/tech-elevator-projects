import com.techelevator.CigarParty;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CigarPartyTest {
    @Test
    public void testHaveParty_WeekdayWithEnoughCigars() {
        CigarParty cigarParty = new CigarParty();
        assertTrue(cigarParty.haveParty(50, false)); // expected party to be successful with 50 Cigars
        // during the week
    }
    @Test
    public void testHaveParty_WeekdayWithoutEnoughCigars() {
        CigarParty cigarParty = new CigarParty();
        assertFalse(cigarParty.haveParty(30, false));
        /* party expected to be unsuccessful during the weekday with only
        30 cigars*/
    }
    @Test
    public void testHaveParty_WeekendWithEnoughCigars() {
        CigarParty cigarParty = new CigarParty();
        assertTrue(cigarParty.haveParty(70, true));
        // ^^ expected party to be successful since it's the weekend and we have 70 cigars
        }
    @Test
    public void testHaveParty_WeekendWithMinimumCigars() {
        CigarParty cigarParty = new CigarParty();
        assertTrue(cigarParty.haveParty(40, true));
        // expected party to be successful with minimum cigars on weekend
    }
    @Test
    public void testHaveParty_WeekendWithoutEnoughCigars() {
        CigarParty cigarParty = new CigarParty();
        assertFalse(cigarParty.haveParty(30, false));
        // not enough cigars on weekend to be unsuccessful - expected to fail
    }
    @Test
    public void testHaveParty_WeekdayWithMaximumCigars() {
        CigarParty cigarParty = new CigarParty();
        assertTrue(cigarParty.haveParty(60,false));
        //expected party to be successful with 60 Cigars during the week
    }
    @Test
    public void testHaveParty_WeekdayAboveMaximumCigars() {
        CigarParty cigarParty = new CigarParty();
        assertFalse(cigarParty.haveParty(70, false));
        // expected party to fail with 70 cigars on a weekday
    }


}
