import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

// Class is used to read data from the HamiltonGIS Dataset
public class Reader {
	
	// Reads dataset
	public static double[] Hamilton(){
		int recommendedSteps = 10000;
		double[] Location = new double [2];		// Array consisting of Longitude, Latitude
		
		try {
			Scanner input = new Scanner(new File("src/HamiltonGIS.csv"));
			//city = city.replaceAll(" ", "");	// Ignore spaces
			while (input.hasNextLine()){
				String current = input.nextLine();
				String[] list = current.split(",");						// Splits line by comma
				
				
				/* if longitude and latitude is within the current location's radius
				Location[0] = Double.parseDouble(list[3]);			// Longitude of city
				Location[1] = Double.parseDouble(list[4]);			// Latitude of city
				*/
				
				input.close();
				return Location;
			}
			input.close();
		}
		catch (FileNotFoundException e){
			System.out.println("File could not be found");
		}
		return null;
	}
	// Reads a certain area (fixed radius) around user's current location
	// Adds nodes inside area onto another text file - connect all nodes together
	
	
	// Reads USCities file and returns an array with the city's Latitude and Longitude
	public static double[] Cities(String city){
		double[] Location = new double [2];		// Array consisting of Latitude, Longitude
		try {
			Scanner input = new Scanner(new File("Datasets/USCities.csv"));
			city = city.replaceAll(" ", "");	// Ignore spaces
			while (input.hasNextLine()){
				String current = input.nextLine();
				String[] list = current.split(",");						// Splits line by comma
				if (city.toUpperCase().equals(list[3].replaceAll(" ", ""))){	// If city is found in file
					Location[0] = Double.parseDouble(list[4]);			// Longitude of city
					Location[1] = Double.parseDouble(list[5]);			// Latitude of city
					input.close();
					return Location;
				}
			}
			input.close();
		}
		catch (FileNotFoundException e){
			System.out.println("File could not be found");
		}
		return null;
	}
}