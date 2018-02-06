import java.awt.*;
import java.awt.geom.Line2D;
import java.time.LocalTime;

/** A hand on the face of a clock.  Each hand is responsible for drawing itself
	for the givien time-unit, with the given graphical properties.
	Hand jumps between ticks.
	@author Dilmanpreet N @ Langara for CPSC 1181-003
	@version 2018-02-01
*/
public class JumpHand extends Hand {

	private final GraphicsInfo gInfo;
	private double angle; // the rotation of the hand in radians from 12 o'clock

	/** Creates a hand of a clock. This hand does not reflect partial changes
		in time; it leaps from one tick to the next.
		@param unit the time unit that this hand represents
		@param ginfo the graphical parameters with which to draw this hand
	*/
	public JumpHand(TimeUnit unit, GraphicsInfo ginfo) {
		super(unit);
		this.gInfo = ginfo;
		this.angle = 0;
	}
	
	/** Sets the time of this hand. 
		@param t the new time for this hand to indicate. */
	@Override
	public void setTime(LocalTime t) {
		// TODO
	}

	/** Gets the angle, clockwise from 12 o'clock, in radians, for this hand.
		@return the angle of this hand clockwise from to 12 o'clock. Positive.
			eg: Hour hand at 3 o'clock is +PI/2
	*/
	@Override
	public double getAngle() {
		return angle;
	}
	
	/** Draws this hand of the clock at the current canvas position */
	@Override
	public void draw(Graphics2D g2) {
		// TODO
	}
}
