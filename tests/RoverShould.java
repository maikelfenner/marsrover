import br.com.maikelfenner.Grid;
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
        Grid grid = new Grid();
        rover = new Rover(grid);
    }

    @Test
    @Parameters({
            "R, 0:0:E",
            "RR, 0:0:S",
            "RRR, 0:0:W",
            "RRRR, 0:0:N",
    })
    public void rotate_right(String commands, String position) {
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
        assertThat(rover.execute(commands), is(position));
    }

    @Test
    @Parameters({
            "M, 0:1:N",
            "MMM, 0:3:N",
    })
    public void move_up(String commands, String position) {
        assertThat(rover.execute(commands), is(position));
    }

    @Test
    @Parameters({
            "MMMMMMMMMM, 0:0:N",
            "MMMMMMMMMMMMM, 0:3:N",
    })
    public void wrap_from_top_to_bottom_when_moving_north(String commands, String position) {
        assertThat(rover.execute(commands), is(position));
    }

    @Test
    @Parameters({
            "LLM, 0:9:S",
            "LLMMMMM, 0:5:S",
    })
    public void move_down(String commands, String position) {
        assertThat(rover.execute(commands), is(position));
    }

    @Test
    @Parameters({
            "RM, 1:0:E",
            "RMMMM, 4:0:E"
    })
    public void move_right(String commands, String position) {
        assertThat(rover.execute(commands), is(position));
    }

    @Test
    @Parameters({
            "RMMMMMMMMMM, 0:0:E",
            "RMMMMMMMMMMMMM, 3:0:E",
    })
    public void wrap_from_right_to_left_when_moving_east(String commands, String position) {
        assertThat(rover.execute(commands), is(position));
    }

    @Test
    @Parameters({
            "LM, 9:0:W",
            "LMMM, 7:0:W",
    })
    public void move_left(String commands, String position) {
        assertThat(rover.execute(commands), is(position));
    }

    @Test
    @Parameters({
            "RMMMMMMMMMM, 0:0:E",
            "RMMMMMMMMMMMMM, 3:0:E",
    })
    public void wrap_from_left_to_right_when_moving_west(String commands, String position) {
        assertThat(rover.execute(commands), is(position));
    }
}
