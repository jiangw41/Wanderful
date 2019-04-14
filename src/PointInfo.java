import java.util.ArrayList;

// PointInfo Class holding an initial point, List of points so far and the accumulated distance
public class PointInfo {
	private Intersection point; 
	private ArrayList<Intersection> choices; 
	private double totalDistance; 
	
	//  PointInfo Class holding an initial point, List of points so far and the accumulated distance
	public PointInfo(Intersection point, ArrayList<Intersection> choices, double totalDistance) {
		this.point = point; 
		this.choices = choices; 
		this.totalDistance = totalDistance; 
	}
	
	// Returns the initial point in the PointInfo class
	public Intersection getPoint() {
		return point; 
	}

	// Returns the accumulated distance
	public double getDistance() {
		return totalDistance; 
	}
}
