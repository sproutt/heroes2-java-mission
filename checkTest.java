import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class checkTest {
    check c;
    @Before
    public void setUp()  {
        c = new check();
    }

    @Test
    public void test0(){
        assertTrue(c.checkXY("8,10"));
    }

    @Test
    public void test1(){
        assertTrue(c.checkXY("8"));
    }

    @Test
    public void test2(){
        assertTrue(c.checkXY("8,15,20"));
    }

    @Test
    public void test3(){
        assertTrue(c.checkXY("8,25"));
    }

    @Test
    public void test4(){
        assertTrue(c.checkXY("25,8"));
    }

    @After
    public void tearDown() {
        c = null;
    }


}