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
	JButton submitButton;
	
	public WindowLogin(ActionListener navigateToRegister) {
		
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
		nameField.setText("Joko....");
		nameField.setForeground(Color.gray);
		nameField.setBounds((int)((MainWindow.winWidth * 0.5) - 150), (nameLabel.getY() + nameLabel.getHeight()) + 10, 300, 30);
		
		passLabel = new JLabel("Password");
		passLabel.setBounds((int)((MainWindow.winWidth * 0.5) - 150), (nameField.getY() + nameField.getHeight()) + 10, 200, 10);
		passField = new JTextField();
		passField.setText("*****");
		passField.setForeground(Color.gray);
		passField.setBounds((int)((MainWindow.winWidth * 0.5) - 150), (passLabel.getY() + passLabel.getHeight()) + 10, 300, 30);
		
		//Tombol
		submitButton = new JButton("submitButton");
		submitButton.setFocusable(false);
		submitButton.setBounds(passField.getX() + passField.getWidth() - 100, (passField.getY() + passField.getHeight()) + 20, 100, 40);
		
		
		//Adding Components
		add(pane1);
		add(nameLabel);
		add(nameField);
		add(passLabel);
		add(passField);
		add(submitButton);
	}

}
