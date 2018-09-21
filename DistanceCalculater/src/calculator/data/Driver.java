package calculator.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class Driver extends Thread {
	private String name;
	private Car carName;
	private ArrayList<Date> dates;
	private Adress[] adresses;
	private static int counter;
	private LinkedList<Adress> allAdresses;
	public Driver(String name, Car carName) {
		this.name = name;
		this.carName = carName;
		adresses = new Adress[carName.getNumberOfSeats()];
		dates = new ArrayList<>();
	}
	public void setAdresses(LinkedList<Adress> allAdresses) {
		this.allAdresses = allAdresses;
		
	}
	public void removeDate(Date d) {
		dates.remove(d);
	}
	public void removeDate(int i) {
		dates.remove(i);
	}
	public void addDate(Date d) {
		dates.add(d);
	}
	
	public ArrayList<Date> getDates() {
		return dates;
	}
	public void setDriverName(String name) {
		this.name = name;
	}
	public void setDates(ArrayList<Date> dates) {
		this.dates = dates;
	}
	public Car getCar() {
		return carName;
	}
	public static int getCounter() {
		return counter;
	}
	public LinkedList<Adress> getAllAdresses() {
		return allAdresses;
	}
	public void setCar(Car carName) {
		this.carName = carName;
	}
	public void setAdresses(Adress[] adresses) {
		this.adresses = adresses;
	}
	public static void setCounter(int counter) {
		Driver.counter = counter;
	}
	public void setAllAdresses(LinkedList<Adress> allAdresses) {
		this.allAdresses = allAdresses;
	}
	@Override
	public void run() {
		for(int i = 0; i < allAdresses.size(); i++) {
			if(!allAdresses.get(i).hasDriver) {
				adresses[0] = allAdresses.get(i);
				counter++;
				adresses[0].hasDriver = true;
				break;
			}
		}
		double j = 0.01;
		int adrI = 1;
		while(adrI < adresses.length) {
			if(counter >= allAdresses.size()){
				break;
			}
			for(int i = 0; i < allAdresses.size(); i++) {
				if(!allAdresses.get(i).hasDriver) {
					if(Math.abs(allAdresses.get(i).getCoordinates()[0] - adresses[0].getCoordinates()[0]) < j) {
						if(Math.abs(allAdresses.get(i).getCoordinates()[1] - adresses[0].getCoordinates()[1]) < j) {
							adresses[adrI] = allAdresses.get(i);
							counter++;
							adresses[adrI].hasDriver = true;
							adrI++;
							if(adresses.length <= adrI)
								break;
						}
					}
				}
			}
			j += 0.01;
		}
	}
	public Adress[] getAdresses() {
		return adresses;
	}
	public String getDriverName() {
		return this.name;
	}
}
