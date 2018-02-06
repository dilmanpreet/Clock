import java.time.LocalTime;
import java.awt.*;
import javax.swing.*;

/** A clock which can be drawn
	@author Dilmanpreet N @ Langara for CPSC 1181-003
	@version 2018-02-01
*/
public class Clock {

	/** Radians in a circle. */
	public final static double RADIANS = Math.PI*2;
	/** the size of the clock */
	public final static int SCALE = 200;
	/** the centre of the clock */
	public final static int CENTRE = SCALE/2;

	private final static int NUM_TICKS = 12;
	private final static int NUM_FAT_TICKS = 4;
	private final static int TICK_LENGTH = SCALE / 10;

	private final Hand[] hands;

	/** Creates a new clock set to the indicated time.
		@param t the intial time of the clock
	*/
	public Clock() {
		hands = new Hand[4];

		// TODO
	}

	/** Sets the time on the clock. Updates hand positions.
		@param t the time
	*/
	public void setTime(LocalTime t) {
		// TODO
	}

	/** @return the hands of this clock in order: MILL, SECOND, MINUTE, HOUR */
	public Hand[] getHands() {
		return hands;
	}

	/** Draws the clock at the current canvas position. */
	public void draw(Graphics2D g) {
		// TODO
	}
}
