import java.util.ArrayList;

public class Paths {
	
	// Path refers to List of List of Choices
	// Choices refers to going from one Point to another Point
	
	private ArrayList<ArrayList<Intersection>> Path;
	private ArrayList<ArrayList<Intersection>> Path2;
	
	private ArrayList<Intersection> Choices;
	private ArrayList<Intersection> Choices2;
    
	// Paths constructor using an initial Point
	public Paths(Intersection point, Intersection[] arr, double distanceGoal) {
		ArrayList<Intersection> choices = new ArrayList<Intersection>();				// New List of Points
		choices.add(point);																// Add initial Point
		
		// New PointInfo with initial point, accumulated distance and paths
		PointInfo PI = new PointInfo(point, 0.0, choices);			
		
		// Path holds a list of choices
		ArrayList<ArrayList<Intersection>> Path = new ArrayList<ArrayList<Intersection>>(); 
		ArrayList<ArrayList<Intersection>> Path2 = new ArrayList<ArrayList<Intersection>>(); 

		ArrayList<Intersection> Choices = new ArrayList<Intersection>(); 
		ArrayList<Intersection> Choices2 = new ArrayList<Intersection>(); 
		
		// calls paths method below with the PointInfo, dataset, distanceGoal and 
		// List of List of routes [ [A -> B -> C], [A -> B -> D] ]
		paths(PI, arr, distanceGoal, Path, 0);
		this.Path = Path; 
		this.Choices = choices;
		System.out.println("Choices: " + choices);
		choices.clear();
		choices.add(point);
		System.out.println("next");
		paths(PI, arr, distanceGoal, Path2, 2);
		this.Path2 = Path2;
		this.Choices2 = choices;
		System.out.println("Choices2: " + choices);

	}

	// paths method using PointInfo containing current point and choices, dataset array, distGoal, Path
	public void paths(PointInfo PI, Intersection[] arr, double distanceGoal, ArrayList<ArrayList<Intersection>> Path, int i) {
		
		// NearbyPoints method with initial point, dataset
		NearbyPoints Points = new NearbyPoints(PI.getPoint(), arr); 
		
		// List of points containing "the 3 closest points"
		Intersection[] points = Points.getPoints(); 
		
		// List of points temp
		ArrayList<Intersection> choices = new ArrayList<Intersection>(); 
		// Gets the "3 closest points" / choices we can make from the initial point
		choices = PI.getChoices(); 
		// Checks the number of choices we have
		//System.out.println("Size: " + choices.size()); 
		
		// If the choices does not contain the initial point
		if (!choices.contains(points[i])) {
			// Add the initial point to the choices
			choices.add(points[i]); 
		    //System.out.println(choices);
			// Get distance so far + distance to "3 closest points"
		    double totalDistance = PI.getDistance() + PI.getPoint().distTo(points[i]); 
		    
		    
		    // If total distance exceeds our goal, add the choice to Path
		    if (totalDistance < distanceGoal) {
			    PointInfo newPI = new PointInfo(points[i], totalDistance, choices); 
			    paths(newPI, arr, distanceGoal, Path, i); 
		    }
		    
		    
		}
	
	}	
	
	// paths method using PointInfo containing current point and choices, dataset array, distGoal, Path
	public void paths2(PointInfo PI, Intersection[] arr, double distanceGoal, ArrayList<ArrayList<Intersection>> Path, int i) {
		
		// NearbyPoints method with initial point, dataset
		NearbyPoints Points = new NearbyPoints(PI.getPoint(), arr); 
		
		// List of points containing "the 3 closest points"
		Intersection[] points = Points.getPoints(); 
		
		// List of points temp
		ArrayList<Intersection> choices2 = new ArrayList<Intersection>(); 
		// Gets the "3 closest points" / choices we can make from the initial point
		choices2 = PI.getChoices();
		// Checks the number of choices we have
		//System.out.println("Size: " + choices.size()); 
		
		// If the choices does not contain the initial point
		if (!choices2.contains(points[i])) {
			// Add the initial point to the choices
			choices2.add(points[i]); 
			//System.out.println(choices2);
			// Get distance so far + distance to "3 closest points"
		    double totalDistance = PI.getDistance() + PI.getPoint().distTo(points[i]); 
		    
		    // If total distance exceeds our goal, add the choice to Path
		    if (totalDistance < distanceGoal) {
			    PointInfo newPI = new PointInfo(points[i], totalDistance, choices2); 
			    paths2(newPI, arr, distanceGoal, Path, i); 
		    } 
		}
	}	
	
	// Show all the number of paths we have
	
	// Get number of paths that we have
	public int getSize() {
		return Path.size(); 
	}
	
	// Show all the number of paths we have
	public ArrayList<ArrayList<Intersection>> getPaths() {
		return this.Path;
	}
	
	// Show all the number of paths we have
	public ArrayList<ArrayList<Intersection>> getPaths2() {
		return this.Path2;
	}
	
	public ArrayList<Intersection> getChoices() {
		return this.Choices;
	}
	
	public ArrayList<Intersection> getChoices2() {
		return this.Choices2;
	}

	public static void main(String[] args) {
		Intersection[] x = Reader.Hamilton();
		QuickSort.sort(x, "lat");
		System.out.println(x[564]);
		System.out.println(" ");
		Paths paths = new Paths(x[564], x, 2000);
        
		//System.out.println(paths.getSize());
		
		//paths.getPaths();	//Shows list of all the points
		//System.out.println(paths.getPaths());
		//System.out.println(paths.getChoices());
		//paths.getPaths2();
		//System.out.println(paths.getChoices2());

	}

}
