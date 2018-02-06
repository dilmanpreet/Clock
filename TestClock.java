import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.time.LocalTime;

/*
javac -cp ".;junit.jar" *.java && java -cp ".;junit.jar" org.junit.runner.JUnitCore TestClock
*/

public class TestClock {

	private final static double RADIANS = AllTests.RADIANS;
	private final static double DELTA = AllTests.DELTA;

	@Test public void handOrder() {
    Clock c = new Clock();
    c.setTime(LocalTime.parse("00:00:00.000"));
    for(int i = 0; i < Hand.TimeUnit.values().length; i++) {
        Hand h = c.getHands()[i];
        Hand.TimeUnit tu = Hand.TimeUnit.values()[i];
        assertEquals(tu, h.getTimeUnit());
    }
  }

  @Test public void hasPartialMovement() {
    Clock c = new Clock();
    c.setTime(LocalTime.parse("01:30:00.000"));
    Hand h = c.getHands()[Hand.TimeUnit.HOUR.ordinal()];

    assertEquals(0.78539816339744830961566084581988, h.getAngle(), DELTA);
  }

  @Test public void handType() {
    Clock c = new Clock();
    c.setTime(LocalTime.parse("00:00:00.000"));
    for(Hand h : c.getHands()) {
      assertThat(h, is(instanceOf(JumpHand.class)));
    }
  }
}
