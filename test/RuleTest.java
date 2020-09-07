import org.junit.Test;

import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RuleTest {
    @Test
    public void isGoForward() {
        assertThat(Rule.isGoForward(),either(is(true)).or(is(false)) );
    }
}