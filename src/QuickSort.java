

//code adapted from text book

import java.util.Random; 
import java.lang.Math; 
import java.lang.Double; 

public class QuickSort {

    // This class should not be instantiated.

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Intersection[] x) {
        Random(x);
        sort(x, 0, x.length - 1);
        assert isSorted(x);
    }
 
    public static void Random(Intersection[] a) {
    	Random rand = new Random(); 
    	for (int i=0; i<a.length; i++) {
    		int n = rand.nextInt(a.length); 
    		Intersection temp = a[i]; 
    		a[i]= a[n]; 
    		a[n]= temp; 
    	}
    }

    // quicksort the subarray from a[lo] to a[hi]
    private static void sort(Intersection[] a, int lo, int hi) { 
        if (hi <= lo) return;
        int p = partition(a, lo, hi);
        sort(a, lo, p-1);
        sort(a, p+1, hi);
        assert isSorted(a, lo, hi);
    }

    // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
    // and return the index j.
    private static int partition(Intersection[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Intersection v = a[lo];
        while (true) { 

            // find item on lo to swap
        	i += 1; 
            while (a[i].less(v)) {
                if (i == hi) break;
                i++; 
            }

            // find item on hi to swap
            j -= 1; 
            while (v.less(a[j])) {
                if (j == lo) break;  
                j--; // redundant since a[lo] acts as sentinel
            }

            // check if pointers cross
            if (i >= j) break;

            exch(a, i, j);
        }

        // put partitioning item v at a[j]
        exch(a, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    /**
     * Rearranges the array so that {@code a[k]} contains the kth smallest key;
     * {@code a[0]} through {@code a[k-1]} are less than (or equal to) {@code a[k]}; and
     * {@code a[k+1]} through {@code a[n-1]} are greater than (or equal to) {@code a[k]}.
     *
     * @param  a the array
     * @param  k the rank of the key
     * @return the key of rank {@code k}
     * @throws IllegalArgumentException unless {@code 0 <= k < a.length}
     */
    public static Intersection select(Intersection[] a, int k) {
        if (k < 0 || k >= a.length) {
            throw new IllegalArgumentException("index is not between 0 and " + a.length + ": " + k);
        }
        Random(a);
        int lo = 0, hi = a.length - 1;
        while (hi > lo) {
            int i = partition(a, lo, hi);
            if      (i > k) hi = i - 1;
            else if (i < k) lo = i + 1;
            else return a[i];
        }
        return a[lo];
    }
      
    // exchange a[i] and a[j]
    private static void exch(Intersection[] a, int i, int j) {
        Intersection swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static boolean isSorted(Intersection[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Intersection[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (a[i].less(a[i-1])) return false;
        return true;
    }
    
    public static void main(String[] args) {
		Intersection[] x = Reader.Hamilton(9000); 
		System.out.println(x[0]); 
		System.out.println(x[x.length-1]); 
		System.out.println("is sorted: " + QuickSort.isSorted(x)); 
		QuickSort.sort(x); 
		System.out.println("is sorted: " + QuickSort.isSorted(x)); 
		System.out.println(x[1]); 
		System.out.println(x[2]); 
		/*
		System.out.println(x[3]); 
		System.out.println(x[4]); 
		System.out.println(x[5]); 
		System.out.println(x[6]); 
		System.out.println(x[7]); 
		System.out.println(x[8]);
		System.out.println(x[9]);
		System.out.println(x[10]);
		*/
		System.out.println(x[1].distTo(x[2]));
	}
   
}
