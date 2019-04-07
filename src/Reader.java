import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

// Class is used to read data from the HamiltonGIS Dataset
public class Reader {
	
	// Reads dataset
	public static Intersection[] Hamilton(){
		int recommendedSteps = 10000;
		Intersection[] intersection = new Intersection[252767];
		int i = 0;		// i refers to the ObjectID in dataset
		try {
			Scanner input = new Scanner(new File("src/HamiltonGIS.csv"));
			while (input.hasNextLine()){
				String current = input.nextLine();
				String[] list = current.split(",");						// Splits line by comma
				if (i != 0){
					intersection[i] = new Intersection(Double.parseDouble(list[3]), Double.parseDouble(list[4]));
				}
				/* if longitude and latitude is within the current location's radius
				Location[0] = Double.parseDouble(list[3]);			// Longitude of city
				Location[1] = Double.parseDouble(list[4]);			// Latitude of city
				*/
				
				i++;
			}
			input.close();
		}
		catch (FileNotFoundException e){
			System.out.println("File could not be found");
		}
		return intersection;
	}
	
	// Reads a certain area (fixed radius) around user's current location
	// Adds nodes inside area onto another text file - connect all nodes together
}