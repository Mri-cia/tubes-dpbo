package app.view;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

import app.components.CusButton;

public class WindowLogin extends JPanel  {
	
	
	ImageIcon loginIcon;
	
	
	JLabel nameLabel;
	JLabel passLabel;
	
	JTextField nameField;
	JTextField passField;
	
	String nameFlavor = "Joko...";
	String passFlavor = "8safva8";
	
	
	CusButton submitButton;
	
	
	ButtonGroup buttonGroup;
	JRadioButton optionPembeli;
	JRadioButton optionPenjual;
	
	public WindowLogin(ActionListener userPenjual, ActionListener userPembeli) {
		
		//--MainPanel setup--//
		setLayout(new BorderLayout());
		JPanel headPanel = new JPanel();
		JPanel footPanel = new JPanel();
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		
		//testing boundaries
		//centerPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		
		//Uniform sizing
		int outerWidth = (int)(MainWindow.winWidth * 0.15);
		int outerHeight = (int)(MainWindow.winHeight * 0.1);
		headPanel.setPreferredSize(new Dimension((int)MainWindow.winWidth, outerHeight));
		footPanel.setPreferredSize(new Dimension((int)MainWindow.winWidth, outerHeight));
		leftPanel.setPreferredSize(new Dimension(outerWidth, (int)MainWindow.winHeight));
		rightPanel.setPreferredSize(new Dimension(outerWidth, (int)MainWindow.winHeight));
		
		add(headPanel, BorderLayout.NORTH);
		add(footPanel, BorderLayout.SOUTH);
		add(leftPanel, BorderLayout.WEST);
		add(rightPanel, BorderLayout.EAST);
		add(centerPanel, BorderLayout.CENTER);
		
		
		//--CentralPanel setup--//
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		JPanel logoPanel = new JPanel();
		JPanel namePanel = new JPanel();
		JPanel passPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		//testing boundaries
		//logoPanel.setBackground(Color.blue);
		//namePanel.setBackground(Color.red);
		//passPanel.setBackground(Color.yellow);
		//buttonPanel.setBackground(Color.pink);
		
		//Sizing
		logoPanel.setPreferredSize(new Dimension(0, 150));
		namePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
		passPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
		buttonPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
		
		centerPanel.add(logoPanel);
		centerPanel.add(Box.createRigidArea(new Dimension(0,20)));
		centerPanel.add(namePanel);
		centerPanel.add(Box.createRigidArea(new Dimension(0,10)));
		centerPanel.add(passPanel);
		centerPanel.add(Box.createRigidArea(new Dimension(0,10)));
		centerPanel.add(buttonPanel);
		centerPanel.add(Box.createRigidArea(new Dimension(0,10)));
		
		
		//--LogoPanel--//
		logoPanel.setLayout(new BoxLayout(logoPanel, BoxLayout.X_AXIS));
		JPanel logo = new JPanel();
		
		//testing boundaries
		logo.setBorder(BorderFactory.createBevelBorder(1));;
		
		logo.setMaximumSize(new Dimension(150,150));
		
		logoPanel.add(logo);
		
		
		//--Username Panel--//
		namePanel.setLayout(new GridBagLayout());
		GridBagConstraints nameGBC = new GridBagConstraints();
		nameLabel = new JLabel("Username");
		nameField = new JTextField("Username");
		
		nameLabel.setPreferredSize(new Dimension(250, 10));
		nameField.setPreferredSize(new Dimension(250, 25));
		
		nameGBC.insets = new Insets(0, 0, 10, 0);
		
		nameGBC.gridy = 1;
		namePanel.add(nameLabel, nameGBC);
		nameGBC.gridy = 2;
		nameGBC.insets = new Insets(0, 0, 0, 0);
		namePanel.add(nameField, nameGBC);
		
		
		//--Password Panel--//
		passPanel.setLayout(new GridBagLayout());
		GridBagConstraints passGBC = new GridBagConstraints();
		passLabel = new JLabel("Password");
		passField = new JTextField("****");
		
		passLabel.setPreferredSize(new Dimension(250, 10));
		passField.setPreferredSize(new Dimension(250, 25));
		
		passGBC.gridwidth = 1;
		passGBC.insets = new Insets(0, 0, 10, 0);
		
		passGBC.gridy = 1;
		passPanel.add(passLabel, passGBC);
		passGBC.gridy = 2;
		passGBC.insets = new Insets(0, 0, 0, 0);
		passPanel.add(passField, passGBC);
		
		
		//--Button Panel--//
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 7, 0));
		submitButton = new CusButton("Submit", 13, false);
		optionPenjual = new JRadioButton("Penjual");
		optionPembeli = new JRadioButton("Pembeli");
		
		submitButton.setPreferredSize(new Dimension(100, 40));
		
		buttonPanel.add(optionPenjual);
		buttonPanel.add(optionPembeli);
		buttonPanel.add(submitButton);
		
		
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
