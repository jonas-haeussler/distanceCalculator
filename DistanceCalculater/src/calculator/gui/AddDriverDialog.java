package calculator.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import calculator.ctrl.DataHandler;
import calculator.data.Car;
import calculator.data.Driver;

public class AddDriverDialog extends JDialog implements ActionListener {
	private JLabel labelFirstName;
	private JLabel labelLastName;
	private JLabel labelSelectCar;
	
	private JTextField firstName;
	private JTextField lastName;
	private JComboBox<Car> menuCars;
	
	private JButton buttonOk;
	private JButton buttonCancel;
	
	public AddDriverDialog() {
		labelFirstName = new JLabel("Enter First Name: ");
		labelLastName = new JLabel("Enter Last Name: ");
		labelSelectCar = new JLabel("Please Select Car...");
		
		firstName = new JTextField();
		lastName = new JTextField();
		menuCars = new JComboBox<>();
		ArrayList<Car> cars = new ArrayList<>();
		for(Car c : cars) {
			menuCars.addItem(c);
		}
		buttonCancel = new JButton("Cancel");
		buttonOk = new JButton("OK");
		
		setTitle("Add Driver...");
		setSize(new Dimension(500, 200));
		JPanel panel = new JPanel();
	
		setLayout(new BorderLayout());
		panel.setLayout(new GridLayout(4, 2));
		panel.add(labelFirstName);
		panel.add(firstName);
		panel.add(labelLastName);
		panel.add(lastName);
		panel.add(labelSelectCar);
		panel.add(menuCars);
		panel.add(buttonOk);
		panel.add(buttonCancel);
		
		buttonOk.addActionListener(this);
		buttonCancel.addActionListener(this);
		
		add(new JLabel(" "), BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if(button.equals(buttonOk)) {
			Car car = (Car) menuCars.getSelectedItem();
			if(car == null) {
				JOptionPane.showMessageDialog(this, "Please Select A Car", "No Car Selected", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if(firstName.getText().equals("") || lastName.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Please Insert A Name", "No Name Inserted", JOptionPane.ERROR_MESSAGE);
				return;
			}
			Driver driver = new Driver(firstName.getText() + " " + lastName.getText(), car);
			DataHandler.addDriver(driver);
			this.dispose();
		}
		else {
			this.dispose();
		}
	}
	
	
	
}
