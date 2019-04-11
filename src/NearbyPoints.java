
public class NearbyPoints {
	private Intersection[] nearbyPoints;

	// takes a point and the data array as inputs and create its nearby points into
	// an array;
	public NearbyPoints(Intersection Point, Intersection[] arr) {
		QuickSort.sort(arr, "lat"); // sort the array based on latitude first
		int index = binarySearch(arr, 0, arr.length, Point, "lat");
		Intersection[] temp;
		temp = new Intersection[30];
		int start;
		if (index <= 14) {
			start = 0;
		}

		else {
			if (index + 15 > arr.length) {
				start = arr.length - 29;
			} else {
				start = index - 14;
			}
		}

		for (int i = 0; i < 30; i++) {
			temp[i] = arr[start + i];
		}
		
		QuickSort.sort(temp, "lon"); 
	    index = binarySearch(temp, 0, temp.length, Point, "lon");
	    
	    Intersection[] temp1;
		temp1 = new Intersection[3];
		if (index <= 1) {
			start = 0;
		}

		else {
			if (index + 1 > temp.length) {
				start = arr.length - 2;
			} else {
				start = index - 1;
			}
		}

		for (int i = 0; i < 3; i++) {
			temp1[i] = temp[start + i];
		}

		nearbyPoints = temp1;
		
	}

	// this method take an array, its left and right index, and a search point
	// as inputs and returns the index for the closest point in the array
	// arr must be sorted based on latitude first
	public static int binarySearch(Intersection[] arr, int l, int r, Intersection x, String latOrlon) {

		if (latOrlon == "lat") {
			if (r < l) {
				if (x.getLatitude() - arr[r].getLatitude() < arr[l].getLatitude() - x.getLatitude()) {
					return r;
				}
				return l;
			}
		}

		else {
			if (r < l) {
				if (x.getLongitude() - arr[r].getLongitude() < arr[l].getLongitude() - x.getLongitude()) {
					return r;
				}
				return l;
			}
		}

		int mid = l + (r - l) / 2;

		// If the element is present at the
		// middle itself
		if (arr[mid] == x)
			return mid;

		// If element is smaller than mid, then
		// it can only be present in left subarray
		if (x.less(arr[mid], latOrlon))
			return binarySearch(arr, l, mid - 1, x, latOrlon);

		// Else the element can only be present
		// in right subarray
		return binarySearch(arr, mid + 1, r, x, latOrlon);
	}

	public Intersection[] getPoints() {
		return nearbyPoints;
	}

	public static void main(String[] args) {
		Intersection[] x = Reader.Hamilton(9000);
		System.out.println(x[0]);
		System.out.println(x[x.length - 1]);
		System.out.println("is sorted: " + QuickSort.isSorted(x, "lat"));
		QuickSort.sort(x, "lat");
		System.out.println("is sorted: " + QuickSort.isSorted(x, "lat"));
		System.out.println(x[1]);
		System.out.println(x[2]);
		System.out.println(x[3]);
		System.out.println(x[4]);
		System.out.println(x[5]);
		System.out.println(x[6]);
		System.out.println(x[7]);
		System.out.println(x[8]);
		System.out.println(x[9]);
		System.out.println(x[10]);
		NearbyPoints NP = new NearbyPoints(x[50], x);
		Intersection[] y = NP.getPoints();
		System.out.println(y.length);
		System.out.println("is sorted: " + QuickSort.isSorted(y, "lon"));
		System.out.println(x[50].distTo(y[0]));
		System.out.println(x[50].distTo(y[1]));
		System.out.println(x[50].distTo(y[2]));
		/*
		 * Intersection Testpoint1 = new Intersection( -79.75381256366813, 43.22605829);
		 * 
		 * System.out.println(QuickSort.binarySearch(x, 0, 252766, Testpoint1));
		 * Intersection Testpoint2 = new Intersection( -79.75381256366813, 43.22615829);
		 * System.out.println(QuickSort.binarySearch(x, 0, 252766, Testpoint2));
		 * System.out.println(x[1].distTo(x[2]));
		 */
	}

}
