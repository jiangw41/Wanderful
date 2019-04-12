import java.util.ArrayList;

public class PointInfo {
	private Intersection point; 
	private ArrayList<Intersection> path; 
	private double distance; 
	
	public PointInfo(Intersection point, double distance, ArrayList<Intersection> path) {
		this.point = point; 
		this.path = path; 
		this.distance = distance; 
	}
	
	public void addDistance(double distance) {
		this.distance += distance; 
	}
	
	public void addPath(Intersection point) {
		this.path.add(point); 
	}
	
	public Intersection getPoint() {
		return point; 
	}
	
	public ArrayList<Intersection> getPath() {
		return path; 
	}
	
	public double getDistance() {
		return distance; 
	}
	
	public static void main(String[] args) {
		Intersection[] x = Reader.Hamilton(); 
		System.out.println(x[0]); 
		System.out.println(x[1]); 
		System.out.println(x[2]); 
		int n = 3; 
		ArrayList<Intersection> path = new ArrayList<Intersection>(n); 
		path.add(x[0]); 
		path.add(x[1]); 
		path.add(x[2]); 
		PointInfo PI = new PointInfo(x[0], 2.2, path); 
		PI.addDistance(1.2);
		System.out.println(PI.getDistance());
		PI.addPath(x[3]);
		System.out.println(PI.getPath()); 
	}
}
