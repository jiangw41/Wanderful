
public class NearbyPoints {
	private Intersection[] nearbyPoints;

	// takes a point and the data array as inputs and create its nearby points into
	// an array;
	public NearbyPoints(Intersection Point, Intersection[] arr) {
		QuickSort.sort(arr, "lat"); 									// sort the array based on latitude first
		int index = binarySearch(arr, 0, arr.length, Point, "lat");		// index of Point in sorted array
		Intersection[] temp;
		temp = new Intersection[30];
		int start;								
		if (index <= 14) {												// If on lower end
			start = 0;
		}

		else {
			if (index + 15 > arr.length-1) {							// If on the upper end
				start = arr.length - 29;								
			} else {													
				start = index - 14;
			}
		}

		for (int i = 0; i < 30; i++) {									// temp holds 30 closest points
			temp[i] = arr[start + i];
		}

		QuickSort.sort(temp, "lon");									// Sorts temp by longitude
		index = binarySearch(temp, 0, temp.length, Point, "lon");		// Binary search from 0 - 30 to find index

		Intersection[] temp1;											
		temp1 = new Intersection[3];
		if (index <= 1) {
			start = 0;
		}

		else if (index + 1 > temp.length-1) {
			start = temp.length - 3;
		} 
		else {
			start = index - 1;
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

}
