import java.util.ArrayList;

public class test {

	public static int b = 5;
	public static int a = 5;
	
	public static void factorial2(ArrayList<ArrayList<Integer>> x){
		if (a <= 1)
			System.out.println("fini: " + x);
		else{
			a--;
			ArrayList<Integer> y = new ArrayList<Integer>();
			y.add(10);
			System.out.println(y);
			x.add(0, factorial(y));
			factorial2(x);
		}
	}
	
	public static ArrayList<Integer> factorial(ArrayList<Integer> x){
		if (b <= 1)
			return x;
		else{
			b--;
			x.add(10);
			return factorial(x);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> x = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> y = new ArrayList<Integer>();
		factorial2(x);
		//System.out.println(factorial2(y));
		/*
		ArrayList<Integer> test = new ArrayList<Integer>(); 
		for (int i = 0; i<3; i++ ) {
		 test= new ArrayList<Integer>(); 
		test.add(i); }
		System.out.println(test.size()); 
		for (int i = 0; i < test.size(); i++) {
			System.out.println(test.get(i)); 
		}
		*/
		
		/*
		ArrayList<Integer> x = new ArrayList<Integer>();
		ArrayList<Integer> y = new ArrayList<Integer>();
		y.add(10);
		y.add(11);
		x.add(9);
		y.add(12);
		x.addAll(x.size(), y);
		System.out.println(x);
		*/
		
		
 		
	}

}
