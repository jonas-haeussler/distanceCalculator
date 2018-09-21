package calculator.data;

import calculator.ctrl.RawStreetMapData;

public class Adress {
	private String street;
	private int houseNumber;
	private int postCode;
	private String city;
	private double[] coordinates;
	private int direction;
	public boolean hasDriver;
	public String getStreet() {
		return street;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public int getPostCode() {
		return postCode;
	}

	public String getCity() {
		return city;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setHouseNumber(byte houseNumber) {
		this.houseNumber = houseNumber;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Adress(String street, int houseNumber, int postCode, String city) {
		super();
		this.street = street;
		this.houseNumber = houseNumber;
		this.postCode = postCode;
		this.city = city;
		coordinates = RawStreetMapData.getCoordinates(this);
	}


	public double[] getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(double[] coordinates) {
		this.coordinates = coordinates;
	}
	@Override
	public String toString() {
		return "" + street + " " +  houseNumber + ", " + postCode + " " + city;
	}
	public void calculateDirection(Adress center) {
		if(this.getCoordinates()[0] - center.getCoordinates()[0] < 0) {
			if(this.getCoordinates()[1] - center.getCoordinates()[1] < 0) {
				direction = 0;
			}
			else {
				direction = 1;
			}
		}
		else {
			if(this.getCoordinates()[1] - center.getCoordinates()[1] < 0) {
				direction = 2;
			}
			else {
				direction = 3;
			}
		}
	}
	
	
}
