package sectioner;

import javax.swing.JButton;



/**
 * Represents an instant of time within a day. Maps the hour interval [0,23] to 12 am all the way to 11 pm.
 * <br>0 represents midnight, all hours map directly to the commonly viewed hour number in a 24 hour clock.
 * @author Giovanni Santiago
 *
 */
public class Time {
	private int hour;
	private int minute;
	JButton b;
	/**
	 * Creates a <code>Time</code> object with the specified hour and minutes.<br>
	 * <code>hour</code> is in 24 hours. 0 is 12:00 am, 23 is 11:00 pm.<br>
	 * <code>hour</code> must be in the interval [0,23]
	 * <code>minute</code> is the minutes within the hour. It must be in the interval [0,59]
	 * @param hour		the hour of the instant in time. 	(0-23)
	 * @param minutes	the minutes within the hour			(0-59)
	 */
	public Time(int hour, int minutes) {
		this.hour = hour;
		this.minute = minutes;
	}
	
	/**
	 * Creates a <code>Time</code> object with the specified hour and minutes, provided in a 12 hour format.
	 * <code>beforeNoon</code> determines if the time is 'am'.
	 * <code>hour</code> must be in the interval [0,11]
	 * <code>minute</code> is the minutes within the hour. It must be in the interval [0,59]
	 * @param beforeNoon 		whether or not this hour is 'am'
	 * @param hour				the hour of the instant in time.		(0-11)
	 * @param minutes			the minutes within the hour				(0-59)
	 */
	public Time(boolean beforeNoon, int hour, int minutes) {
		this.hour = hour+(beforeNoon?0:12);
		this.minute = minutes;
	}
	
	/**
	 * Returns the hour of this Time instant in a 24 hour format.
	 * @return the hour in 24 hour format
	 */
	public int getHour() {
		return hour;
	}
	
	/**
	 * Returns the hour of this Time instant in a 12 hour format. Information of am or pm is not provided.
	 * @return
	 */
	public int getHour12() {
		if(hour%12 == 0)
			return 12;
		return hour%12;
	}
	
	/**
	 * Returns whether or not this Time instant is AM in a 12 hour format, or not.
	 * @return true if this Time is before noon.
	 */
	public boolean isAM() {
		return hour/12 == 0;
	}
	
	/**
	 * Returns the minute of this Time instant.
	 * @return the minute of this Time instant.
	 */
	public int getMinute() {
		return minute;
	}
	
	public String toString() {
		return String.format("%1$02d", hour)+":"+String.format("%1$02d", minute);
	}
	
	public boolean equals(Time other) {
		return this.hour==other.hour && this.minute == other.minute;
	}
}
