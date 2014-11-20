package sectioner;

import java.util.ArrayList;

/**
 * Represents a single class section.
 * @author 4015c25
 *
 */
public class Section {
	enum Day {
		M,TU,W,TH,F
	}
	private ArrayList<ArrayList<TimeSlot>> dayArrays;
	private String sectionCode;
	private String courseCode;
	
	public Section(String courseCode, String sectionCode) {
		this.sectionCode = sectionCode;
		this.courseCode = courseCode;
		dayArrays = new ArrayList<ArrayList<TimeSlot>>();
		for(int i = 0; i < 5; i++) {
			dayArrays.add(new ArrayList<TimeSlot>());
		}
	}
	
	/**
	 * Adds a new timeslot to this section. End time must be later than start time. Time must not conflict with another previously added slot.
	 * @param day	The day the <code>TimeSlot</code> occurs.
	 * @param startHour	The starting hour [0,23]
	 * @param startMinute The starting minutes	[0,59]
	 * @param endHour	The ending hour	[0,23] 
	 * @param endMinute	The ending minutes	[0,59]
	 */
	public void addTimeSlot(Day day, int startHour, int startMinute, int endHour, int endMinute) {
		dayArrays.get(day.ordinal()).add(new TimeSlot(startHour,startMinute,endHour,endMinute));
	}
	
	/**
	 * Returns all <code>TimeSlot</code>s that intersect with any <code>TimeSlot</code> of <code>other</code>.
	 * @param other
	 * @return
	 */
	public ArrayList<ArrayList<TimeSlot>> findConflicts(Section other) {
		ArrayList<ArrayList<TimeSlot>> result = new ArrayList<>();
		for(int i = 0; i < Day.values().length; i++) {
			//Build the array of empty day array lists
			ArrayList<TimeSlot> currentDay = new ArrayList<>();
			result.add(currentDay);
		}
		if(other.getCourseCode().equals(this.getCourseCode())) {
			return result;
		}
		
		
		//Loop through all the days
		for(int i = 0; i < Day.values().length; i++) {
			//Loop through all the timeslots in this day, in this section
			for(TimeSlot slot: this.getSlots(Day.values()[i])) {
				
				//Check if this timeSlot conflicts with one from the other section, in the current day
				if(other.intersectsTimeSlot(Day.values()[i], slot)) {
					//If so, add to result list.
					result.get(i).add(slot);
				}
				
			}
		}
		return result;
	}
	
	private String getCourseCode() {
		return courseCode;
	}

	/**
	 * Determines if the provided slot conflicts with a slot in the provided day in this section.
	 * @param day
	 * @param time
	 * @return
	 */
	public boolean intersectsTimeSlot(Day day, TimeSlot time) {
		ArrayList<TimeSlot> slots = dayArrays.get(day.ordinal());

		for(TimeSlot t: slots) {
			if(time.intersects(t))
				return true;
		}
		
		return false;
	}
	
	
	/**
	 * Returns the list of slots in the specified day.
	 * <br><b>Do not modify this list.</b>
	 * @param d
	 * @return
	 */
	public ArrayList<TimeSlot> getSlots(Day d) {
		return dayArrays.get(d.ordinal());
	}
}
