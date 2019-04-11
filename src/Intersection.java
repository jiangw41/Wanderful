
public class Intersection {
	
	// Private Variables for a 
	private String num;
	private String str;
	private double lat;
	private double lon;
	
	// Empty Intersection - To be updated
	Intersection(){
		this.num = "";
		this.str = "";
		this.lon = 0;
		this.lat = 0;
	}
	
	// Intersection Object with Street Number, Street Name, and it's Latitude, Longitude coordinates
	Intersection(String num, String street, double latitude, double longitude){
		this.num = num;
		this.str = street;
		this.lat = latitude;
		this.lon = longitude;
	}
	
	// Return Latitude coordinate
	public double getLatitude(){
		return this.lat;
	}
	
	// Return Longitude coordinate
	public double getLongitude(){
		return this.lon;
	}
	
	// Function to update Street Number, Latitude and Longitude coordinates
	public void update(String n, Double latitude, Double longitude){
		this.num = n;
		this.lat = latitude;
		this.lon = longitude;
	}

	// Distance between two points using Lat/Lon coordinates to meters 
	public double distTo(Intersection x){
		double R = 6378.137; // Radius of earth in KM
		double dLat = Math.abs(this.lat * Math.PI / 180 - x.lat * Math.PI / 180);
		double dLon = Math.abs(this.lon * Math.PI / 180 - x.lon * Math.PI / 180);
		double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
		Math.cos(x.lat * Math.PI / 180) * Math.cos(this.lat * Math.PI / 180) *
		Math.sin(dLon/2) * Math.sin(dLon/2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double d = R * c;
		return d * 1000; // meters
	}
	
	// Checks if point has a smaller Latitude than another point
	public boolean less(Intersection w) {
    	return (this.lat < w.getLatitude()); 
    }
	
	// Print formatting
	public String toString(){
		return this.num + " " + this.str + " " + this.lat + ", " + this.lon;
	}
}
