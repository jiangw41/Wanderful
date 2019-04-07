
public class Intersection {
	
	private final float lon;
	private final float lat;
	
	Intersection(float longitude, float latitude){
		this.lon = longitude;
		this.lat = latitude;
	}
	
	public float getLongitude(){
		return this.lon;
	}
	
	public float getLatitude(){
		return this.lat;
	}
	
	public float distTo(Intersection x){
		float a = this.lat - x.lat;
		float b = this.lon - x.lon;
		return (float) Math.sqrt(a*a + b*b);
	}
}
