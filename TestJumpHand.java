import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.junit.experimental.runners.Enclosed;
import static org.junit.Assert.*;

import java.util.*;
import java.time.LocalTime;

/*
javac -cp ".;junit.jar" *.java && java -cp ".;junit.jar" org.junit.runner.JUnitCore TestJumpHand
*/

@RunWith(Parameterized.class)
public class TestJumpHand {

	private final static double RADIANS = AllTests.RADIANS;
	private final static double DELTA = AllTests.DELTA;

	@Parameters(name = "test({index}): exp: {0}, unit: {1}, time: {2}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			// min, special
			{0, Hand.TimeUnit.MILL, "00:00:00.000"},
			{0, Hand.TimeUnit.SECOND, "00:00:00.000"},
			{0, Hand.TimeUnit.MINUTE, "00:00:00.000"},
			{0, Hand.TimeUnit.HOUR, "00:00:00.000"},
			
			// TODO : add your own test cases
			//here's a free one:
			{30d/60, Hand.TimeUnit.MINUTE, "03:30:45.333"}
		});
	}
	/** expectedAngle is in % rotation */
	@Parameter(0)
	public double expectedAngle;
	@Parameter(1)
	public Hand.TimeUnit unit;
	@Parameter(2)
	public String t;

	@Test public void testAngle() {
		Hand h = new JumpHand(unit, null);
		h.setTime(LocalTime.parse(t));
		assertEquals(expectedAngle * RADIANS, h.getAngle(), DELTA);
	}
}
