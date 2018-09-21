package calculator.data;

public class Car {
	private String carId;
	private String model;
	private int numberOfSeats;
	public String getCarId() {
		return carId;
	}
	public String getModel() {
		return model;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public Car(String carId, String model, int numberOfSeats) {
		super();
		this.carId = carId;
		this.model = model;
		this.numberOfSeats = numberOfSeats;
	}
	
}
