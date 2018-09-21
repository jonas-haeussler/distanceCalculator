package calculator.run;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import calculator.ctrl.DistanceHandler;
import calculator.ctrl.RawStreetMapData;
import calculator.data.Adress;
import calculator.data.Car;
import calculator.data.Driver;
import calculator.data.Patient;
import calculator.gui.MainFrame;

public class Main {
	public static void main(String[] args) {
//		DistanceHandler handler = new DistanceHandler((byte)2);
//		Adress center = new Adress("Frauenstrasse", 125, 89073, "Ulm");
		Adress adr3 = new Adress("Bergstrasse", 26, 89171, "Illerkirchberg");
		Adress adr = new Adress("Sebastian-Sailer-Weg", 5, 89171, "Illerkirchberg");
//		Adress adr2 = new Adress("Reichenauer-Weg", 11, 89077, "Ulm");
//		Adress adr4 = new Adress("Weinbergweg", 15, 89075, "Ulm");
//		
		Driver driver1 = new Driver("Jonas", new Car("RK27", "Ford Tourneo", 4));
//		Driver driver2 = new Driver("Laura", "RK40", 2);
//		
//		handler.addAdress(adr);
//		handler.addAdress(adr3);
//		handler.addAdress(adr2);
//		handler.addAdress(adr4);
//		
//		driver1.setAdresses(handler.getAdressList());
//		driver2.setAdresses(handler.getAdressList());
//		
//		driver1.start();
//		driver2.start();
//		try {
//			driver1.join();
//			driver2.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		for (int i = 0; i < driver1.getAdresses().length; i++) {
//			System.out.println("Driver: " + driver1.getDriverName());
//			System.out.println(driver1.getAdresses()[i].toString());
//		}
//		for (int i = 0; i < driver2.getAdresses().length; i++) {
//			System.out.println("Driver: " + driver2.getDriverName());
//			System.out.println(driver2.getAdresses()[i].toString());
//		}
		ArrayList<Date> dates = new ArrayList<>();
		dates.add(new Date(118, 5, 25));
		System.out.println(dates.get(0));
		Patient patient1 = new Patient("Ikke Hüftgold", adr3, 015731516, true, dates, true, driver1);
		ArrayList<Patient> patients = new ArrayList<>();
		ArrayList<Driver> drivers = new ArrayList<>();
		patients.add(patient1);
		drivers.add(driver1);
		new MainFrame(patients, drivers);
	}
}
