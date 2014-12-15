import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by brandonteng on 12/15/14.
 */
public class BowlingGameTest {

    private Game g;

    @Before
    public void initialize() {
        g = new Game();
    }

    private void rollMany(int n, int pins) {
        for(int i = 0; i < n; i++) {
            g.roll(pins);
        }
    }

    @Test
    public void testGutterGame() {
        rollMany(20, 0);
        assertThat(g.score(), is(0));
    }

    @Test
    public void testAllOnes() {
        rollMany(20, 1);
        assertThat(g.score(), is(20));
    }

    @Test
    public void testOneSpare() {
        rollSpare();
        g.roll(3);
        rollMany(17, 0);
        assertThat(g.score(), is(16));
    }

    @Test
    public void testOneGutterThanSpare() {
        g.roll(0);
        g.roll(10);
        rollMany(18,1);
        assertThat(g.score(), is(29));
    }

    @Test
    public void testOneStrike() {
        g.roll(10);
        rollMany(18, 1);
        assertThat(g.score(), is(30));
    }

    private void rollSpare() {
        g.roll(5);
        g.roll(5);
    }
}
