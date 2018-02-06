import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.junit.experimental.runners.Enclosed;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.awt.Graphics2D;
import java.util.*;
import java.time.LocalTime;

/*
javac -cp ".;junit.jar" *Hand.java && java -cp ".;junit.jar" org.junit.runner.JUnitCore TestSmoothHand
*/

@RunWith(Parameterized.class)
public class TestSmoothHand {

	private final static double RADIANS = AllTests.RADIANS;
	private final static double DELTA = AllTests.DELTA;

	private class MockHand extends Hand {
		private final double percentage;

		public MockHand(double percentage) {
			super(unit);
			this.percentage = percentage;
		}
		public void setTime(LocalTime t) {}
		public void draw(Graphics2D g) {}
		public double getAngle() {
			calls.add("get");
			return percentage * RADIANS;
		}
	}

	@Parameters(name = "test({index}): exp: {0}, unit: {1}, time: {2}, prev: {3}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			// min, special
			{0, Hand.TimeUnit.MILL, "00:00:00.000", 0},
			{0, Hand.TimeUnit.SECOND, "00:00:00.000", 0},
			{0, Hand.TimeUnit.MINUTE, "00:00:00.000", 0},
			{0, Hand.TimeUnit.HOUR, "00:00:00.000", 0},

			// TODO : add your own tests
			// here's a free one:
			{(30 + (45 + 333d/1000)/60)/60, Hand.TimeUnit.MINUTE, "03:30:45.333", (45 + 333d/1000)/60},
		});
	}

	/** expectedAngle is in % rotation */
	@Parameter(0)
	public double expectedAngle;
	@Parameter(1)
	public Hand.TimeUnit unit;
	@Parameter(2)
	public String t;
	@Parameter(3)
	public double prev;

	private Hand mock;
	private List<String> calls;

	@Before public void setUp() {
		calls = new ArrayList<String>();
		mock = new MockHand(prev);
	}

	@Test public void testAngle() {
		Hand h = new SmoothHand(unit, new MockHand(prev), null);
		h.setTime(LocalTime.parse(t));

		assertThat(h, is(instanceOf(JumpHand.class)));
		assertEquals(expectedAngle * RADIANS, h.getAngle(), DELTA);
		assertThat(calls, hasItem("get"));
	}

	@Test public void testUsesAngleFromMock() {
		Hand jh = new JumpHand(unit, null);
		jh.setTime(LocalTime.parse(t));
		double expectedWith0Prev = jh.getAngle();

		// give a prev hand with no angle.
		// SmoothHand should be same as JumpHand
		Hand h = new SmoothHand(unit, new MockHand(0), null);
		assertThat(h, is(instanceOf(JumpHand.class)));
		h.setTime(LocalTime.parse(t));

		assertEquals(expectedWith0Prev, h.getAngle(), DELTA);
		assertThat(calls, hasItem("get"));
	}
}
