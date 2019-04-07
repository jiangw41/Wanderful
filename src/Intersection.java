
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
	
	public double distTo(Intersection x){
		double a = this.lat - x.lat;
		double b = this.lon - x.lon;
		return Math.sqrt(a*a + b*b);
	}
	
	public String toString(){
		return "Latitude: " + this.lat + ", Longitude: " + this.lon;
	}
}
