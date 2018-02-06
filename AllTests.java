import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/*
javac -cp ".;junit.jar" *.java && java -cp ".;junit.jar" AllTests
*/

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestJumpHand.class,
	TestSmoothHand.class,
	TestClock.class,
})

public class AllTests {
	// the class remains empty,
	// used only as a holder for the above annotations

	public final static double RADIANS = Math.PI * 2;
	public final static double DELTA = 1E-12f;

	// COMMENT OUT THIS MAIN METHOD IF YOU USE AN IDE
	public static void main(String[] args) {
		org.junit.runner.JUnitCore.main(AllTests.class.getName());
	}
}
