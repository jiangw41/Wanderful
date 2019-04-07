import java.util.Scanner;

public class Main {

	public static void userInput(){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter number of steps: ");
		int input_steps = in.nextInt();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//userInput();
		
		Intersection[] x = Reader.Hamilton();
		System.out.println(x[1]);
		
		
	}

}
