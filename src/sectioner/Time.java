package sectioner;

import javax.swing.JButton;



/**
 * Represents an instant of time within a day. Maps the hour interval [0,23] to 12 am all the way to 11 pm.
 * <br>0 represents midnight, all hours map directly to the commonly viewed hour number in a 24 hour clock.
 * @author Giovanni Santiago
 *
 */
public class Time implements Comparable<Time> {
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
	 * Returns the hour of this Time instant in a 24 hour format.
	 * @return the hour in 24 hour format
	 */
	public int getHour() {
		return hour;
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

	@Override
	public int compareTo(Time o) {
		if(this.getHour()>o.getHour()) {
			return 1;
		}
		if(this.getHour()<o.getHour()) {
			return -1;
		}
		
		//Only case left is equal hours
		if(this.getMinute()>o.getMinute()) {
			return 1;
		}
		if(this.getMinute()<o.getMinute()) {
			return -1;
		}
		
		//Only case left is equal hours and equal minutes
		return 0;
	}
}
