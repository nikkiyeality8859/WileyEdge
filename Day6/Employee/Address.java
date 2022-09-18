package Day6Assignment;

public class Address {
	public int flatNumber;
	String flatName, roadName, cityName;

	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Address(int flatNumber, String flatName, String roadName, String cityName) {
		super();
		this.flatNumber = flatNumber;
		this.flatName = flatName;
		this.roadName = roadName;
		this.cityName = cityName;
	}


	@Override
	public String toString() {
		return "Address [flatNumber=" + flatNumber + ", flatName=" + flatName + ", roadName=" + roadName + ", cityName="
				+ cityName + "]";
	}
	

}
