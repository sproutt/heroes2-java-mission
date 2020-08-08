import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PointTest {
    Point p;
    @Before
    public void setUp() throws Exception {
        p = new Point();
    }

    @After
    public void tearDown() throws Exception {
        p = null;
    }

    @Test
    public void oneInput() {
        assertEquals("Please enter both X and Y", p.getXY("(8)"));
    }

    @Test
    public void moreInput() {
        assertEquals("Please enter only X and Y", p.getXY("(8,10,14)"));
    }

    @Test
    public void invalidInput1() {
        assertEquals("Not a valid number: 25", p.getXY("(5,25)"));
    }

    @Test
    public void invalidInput2() {
        assertEquals("Not a valid number: -11", p.getXY("(-11,10)"));
    }
}