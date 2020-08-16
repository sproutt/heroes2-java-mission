import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PointTest {
    Point point;

    @Before
    public void setUp() throws Exception {
        point = new Point();
    }

    @Test
    public void oneInput() {
        assertEquals("좌표 값 하나만 입력됨.",point.Test("(1,)"));
    }

    @Test
    public void overTwoInput() {
        assertEquals("좌표 두 개이상 입력됨.",point.Test("(8,10,11)"));
    }

    @Test
    public void invalidInput() {
        assertEquals("유효하지 않은 값 입력됨.",point.Test("(0,24)"));
    }

    @After
    public void tearDown() throws Exception {
        point = null;
    }

}