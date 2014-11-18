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
	
	public Section(String sectionCode) {
		this.sectionCode = sectionCode;
		dayArrays = new ArrayList<ArrayList<TimeSlot>>();
		for(int i = 0; i < 5; i++) {
			dayArrays.add(new ArrayList<TimeSlot>());
		}
	}
	
	/**
	 * Adds a new timeslot to this section. End time must be later than start time.
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
			result.add(new ArrayList<TimeSlot>());
		}
		
		
	}
	
	public boolean intersectsTimeSlot(Day d, TimeSlot t) {
		
	}
}
