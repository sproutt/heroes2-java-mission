import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoordinateTest extends Coordinate {
    Coordinate coordinate;

    @Before
    public void setUp() throws Exception {
        coordinate = new Coordinate();
    }

    @After
    public void tearDown() throws Exception {
        coordinate = null;
    }

    @Test
    public void onlyOne1() {
        String result = coordinate.getCoordinate("(8)");
        assertThat(result).isEqualTo("Enter TWO Coordinates.");
    }

    @Test
    public void onlyOne2() {
        String result = coordinate.getCoordinate("(8, )");
        assertThat(result).isEqualTo("Blank is not valid.");
    }

    @Test
    public void onlyOne3() {
        String result = coordinate.getCoordinate("( , 10)");
        assertThat(result).isEqualTo("Blank is not valid.");
    }

    @Test
    public void validValue() {
        String result = coordinate.getCoordinate("(8, 10)");
        assertThat(result).isEqualTo("x = 8, y = 10");
    }

    @Test
    public void tooMany() {
        String result = coordinate.getCoordinate("(8, 10, 12)");
        assertThat(result).isEqualTo("Enter TWO Coordinates.");
    }

    @Test
    public void invalidNumber1() {
        String result = coordinate.getCoordinate("(0, 24)");
        assertThat(result).isEqualTo("Valid number ranges from 1 to 24.");
    }

    @Test
    public void invalidNumber2() {
        String result = coordinate.getCoordinate("(1, 25)");
        assertThat(result).isEqualTo("Valid number ranges from 1 to 24.");
    }
}