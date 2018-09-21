package calculator.data;

import java.util.ArrayList;
import java.util.Date;

public class Patient {
	private String name;
	private Adress adress;
	private int telNr;
	private boolean rolator;
	private ArrayList<Date> dates;
	/*
	 * 
	 */
	// Reha : true, Maintenance : false 
	/*
	 * 
	 */
	private boolean rehaOrMaintenance;
	private Driver driver;
	
	public boolean isRolator() {
		return rolator;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public boolean hasRolator() {
		return rolator;
	}
	public void setRolator(boolean rolator) {
		this.rolator = rolator;
	}
	public int getTelNr() {
		return telNr;
	}
	public void setTelNr(int telNr) {
		this.telNr = telNr;
	}
	public String getName() {
		return name;
	}
	public Adress getAdress() {
		return adress;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	public void addDate(Date date) {
		dates.add(date);
	}
	public ArrayList<Date> getDates() {
		return dates;
	}
	public void setDates(ArrayList<Date> dates) {
		this.dates = dates;
	}
	public boolean getRehaOrMaintenance() {
		return rehaOrMaintenance;
	}
	public void setRehaOrMaintenance(boolean rehaOrMaintenance) {
		this.rehaOrMaintenance = rehaOrMaintenance;
	}
	public Patient(String name, Adress adress, int telNr, boolean rolator, ArrayList<Date> dates,
			boolean rehaOrMaintenance, Driver driver) {
		super();
		this.name = name;
		this.adress = adress;
		this.telNr = telNr;
		this.rolator = rolator;
		this.dates = dates;
		this.rehaOrMaintenance = rehaOrMaintenance;
		this.driver = driver;
	}
	
	
	
}
