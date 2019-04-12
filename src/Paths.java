import java.util.ArrayList;

public class Paths {
	private ArrayList<ArrayList<Intersection>> paths; 
	
	public Paths(Intersection point, Intersection[] arr, double distance) {
		ArrayList<Intersection> path = new ArrayList<Intersection>(); 
		path.add(point); 
		PointInfo PI = new PointInfo(point, 0.0, path); 
		paths(PI, arr, distance); 
	}
	
	public void paths(PointInfo PI, Intersection[] arr, double distance) {
		NearbyPoints Points = new NearbyPoints(PI.getPoint(), arr); 
		Intersection[] points = Points.getPoints(); 
		for (int i = 0 ; i < 3; i++) {
	        /*
			private Intersection point; 
			private ArrayList<Intersection> path; 
			private double distance; 
			*/
			ArrayList<Intersection> temp = PI.getPath(); 
			temp.add(points[i]); 
			System.out.println(temp);
			double total = PI.getDistance() + points[i].distTo(PI.getPoint()); 
			if (total > distance) {
				paths.add(temp); 
				return; 
			}
			else {
				PointInfo newPI = new PointInfo(points[i], total, temp); 
				paths(newPI, arr, distance); 
			}
		
		}
	}
	
	public void addPaths(ArrayList<Intersection> path) {
		paths.add(path); 
	}
	
	public static void main(String[] args) {
		Intersection[] x = Reader.Hamilton(); 
		System.out.println(x[10]); 
		Paths paths = new Paths(x[10], x, 8000); 
		
		System.out.println(paths); 
		
		/*System.out.println(x[0]); 
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
		*/
	}
	

}
