import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

// Class is used to read data from the HamiltonGIS Dataset
public class Reader {
	
	// Reads dataset
	public static Intersection[] Hamilton(int currentMeters){
		int recommendedMeters = 9000;
		int reqMeters = recommendedMeters - currentMeters;
		Intersection[] intersection = new Intersection[252766];
<<<<<<< HEAD
		int i = 0;
		Intersection currentLocation = new Intersection(-79.918862, 43.258470);
		
		try {
			Scanner input = new Scanner(new File("src/HamiltonGIS.csv"));
			String current = input.nextLine();
			while (input.hasNextLine()){
				current = input.nextLine();
				String[] list = current.split(",");						// Splits line by comma
				intersection[i] = new Intersection(Double.parseDouble(list[3]), Double.parseDouble(list[4]));
				if (true){	// if currentlocation to points in dataset is within reqMeters
					i++;	// saves this as intersection[i] and looks for next one
				}
				//System.out.println(currentLocation.distTo(intersection[i]));
=======
		int i = 0;		// i refers to the ObjectID in dataset
		
		try {
			Scanner input = new Scanner(new File("Wanderful/src/HamiltonGIS.csv"));
			String current = input.nextLine();
			while (input.hasNextLine()){
				current = input.nextLine(); 
				String[] list = current.split(",");						// Splits line by comma
				if (true){	// if longitude and latitude is within the current location's radius
					intersection[i] = new Intersection(Double.parseDouble(list[3]), Double.parseDouble(list[4]));
					i++;	
				}
				/* if longitude and latitude is within the current location's radius
				Location[0] = Double.parseDouble(list[3]);			// Longitude of city
				Location[1] = Double.parseDouble(list[4]);			// Latitude of city
				*/
>>>>>>> 770d515c504828d5640065c7e15e3d6a202e8571
			}
			input.close();
			return intersection;
		}
		catch (FileNotFoundException e){
			System.out.println("File could not be found");
		}
		return intersection;
	}

	// Reads a certain area (fixed radius) around user's current location
	// Adds nodes inside area onto another text file - connect all nodes together
	
	// Obtains points from dataset within a radius of user's recommended number of steps left
	// Connects the points to a graph
	public static void region(Intersection[] x){
<<<<<<< HEAD
		for(int i = 0; i<x.length; i++){
			System.out.println(x[i]);
		}
		System.out.println(x.length);
=======
		
>>>>>>> 770d515c504828d5640065c7e15e3d6a202e8571
	}
	
}