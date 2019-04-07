
public class Intersection {
	
	private final double lon;
	private final double lat;
	
	Intersection(double longitude, double latitude){
		this.lon = longitude;
		this.lat = latitude;
	}
	
	public double getLongitude(){
		return this.lon;
	}
	
	public double getLatitude(){
		return this.lat;
	}
	
	// Distance between two points to meters
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
	
	public String toString(){
		return "Latitude: " + this.lat + ", Longitude: " + this.lon;
	}
}
