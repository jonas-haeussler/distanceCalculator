package calculator.ctrl;

import java.time.LocalDate;
import java.time.temporal.IsoFields;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import calculator.data.Car;
import calculator.data.Driver;
import calculator.data.Patient;
import calculator.gui.DayPanel;
import calculator.gui.MainFrame;

public class DataHandler {
	private static ArrayList<Patient> patients;
	private static ArrayList<Driver> drivers;
	private static ArrayList<Car> cars;
	private static MainFrame mf;
	
	public static ArrayList<Patient> getPatients(MainFrame mf, int day){
		patients = mf.getAllPatients();
		ArrayList<Patient> patientsList = new ArrayList<>();
		for (int i = 0; i < patients.size(); i++) {
			for (Date d : patients.get(i).getDates()) {
				if(d.getDay() == day + 1) {
					patientsList.add(patients.get(i));
					break;
				}
			}
		}
		return patientsList;
	}
	public static ArrayList<Driver> getDrivers(MainFrame mf, int day) {
		drivers = mf.getAllDrivers();
		ArrayList<Driver> driversList = new ArrayList<>();
		for (int i = 0; i < drivers.size(); i++) {
			for (Date d : drivers.get(i).getDates()) {
				if(d.getDay() == day + 1) {
					driversList.add(drivers.get(i));
					break;
				}
			}
		}
		return driversList;
	}
	public static void addDriver(Driver d) {
		drivers.add(d);
		ArrayList<Date> dates = d.getDates();
		LocalDate ld = LocalDate.now(); 
		for(Date date : dates) {
			if(date.getDate() <= ld.getDayOfMonth() + 4 && date.getDate() >= ld.getDayOfMonth()) {
				if(date.getDay() == 1) {
					DayPanel dPanel = mf.getMondayPanel();
					DefaultTableModel model = (DefaultTableModel) dPanel.getDriversTable().getModel();
				}
			}
		}
	}
}
