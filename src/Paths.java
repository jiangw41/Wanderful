import java.util.ArrayList;

// Creates 2 Lists of Points from an initial point to a point that meets the user's distance goal
public class Paths {
	
	// The 2 Choices holds a list of points (List of directions) going from one Point to another Point
	private ArrayList<Intersection> Choices;
	private ArrayList<Intersection> Choices2;
    
	// Paths constructor using an initial Point
	public Paths(Intersection point, Intersection[] arr, double distanceGoal) {
		// Add the starting point to both Lists
		ArrayList<Intersection> choices = new ArrayList<Intersection>();
		choices.add(point);
		ArrayList<Intersection> choices2 = new ArrayList<Intersection>();
		choices2.add(point);
		
		// New PointInfo with starting point, accumulated distance and a list of points
		PointInfo PI = new PointInfo(point, choices, 0.0);	
		PointInfo PI2 = new PointInfo(point, choices2, 0.0);	
		
		// Calls paths method below with the Choice List (0 for Route 1, 1 for Route 2), PointInfo, dataset,
		// distanceGoal and a number referring to the two points the current point is closest to
		// Goes solely to the 1st point in the NearbyPoints list
		paths(choices, PI, arr, distanceGoal, 0);
		this.Choices = choices;
		System.out.println("Choices: " + this.Choices);
		// Goes solely to the 2nd point in the NearbyPoints list
		paths(choices2, PI2, arr, distanceGoal, 1);
		this.Choices2 = choices2;
		System.out.println("Choices2: " + this.Choices2);

	}

	// paths method given a list of points to update recursively, PointInfo containing current point and choices, 
	// dataset array, distance Goal and a number referring to the two points the current point is closest to
	public void paths(ArrayList<Intersection> choices, PointInfo PI, Intersection[] arr, double distanceGoal, int i) {
		
		// NearbyPoints method with initial point and dataset to generate a list holding two nearby points
		NearbyPoints Points = new NearbyPoints(PI.getPoint(), arr); 
		
		// Holds onto list of points containing 2 nearby points from the NearbyPoints method above
		Intersection[] points = Points.getPoints(); 
		
		// Add the initial point to the choices
		choices.add(points[i]); 
		
		// Get accumulated distance with the distance so far + distance to next point
	    double totalDistance = PI.getDistance() + PI.getPoint().distTo(points[i]); 
	    
	    // If total distance does not exceed our goal, repeat for the next point
	    if (totalDistance < distanceGoal) {
		    PointInfo newPI = new PointInfo(points[i], choices, totalDistance); 
		    paths(choices, newPI, arr, distanceGoal, i); 
	    }
	}	

	// Show all the number of choices we have
	public ArrayList<Intersection> getChoices() {
		return this.Choices;
	}
	// Show all the number of choices we have
	public ArrayList<Intersection> getChoices2() {
		return this.Choices2;
	}

}
