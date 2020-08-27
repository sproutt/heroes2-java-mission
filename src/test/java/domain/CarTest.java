package domain;

import domain.Car;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class CarTest {
    Car car1, car2;

    @Test
    public void moveForward() {
        car1 = new Car("car1");
        car1.moveForward();
        assertThat(car1.getPosition(), either(is(0)).or(is(1)));
    }

    @Test
    public void samePositionCars() {
        car1 = new Car("car1");
        car2 = new Car("car2");
        assertTrue(car1.isSamePosition(car2));
    }

    public void differentPositionCars() {
        car1 = new Car("car1");
        car2 = new Car("car2");
        for (int i = 0; i < 100; i++) {
            car2.moveForward();
        }
        assertFalse(car1.isSamePosition(car2));
    }

    @After
    public void tearDown() throws Exception {
        car1 = null;
        car2 = null;
    }
}