import java.util.ArrayList;

public class Paths {
	private ArrayList<ArrayList<Intersection>> paths;
    
	//takes a point, dataset array and distance as arguments
	public Paths(Intersection point, Intersection[] arr, double distance) {
		ArrayList<Intersection> path = new ArrayList<Intersection>();
		path.add(point);
		PointInfo PI = new PointInfo(point, 0.0, path);
		ArrayList<ArrayList<Intersection>> paths = new ArrayList<ArrayList<Intersection>>(); 
		paths(PI, arr, distance, paths);
		this.paths = paths; 
	}

	public void paths(PointInfo PI, Intersection[] arr, double distance, ArrayList<ArrayList<Intersection>> paths) {
		NearbyPoints Points = new NearbyPoints(PI.getPoint(), arr); 
		Intersection[] points = Points.getPoints(); 
		for (int i = 0; i < 3; i++) {
			ArrayList<Intersection> temp = new ArrayList<Intersection>(); 
			temp = PI.getPath(); 
			if (!temp.contains(points[i])) {
				temp.add(points[i]); 
			    double total = PI.getDistance() + points[i].distTo(PI.getPoint()); 
			    if (total > distance) {
				    paths.add(temp); 
			    }
			    else {
				     PointInfo newPI = new PointInfo(points[i], total, temp); 
				     paths(newPI, arr, distance, paths); 
			    }
			}
		
		}
	
	}

	public void addPaths(ArrayList<Intersection> path) {
		paths.add(path);
	}
	
	public int getSize() {
		return paths.size(); 
	}
	
	public void showPaths() {
		for (int i = 0; i < paths.size(); i++) {
			System.out.println(paths.get(i)); 
		}
	}

	public static void main(String[] args) {
		Intersection[] x = Reader.Hamilton();
		QuickSort.sort(x, "lat");
		System.out.println(x[564]);
		Paths paths = new Paths(x[564], x, 2000);
        
		System.out.println("number of paths  " + paths.getSize());
		System.out.println("show paths:"); 
		paths.showPaths();

		/*
		 * System.out.println(x[0]); System.out.println(x[1]); System.out.println(x[2]);
		 * int n = 3; ArrayList<Intersection> path = new ArrayList<Intersection>(n);
		 * path.add(x[0]); path.add(x[1]); path.add(x[2]); PointInfo PI = new
		 * PointInfo(x[0], 2.2, path); PI.addDistance(1.2);
		 * System.out.println(PI.getDistance()); PI.addPath(x[3]);
		 * System.out.println(PI.getPath());
		 */
	}

}
