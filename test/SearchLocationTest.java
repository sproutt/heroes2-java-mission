import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SearchLocationTest {
    SearchLocation sl;
    @Before
    public void setUp() throws Exception {
        sl = new SearchLocation();
    }

    @Test
    public void oneInput() {
        assertEquals("oneInput",sl.oneInput(1));
    }

    @Test
    public void overTwoInput() {
        assertEquals("overTwoInput",sl.overTwoInput(1,2,3));
    }

    @Test
    public void invalidInput() {
        assertEquals("invalidInput",sl.invalidInput(25,1));
    }

    @After
    public void tearDown() throws Exception {
        sl=null;
    }


}