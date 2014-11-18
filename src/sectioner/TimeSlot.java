package sectioner;



public class TimeSlot {
	/**
	 * Start point of the timeslot. Will always be earlier than <code>end</code>.
	 */
	Time start;
	
	/**
	 * End point of the timeslot. Will always be later than <code>start</code>.
	 */
	Time end;
	
	/**
	 * Creates a TimeSlot with the specified start and end point. The start point must be earlier than the end point.
	 * @param startHour
	 * @param startMinute
	 * @param endHour
	 * @param endMinute
	 */
	public TimeSlot(int startHour, int startMinute, int endHour, int endMinute) {
		this.start = new Time(startHour,startMinute);
		this.end = new Time(endHour,endMinute);
	}
	
	/**
	 * Determines whether this <code>TimeSlot</code> intersects <code>other</code>
	 * <br>The end points are included in this test
	 * @param other
	 * @return
	 */
	public boolean intersects(TimeSlot other) {
		/*
		 * It does NOT intersect if this object's start is greater than the other's end, or if this object's end is smaller than the other's start. 
		 * Invert that, and they DO intersect.
		 */
		return !((this.start.compareTo(other.end)>=0) || (this.end.compareTo(other.start)<=0));
	}
}
