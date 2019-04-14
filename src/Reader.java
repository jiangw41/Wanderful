import java.io.*;
import java.util.Scanner;

// Class is used to read data from the HamiltonGIS Dataset
public class Reader {

	// Parses Street Number to remove unwanted characters
	public static String parseStrNum(String num) {
		// Removes the string following a ":" or " "
		if (num.contains(":")) {
			String[] str = num.split("\\:");
			num = str[0];
		} 
		else if (num.contains(" ")) {
			String[] str = num.split(" ");
			num = str[0];
		}
		return num;
	}

	// Reads dataset and returns an Intersection[] of Intersections within User's
	// Goal
	public static Intersection[] Hamilton() {
		Intersection[] intersection = new Intersection[252766]; // Intersection[] to hold up to 252766 points
		int i = 0; // Used to store Intersections into the Intersection[]

		try {
			Scanner input = new Scanner(new File("src/HamiltonGIS.csv"));
			String current = input.nextLine();
			while (input.hasNextLine()) {
				current = input.nextLine();
				String[] list = current.split(","); // Splits line by comma

				// New Intersection containing Street Number, Street Name, Latitude, Longitude
				intersection[i] = new Intersection(parseStrNum(list[5]), list[7], Double.parseDouble(list[4]),
						Double.parseDouble(list[3]));
				i++;
				/*
				if (intersection[i].distTo(user) < goal){ // if currentlocation to points in dataset is within reqMeters
					i++; // saves this as intersection[i] and looks for next one
					//System.out.println(intersection[i].distTo(user));
				}
				
				System.out.println(intersection[i].distTo(user));
				*/
				 
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("File could not be found");
		}
		return intersection;
	}

	// Finds the closest point to the user
	public static Intersection currentLocation(String num, String street) {
		Intersection intersection = new Intersection(); // Holds the closest address to user's location
		int i = -1; // Counter used to check if first address found

		try {
			Scanner input = new Scanner(new File("src/HamiltonGIS.csv"));
			String current = input.nextLine();
			while (input.hasNextLine()) {
				current = input.nextLine();
				String[] list = current.split(","); // Splits line by comma

				// If Street is the same as the User's Street
				if (list[7].equals(street)) {

					// If address found is closer to previously saved address
					if (Math.abs(Integer.parseInt(num) - Integer.parseInt(parseStrNum(list[5]))) < i) {
						// Updates Street Number, Latitude, Longitude
						intersection.update(parseStrNum(list[5]), Double.parseDouble(list[4]),
								Double.parseDouble(list[3]));
						// Difference between User's Street Number and Current Street Number
						i = Math.abs(Integer.parseInt(num) - Integer.parseInt(parseStrNum(list[5])));
					}

					// Updates address to first address with the same street name
					else if (i < 0) {
						// New Intersection containing Street Number, Street Name, Latitude, Longitude
						intersection = new Intersection(parseStrNum(list[5]), list[7], Double.parseDouble(list[3]),
								Double.parseDouble(list[4]));
						// Difference between User's Street Number and First Street Number found
						i = Math.abs(Integer.parseInt(num) - Integer.parseInt(parseStrNum(list[5])));
					}
				}
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("File could not be found");
		}
		return intersection;
	}
}