// Class to locate 2 nearby Intersections
// Finds a subarray with 30 closest points latitude-wise
// Then finds the closest two points longitude-wise
public class NearbyPoints {
	private Intersection[] nearbyPoints;

	// Takes a point and the dataset and generates an Intersection[] holding 2 nearby Intersections
	public NearbyPoints(Intersection Point, Intersection[] arr) {
		QuickSort.sort(arr, "lat"); 									// Sorts the array based on Latitude first
		// Finds the index of the given point, in the sorted dataset
		int index = binarySearch(arr, 0, arr.length, Point, "lat");
		
		// Finds the 30 closest Intersection's to the point based on Latitude
		Intersection[] temp = new Intersection[30];
		int start;								
		
		// If on the upper end of dataset, we grab a subarray from 0-30 (start = 0)
		if (index <= 14) {
			start = 0;
		}
		// If on upper end of dataset, we grab a subarray from the last 30 points (start = length-29)
		else if (index + 15 > arr.length-1) {
			start = arr.length - 29;								
		} 
		// Otherwise, get 30 nearby points around the given point (14 on lower end, 15 on higher end)
		else {													
			start = index - 14;
		}

		// Holds the 30 nearby points in the temp array
		for (int i = 0; i < 30; i++) {
			temp[i] = arr[start + i];
		}

		QuickSort.sort(temp, "lon");									// Sorts the temp array based on Longitude
		index = binarySearch(temp, 0, temp.length, Point, "lon");		// Binary search from 0 - 30 to find index of given point

		// Finds the 2 closest Intersection's based on Longitude from the previous subarray
		Intersection[] temp1 = new Intersection[2];
		
		// If left-most point, hold the following two points 
		if (index <= 1) {
			start = 0;
			temp1[0] = temp[start+1];
			temp1[1] = temp[start+2];
		}
		// If right-mode point, hold the previous two points
		else if (index + 1 > temp.length-1) {
			start = temp.length - 3;
			temp1[0] = temp[start];
			temp1[1] = temp[start+1];
		} 
		// Otherwise, hold the previous and next point
		else {
			start = index - 1;
			temp1[0] = temp[start];
			temp1[1] = temp[start+2];
		}
		
		nearbyPoints = temp1;

	}

	// Takes an array, its left and right index, and a search point as inputs 
	// Returns the index for the point in the array
	// arr must be sorted based on latitude first
	public static int binarySearch(Intersection[] arr, int l, int r, Intersection x, String latOrlon) {

		// When right index is less than left index in a Latitudinal search
		if (latOrlon == "lat") {
			if (r < l) {
				if (Math.abs(x.getLatitude() - arr[r].getLatitude()) < Math.abs(x.getLatitude() - arr[l].getLatitude())) {
					return r;
				}
				return l;
			}
		}
		
		// When right index is less than left index in a Longitudinal search
		else {
			if (r < l) {
				if (Math.abs(x.getLongitude() - arr[r].getLongitude()) < Math.abs(x.getLongitude() - arr[l].getLongitude())) {
					return r;
				}
				return l;
			}
		}

		int mid = l + (r - l) / 2;

		// If the element is present at the middle itself
		if (arr[mid] == x)
			return mid;

		// If element is smaller than mid, then search in left subarray
		if (x.less(arr[mid], latOrlon))
			return binarySearch(arr, l, mid - 1, x, latOrlon);

		// Else element is bigger than mid, then search in right subarray
		return binarySearch(arr, mid + 1, r, x, latOrlon);
	}

	// Returns a list holding 2 nearby points
	public Intersection[] getPoints() {
		return nearbyPoints;
	}

}
