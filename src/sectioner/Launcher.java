package sectioner;

public class Launcher {

	public static void main(String[] args) {
		
		TimeSlot earlier = new TimeSlot(0,0,1,0);
		TimeSlot later = new TimeSlot(2,0,3,0);
		TimeSlot intersectsBoth = new TimeSlot(0,30,2,30);
		TimeSlot containsLater = new TimeSlot(1,0,4,0);
		
		System.out.println("Earlier intersects later (false): "+earlier.intersects(later));
		System.out.println("Earlier intersects intersectsBoth (true): "+earlier.intersects(intersectsBoth));
		System.out.println("Later intersects intersectsBoth (true): "+later.intersects(intersectsBoth));
		System.out.println("ContainsLater intersects later (true): "+containsLater.intersects(later));
		System.out.println("ContainsLater intersects intersectsBoth (true): "+containsLater.intersects(intersectsBoth));
		System.out.println("ContainsLater intersects earlier (false): "+containsLater.intersects(earlier));
		
	}

}
