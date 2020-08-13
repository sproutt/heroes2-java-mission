import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PointParserTest {
    PointParser p;

    @Before
    public void setUp() {
        p = new PointParser();
    }

    @Test
    public void test0() {
        assertEquals("Success in finding x,y",p.checkXY("(8,10)"));
    }

    @Test
    public void test1() {
        assertEquals("Wrong input(only one number)",p.checkXY("(8)"));
    }

    @Test
    public void test2() {
        assertEquals("Wrong input(more than 2 numbers)",p.checkXY("(8,15,20)"));
    }

    @Test
    public void test3() {
        assertEquals("The number is outside the valid range",p.checkXY("(8,25)"));
    }

    @Test
    public void test4() {
        assertEquals("The number is outside the valid range",p.checkXY("(25,8)"));
    }

    @After
    public void tearDown() {
        p = null;
    }


}