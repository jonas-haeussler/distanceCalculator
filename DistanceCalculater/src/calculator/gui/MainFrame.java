package calculator.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.temporal.IsoFields;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

import calculator.ctrl.DataHandler;
import calculator.data.Driver;
import calculator.data.Patient;


public class MainFrame extends JFrame implements ActionListener {
	private JMenu menuFile;
	private JMenu menuEdit;
	private JMenu menuExtra;
	private JMenu menuHelp;
	private JMenuBar bar;
	
	private JMenuItem menuItemSave;
	private JMenuItem menuItemSaveAs;
	private JMenuItem menuItemCalculateList;
	private JMenuItem menuItemAddDriver;
	private JMenuItem menuItemAddPatient;
	private JMenuItem menuItemAddCar;
	
	
	private JLabel weekOfTheYear;
	
	private JTabbedPane tabPane;
	
	private ArrayList<Patient> patients;
	private ArrayList<Driver> drivers;
	
	private DayPanel panelMonday;
	private DayPanel panelTuesday;
	private DayPanel panelWednesday;
	private DayPanel panelThursday;
	private DayPanel panelFriday;
	
	public MainFrame(ArrayList<Patient> patients, ArrayList<Driver> drivers) {
		this.patients = patients;
		this.drivers = drivers;
		setSize(800, 500);
		setLocationRelativeTo(null);
		initComponents();
		
		setVisible(true);
		
	}
	private void initComponents() {
		LocalDate localDate = LocalDate.now();
		weekOfTheYear = new JLabel("Week: " + localDate.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR));
		weekOfTheYear.setFont(new Font("", Font.BOLD, 30));
		weekOfTheYear.setLocation(5, 10);
		
		panelMonday = new DayPanel(this, 0, DataHandler.getPatients(this, 0), DataHandler.getDrivers(this, 0));
		panelTuesday = new DayPanel(this, 1, DataHandler.getPatients(this, 1), DataHandler.getDrivers(this, 1));
		panelWednesday = new DayPanel(this, 2, DataHandler.getPatients(this, 2), DataHandler.getDrivers(this, 2));
		panelThursday = new DayPanel(this, 3, DataHandler.getPatients(this, 3), DataHandler.getDrivers(this, 3));
		panelFriday = new DayPanel(this, 4, DataHandler.getPatients(this, 4), DataHandler.getDrivers(this, 4));


		bar = new JMenuBar();
		menuFile = new JMenu();
		menuEdit = new JMenu();
		menuExtra = new JMenu();
		menuHelp = new JMenu();
		
		menuItemSave = new JMenuItem("Save");
		menuItemSaveAs = new JMenuItem("Save As...");
		menuItemCalculateList = new JMenuItem("Calculate List...");
		menuItemAddDriver = new JMenuItem("Add Driver");
		menuItemAddPatient = new JMenuItem("Add Patient");
		menuItemAddCar = new JMenuItem("Add Car");
		
		
		tabPane = new JTabbedPane();
		tabPane.addTab("Monday", panelMonday);
		tabPane.addTab("Tuesday", panelTuesday);
		tabPane.addTab("Wednesday", panelWednesday);
		tabPane.addTab("Thursday", panelThursday);
		tabPane.addTab("Friday", panelFriday);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		menuFile.setText("File");
		
		
		
		menuEdit.setText("Edit");
		menuExtra.setText("Extra");
		menuHelp.setText("Help");
		
		menuItemSave.addActionListener(this);
		menuItemSaveAs.addActionListener(this);
		menuItemCalculateList.addActionListener(this);
		menuItemAddDriver.addActionListener(this);
		menuItemAddPatient.addActionListener(this);
		menuItemAddCar.addActionListener(this);
		
		menuFile.add(menuItemSave);
		menuFile.add(menuItemSaveAs);
		menuFile.add(menuItemCalculateList);
		menuEdit.add(menuItemAddDriver);
		menuEdit.add(menuItemAddPatient);
		menuEdit.add(menuItemAddCar);

		
		
		
		bar.add(menuFile);
		bar.add(menuEdit);
		bar.add(menuExtra);
		bar.add(menuHelp);
		
		setJMenuBar(bar);
		contentPane.add(weekOfTheYear, BorderLayout.NORTH);
		contentPane.add(tabPane, BorderLayout.CENTER);
		
		
		
		
	}
	public ArrayList<Patient> getAllPatients(){
		return patients;
	}
	public ArrayList<Driver> getAllDrivers(){
		return drivers;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem) e.getSource();
		if(item.equals(menuItemAddDriver)) {
			AddDriverDialog dialog = new AddDriverDialog();
		}
	}
	public DayPanel getMondayPanel() {
		return panelMonday;
	}
	
}
