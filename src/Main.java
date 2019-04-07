import java.util.Scanner;

public class Main {

	public static int userInput(){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter distance travelled in meters: ");
		return in.nextInt();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//userInput();
		
		Intersection[] x = Reader.Hamilton(userInput());
		System.out.println(x[1]);
		System.out.println(x[1].distTo(x[2]));
		
	}

}
