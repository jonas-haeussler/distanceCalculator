package calculator.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import calculator.data.Car;
import calculator.data.Driver;
import calculator.data.Patient;

public class DayPanel extends JPanel {
	private JLabel weekDay;
	private JTable table1;
	private JTable table2;
	private MainFrame parent;
	private int patientsCount;
	private int dayOfWeek;
	private String day;
	
	private JLabel patientsLabel;
	private JLabel driversLabel;
	
	private ArrayList<Patient> patients;
	private ArrayList<Driver> drivers;
	
	
	public DayPanel(MainFrame parent, int weekDay, ArrayList<Patient> patients, ArrayList<Driver> drivers) {
//		System.out.println(patients.get(0));
		this.parent = parent;
		this.patients = patients;
		this.drivers = drivers;
//		day = "";
//		switch(weekDay) {
//		case 0 : day = "Monday"; break;
//		case 1 : day = "Tuesday"; break;
//		case 2 : day = "Wednesday"; break;
//		case 3 : day = "Thursday"; break;
//		case 4 : day = "Friday"; break;
//		}
		this.dayOfWeek = weekDay;
		patientsCount = patients.size();
		initComponents();
		drawDayBoard();
		
		
	}
	public void initComponents() {
		this.setLayout(new BorderLayout());
//		this.weekDay = new JLabel(day);
		patientsLabel = new JLabel("Patients");
		patientsLabel.setFont(new Font("", Font.BOLD, 20));
		driversLabel = new JLabel("Drivers");
		driversLabel.setFont(new Font("", Font.BOLD, 20));
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		panel.add(patientsLabel);
		panel.add(driversLabel);
		add(panel, BorderLayout.NORTH);
	}
	
	public void drawDayBoard() {
		Object[][] data = new Object[patientsCount][10];
		String[] columns = {"Name", "Adresse", "Tel.", "Bemerkung","Abholung"};
		Patient patient;
		for (int i = 0; i < data.length; i++) {
			patient = patients.get(i);
			ArrayList<Date> dates = patient.getDates();
			data[i][0] = "" + patient.getName();
			data[i][1] = "" + patient.getAdress().toString();
			data[i][2] = "" + patient.getTelNr();
			data[i][3] = "" + (patient.hasRolator() ? "Rollator" : "Patient begleiten");
			for (Date d : dates) {
				if(d.getDay() == dayOfWeek + 1 && d.getHours() < 10) {
					data[i][4] = "" + d.getHours() + ":" + d.getMinutes();
				}
			}

		}
		table1 = new JTable(data, columns);
		data = new Object[drivers.size()][4];
		columns = new String[]{"Name", "FahrzeugNr", "FahrzeugModell", "Sitzplätze"}; 
		for (int i = 0; i < data.length; i++) {
			Driver driver = drivers.get(i);
			Car car = driver.getCar();
			data[i][0] = "" + driver.getDriverName();
			data[i][1] = "" + car.getCarId();
			data[i][2] = "" + car.getModel();
			data[i][3] = "" + car.getNumberOfSeats();
			}
		table2 = new JTable(data, columns);
		
		JScrollPane scrollPane = new JScrollPane(table1);
		scrollPane.setPreferredSize(new Dimension(622, 91));
		JScrollPane scrollPane2 = new JScrollPane(table2);
		scrollPane2.setPreferredSize(new Dimension(622, 91));
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		panel.add(scrollPane);
		panel.add(scrollPane2);
		add(panel, BorderLayout.CENTER);
	}
	public int countPatients(int weekDay) {
		ArrayList<Date> dates;
		int counter = 0;
		for(int i = 0; i < patients.size(); i++) {
			dates = patients.get(i).getDates();
			for (int j = 0; j < dates.size(); j++) {
				if(dates.get(j).getDay() == weekDay + 1) {
					counter++;
					break;
				}
			}
			
		}
		return counter;
	}
	public JTable getDriversTable() {
		return table2;
	}
	public JTable getPatientsTable() {
		return table1;
	}
}
