import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class CarTest {
    Car car1, car2;

    @Before
    public void setUp() throws Exception {
        car1 = new Car("car1");
        car2 = new Car("car2");
    }

    @Test
    public void moveForwardFromZero() {
        car1.moveForward();
        assertThat(car1.getPosition(), either(is(0)).or(is(1)));
    }

    @Test
    public void moveForwardFromTen() {
        car1.setPosition(10);
        car1.moveForward();
        assertThat(car1.getPosition(), either(is(10)).or(is(11)));
    }

    @Test
    public void compareTo() {
        car1.setPosition(10);
        car2.setPosition(6);
        assertEquals(4, car1.compareTo(car2));
    }

    @After
    public void tearDown() throws Exception {
        car1 = null;
        car2 = null;
    }
}