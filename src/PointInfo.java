import java.util.ArrayList;

// PointInfo Class 
public class PointInfo {
	private Intersection point; 
	private ArrayList<Intersection> choices; 
	private double totalDistance; 
	
	// The current point and its distance thus far and possible paths 
	public PointInfo(Intersection point, double totalDistance, ArrayList<Intersection> choices) {
		this.point = point; 
		this.choices = choices; 
		this.totalDistance = totalDistance; 
	}
	
	public void addDistance(double distance) {
		this.totalDistance += distance; 
	}
	
	public void addChoices(Intersection point) {
		this.choices.add(point); 
	}
	
	public Intersection getPoint() {
		return point; 
	}
	
	public ArrayList<Intersection> getChoices() {
		return choices; 
	}
	
	public double getDistance() {
		return totalDistance; 
	}
}
