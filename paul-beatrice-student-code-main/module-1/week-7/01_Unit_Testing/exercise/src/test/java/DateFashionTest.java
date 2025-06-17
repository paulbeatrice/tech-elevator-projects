import com.techelevator.DateFashion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateFashionTest {

    private DateFashion dateFashion;

    @BeforeEach
    public void setUp() {
        dateFashion = new DateFashion();
    }

    @Test
    public void testGetATable_BothStylishEnough() {
        assertEquals(2, dateFashion.getATable(8,9));
        //expected to get a table with both being above 8
    }
    @Test
    public void testGetATable_OneStylishOneNot() {
        assertEquals(0, dateFashion.getATable(2,9));
        // one is stylish above 8 and the other is not
    }
    @Test
    public void testGetATable_OneStylishOneAvg() {
        assertEquals(2, dateFashion.getATable(8,5));
        //expected to get table with one Stylish and One Avg
    }
    @Test
    public void testGetATable_BothAvg() {
        assertEquals(1,dateFashion.getATable(5,5));
        //Expected they might get a table with both Avg style
    }
    @Test
    public void testGetATable_BothLowerStyle() {
        assertEquals(0, dateFashion.getATable(1,1));
        //Expected to Not Get Table with low style points
    }
    @Test
    public void testGetATable_OneLowOneAvg() {
        assertEquals(0, dateFashion.getATable(2,5));
        //Expected to not get a table with One Low & One Average Style
    }
}
