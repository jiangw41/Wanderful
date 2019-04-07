import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

// Class is used to read data from the HamiltonGIS Dataset
public class Reader {
	
	// Reads dataset
	public static void Hamilton(){
		int recommendedSteps = 10000;
		try {
			Scanner input = new Scanner(new File("src/HamiltonGIS.csv"));
			while (input.hasNextLine()){
				String current = input.nextLine();
				String[] list = current.split(",");						// Splits line by comma
				
				Intersection x = new Intersection(Float.parseFloat(list[3]), Float.parseFloat(list[4]));
				/* if longitude and latitude is within the current location's radius
				Location[0] = Double.parseDouble(list[3]);			// Longitude of city
				Location[1] = Double.parseDouble(list[4]);			// Latitude of city
				*/
				
				input.close();
			}
			input.close();
		}
		catch (FileNotFoundException e){
			System.out.println("File could not be found");
		}
	}
	
	// Reads a certain area (fixed radius) around user's current location
	// Adds nodes inside area onto another text file - connect all nodes together
}