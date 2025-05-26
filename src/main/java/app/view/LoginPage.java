package app.view;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

import app.components.CusButton;
import app.modules.*;

public class LoginPage extends Page  {
	
	static User currentUser;
	
	ImageIcon loginIcon;
	
	JLabel nameLabel;
	JLabel passLabel;
	
	JTextField nameField;
	JPasswordField passField;
	
	String name;;
	String pass;
	
	JComboBox<String> roleSelect;

	
	public LoginPage(ActionListener userPenjual, ActionListener userPembeli) {
		
		
		
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
		int outerWidth = (int)(widthLimit * 0.15);
		int outerHeight = (int)(heightLimit * 0.1);
		headPanel.setPreferredSize(new Dimension((int)widthLimit, outerHeight));
		footPanel.setPreferredSize(new Dimension((int)widthLimit, outerHeight));
		leftPanel.setPreferredSize(new Dimension(outerWidth, (int)heightLimit));
		rightPanel.setPreferredSize(new Dimension(outerWidth, (int)heightLimit));
		
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
		nameField = new JTextField();
		
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
		passField = new JPasswordField();
		passField.setEchoChar('*');
		
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
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 10));
		CusButton submitButton = new CusButton("Submit", 13, false);
//		optionPenjual = new JRadioButton("Penjual");
//		optionPembeli = new JRadioButton("Pembeli");
		//Dropdown
		String[] roles = {"Penjual", "Pembeli", "Donatur", "Penerima"};
		roleSelect = new JComboBox<>(roles); 
		
		roleSelect.setBackground(getBackground());
		roleSelect.setForeground(new Color(0x404040));
		roleSelect.setBorder(BorderFactory.createEmptyBorder());
		
		
		submitButton.setPreferredSize(new Dimension(100, 40));
		
		
//		buttonPanel.add(optionPenjual);
//		buttonPanel.add(optionPembeli);
		buttonPanel.add(roleSelect);
		buttonPanel.add(submitButton);
		
		
		//ALGORITHM
		//Grouping radio button
//		buttonGroup = new ButtonGroup();
//		buttonGroup.add(optionPenjual);
//		buttonGroup.add(optionPembeli);
//
//		//Enabling submit button
//		ItemListener enableSubmit = e -> {
//		    if ((optionPenjual.isSelected() || optionPembeli.isSelected()) && validateForm()) {
//		        submitButton.setEnabled(true);
//		    }
//		};
//		optionPenjual.addItemListener(enableSubmit);
//		optionPembeli.addItemListener(enableSubmit);
		
		//DropdownSelection
		
		roleSelect.addActionListener(e -> {
		    if (roleSelect.getSelectedItem() != null && validateForm()) {
		    	submitButton.setEnabled(true);
		    }
		});
		

		//Enabling submit button
//		ItemListener enableSubmit = e -> {
//		    if ((optionPenjual.isSelected() || optionPembeli.isSelected()) && validateForm()) {
//		        submitButton.setEnabled(true);
//		    }
//		};
		
//		//OnClicked submit button
//		submitButton.addActionListener(e -> {
//		    if (optionPenjual.isSelected()) {
//		        userPenjual.actionPerformed(e);
//		    } else if (optionPembeli.isSelected()) {
//		        userPembeli.actionPerformed(e);
//		    }
//		});
		
		//OnClicked submit button
		submitButton.addActionListener(e -> {
			String selectedRole = (String)roleSelect.getSelectedItem();
			getForm();
			switch(selectedRole) {
			case "Penjual":
				currentUser = new Seller(name, pass);
				userPenjual.actionPerformed(e);
				break;
			case "Donatur":
				currentUser = new Donator(name, pass);
				userPenjual.actionPerformed(e);
				break;
				
			case "Pembeli":
				currentUser = new Buyer(name, pass);
		        userPembeli.actionPerformed(e);
		        break;
			case "Penerima":
				currentUser = new Recipient(name, pass);
		        userPembeli.actionPerformed(e);
		        break;
		    
		    default:
		    	break;
			}
			
			nameField.setText(null);
			passField.setText(null);
			
			submitButton.setEnabled(false);
		});
		
	}
	
	//Validating if the text field is filled and not the same as placeholder
	private boolean validateForm() {
		getForm();
	    boolean isNameValid = !name.equals("");
	    boolean isPassValid = !pass.equals("");
	    
	    return isNameValid && isPassValid;
	}
	
	private void getForm() {
		name = nameField.getText().trim();
		pass = new String(passField.getPassword());
	}
	
	static User getCurrentUser() {
		return currentUser;
	}
}
