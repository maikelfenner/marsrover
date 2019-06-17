import br.com.maikelfenner.Rover;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(JUnitParamsRunner.class)
public class RoverShould {

    private Rover rover;

    @Before
    public void initialize() {
        rover = new Rover();
    }

    @Test
    @Parameters({
            "R, 0:0:E",
            "RR, 0:0:S",
            "RRR, 0:0:W",
            "RRRR, 0:0:N",
    })
    public void rotate_right(String commands, String position) {
        Rover rover = new Rover();

        assertThat(rover.execute(commands), is(position));
    }

    @Test
    @Parameters({
            "L, 0:0:W",
            "LL, 0:0:S",
            "LLL, 0:0:E",
            "LLLL, 0:0:N"
    })
    public void rotate_left(String commands, String position) {
        Rover rover = new Rover();

        assertThat(rover.execute(commands), is(position));
    }
}
