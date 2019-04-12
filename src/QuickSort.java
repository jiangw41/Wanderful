

//code adapted from text book

import java.util.Random;
import java.lang.Math; 
import java.lang.Double; 


// Class used to perform a QuickSort on an Intersection[]
// Adaptation from Algorithms textbook
public class QuickSort {


	// This class should not be instantiated.

	/**
	 * Rearranges the array in ascending order, using the natural order.
	 * 
	 * @param a the array to be sorted
	 */
	public static void sort(Intersection[] x, String latOrlon) {
		Random(x);
		sort(x, 0, x.length - 1, latOrlon);
		assert isSorted(x, latOrlon);
	}


	// quicksort the subarray from a[lo] to a[hi]
	private static void sort(Intersection[] a, int lo, int hi, String latOrlon) {
		if (hi <= lo)
			return;
		int p = partition(a, lo, hi, latOrlon);
		sort(a, lo, p - 1, latOrlon);
		sort(a, p + 1, hi, latOrlon);
		assert isSorted(a, lo, hi, latOrlon);
	}

	// partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
	// and return the index j.
	private static int partition(Intersection[] a, int lo, int hi, String latOrlon) {
		int i = lo;
		int j = hi + 1;
		Intersection v = a[lo];
		while (true) {

			// find item on lo to swap
			i += 1;
			while (a[i].less(v, latOrlon)) {
				if (i == hi)
					break;
				i++;
			}

			// find item on hi to swap
			j -= 1;
			while (v.less(a[j], latOrlon)) {
				if (j == lo)
					break;
				j--; // redundant since a[lo] acts as sentinel
			}

			// check if pointers cross
			if (i >= j)
				break;

			exch(a, i, j);
		}

		// put partitioning item v at a[j]
		exch(a, lo, j);

		// now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
		return j;
	}

	public static boolean isSorted(Intersection[] a, String latOrlon) {
		return isSorted(a, 0, a.length - 1, latOrlon);
	}

	private static boolean isSorted(Intersection[] a, int lo, int hi, String latOrlon) {
		for (int i = lo + 1; i <= hi; i++) {
			if (a[i].less(a[i - 1], latOrlon))
				return false;}
		return true;
	}
    
    // Randomizes Intersections in an Intersection[]
    public static void Random(Intersection[] a) {
    	Random rand = new Random(); 
    	for (int i=0; i<a.length; i++) {
    		int n = rand.nextInt(a.length); 
    		Intersection temp = a[i]; 
    		a[i]= a[n]; 
    		a[n]= temp; 
    	}
    }   
      
    // Exchange a[i] and a[j]
    private static void exch(Intersection[] a, int i, int j) {
        Intersection swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    public static void main(String[] args) {
		Intersection[] x = Reader.Hamilton(); 
		System.out.println(x[0]); 
		System.out.println(x.length); 
		System.out.println(x[1]); 
		/*
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
		System.out.println(x[1].distTo(x[2]));
*/
	}


}

   


