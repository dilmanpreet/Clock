import java.awt.*;
import javax.swing.JComponent;
import javax.swing.Timer;
import java.time.LocalTime;

/** A component holding and displaying a clock.
	@author Dilmanpreet N @ Langara for CPSC 1181-003
	@version 2018-02-01
*/
@SuppressWarnings("serial")
public class ClockComponent extends JComponent {

	private final static int FPS = 60;
	private final static int INTERVAL = 1000/FPS;

	private final Clock clock;

	/** Make a clock that displays the current time & updates 60 times a second. */
	public ClockComponent() {
		this(LocalTime.now());
		// create a timer to update our clock 60 times per second
		new Timer(INTERVAL, (a) -> {tick();}).start();
	}

	/** A clock that displays a given time.  Static. */
	public ClockComponent(LocalTime aTime) {
		clock = new Clock();
		clock.setTime(aTime);
	}

	/** Update the clock to display the current time. */
	private void tick() {
		clock.setTime(LocalTime.now());
		repaint();
	}

	/** Paints the clock. */
	@Override
	public void paintComponent(Graphics g) {
		// TODO
	}
}
