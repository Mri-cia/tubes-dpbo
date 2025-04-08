package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WindowLogin extends JPanel  {
	ImageIcon loginIcon;
	JLabel nameLabel;
	JLabel passLabel;
	JTextField nameField;
	JTextField passField;
	String nameFlavor = "Joko...";
	String passFlavor = "8safva8";
	JButton submitButton;
	JRadioButton optionPembeli;
	JRadioButton optionPenjual;
	ButtonGroup buttonGroup;
	
	public WindowLogin(ActionListener userPenjual, ActionListener userPembeli) {
		
		//STYLING//
		//Set layout 
		setLayout(null);
		
		//Panels
		JPanel pane1 = new JPanel();
		pane1.setBackground(Color.red);
		pane1.setBounds((int)((MainWindow.winWidth * 0.5) - 75), (int)(MainWindow.winWidth * 0.1), 150, 150);
		
		//Form
		//Username field
		nameLabel = new JLabel("Username");
		nameLabel.setBounds((int)((MainWindow.winWidth * 0.5) - 150), (pane1.getY() + pane1.getHeight()) + 25, 200, 10);
		nameField = new JTextField();
		nameField.setText(nameFlavor);
		nameField.setForeground(Color.gray);
		nameField.setBounds((int)((MainWindow.winWidth * 0.5) - 150), (nameLabel.getY() + nameLabel.getHeight()) + 10, 300, 30);
		
		passLabel = new JLabel("Password");
		passLabel.setBounds((int)((MainWindow.winWidth * 0.5) - 150), (nameField.getY() + nameField.getHeight()) + 10, 200, 10);
		passField = new JTextField();
		passField.setText(passFlavor);
		passField.setForeground(Color.gray);
		passField.setBounds((int)((MainWindow.winWidth * 0.5) - 150), (passLabel.getY() + passLabel.getHeight()) + 10, 300, 30);
		
		//Tombol
		submitButton = new JButton("Submit");
		submitButton.setEnabled(false);
		submitButton.setFocusable(false);
		submitButton.setBounds(passField.getX() + passField.getWidth() - 100, (passField.getY() + passField.getHeight()) + 20, 100, 40);
		
		//Tipe User
		optionPenjual = new JRadioButton("Penjual");
		optionPenjual.setBounds(passField.getX() + 100, (passField.getY() + passField.getHeight()) + 20, 80, 40);
		optionPembeli = new JRadioButton("Pembeli");
		optionPembeli.setBounds(passField.getX(), (passField.getY() + passField.getHeight()) + 20, 80, 40);
		
		//Adding Components
		add(pane1);
		add(nameLabel);
		add(nameField);
		add(passLabel);
		add(passField);
		add(submitButton);
		add(optionPembeli);
		add(optionPenjual);
		
		//ALGORITHM
		//Grouping radio button
		buttonGroup = new ButtonGroup();
		buttonGroup.add(optionPenjual);
		buttonGroup.add(optionPembeli);

		//Enabling submit button
		ItemListener enableSubmit = e -> {
		    if ((optionPenjual.isSelected() || optionPembeli.isSelected()) && validateForm()) {
		        submitButton.setEnabled(true);
		    }
		};
		optionPenjual.addItemListener(enableSubmit);
		optionPembeli.addItemListener(enableSubmit);
		
		//OnClicked submit button
		submitButton.addActionListener(e -> {
		    if (optionPenjual.isSelected()) {
		        userPenjual.actionPerformed(e);
		    } else if (optionPembeli.isSelected()) {
		        userPembeli.actionPerformed(e);
		    }
		});
	}
	
	//Validating if the text field is filled and not the same as placeholder
	private boolean validateForm() {
	    String name = nameField.getText().trim();
	    String pass = passField.getText().trim();
	    boolean isNameValid = !name.equals("") && !name.equals(nameFlavor);
	    boolean isPassValid = !pass.equals("") && !pass.equals(passFlavor);
	    
	    return isNameValid && isPassValid;
	}
}
