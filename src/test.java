import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		ArrayList<Integer> test = new ArrayList<Integer>(); 
		for (int i = 0; i<3; i++ ) {
		 test= new ArrayList<Integer>(); 
		test.add(i); }
		System.out.println(test.size()); 
		for (int i = 0; i < test.size(); i++) {
			System.out.println(test.get(i)); 
		}

	}

}
