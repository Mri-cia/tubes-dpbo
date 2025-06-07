package app.view;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;
import java.awt.event.*;
import java.util.EventListener;

import app.components.CButton;
import app.components.CDropDown;
import app.components.CPasswordField;
import app.components.CTextField;
import app.exception.ErrorMessage;
import app.modules.*;
import app.utils.Colors;

public class LoginPage extends Page implements updatedPage  {
	
	static User currentUser;
	
	private String name;
	private String pass;

	private ImageIcon loginIcon;
	
	private JPanel centerPanel;
	private JPanel errorPanel;
	
	JLabel nameLabel;
	JLabel passLabel;
	
	CTextField nameField;
	CPasswordField passField;
	
	CDropDown<String> roleSelect;
	
	CButton submitButton;
	
	ActionListener pagePenj;
	ActionListener pagePem;
	
	public LoginPage() {
		
		//--MainPanel setup--//
		setLayout(new BorderLayout());
		JPanel headPanel = new JPanel();
		JPanel footPanel = new JPanel();
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		
		centerPanel = new JPanel();
		
		//testing boundaries
//		centerPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		
		//Uniform sizing
		int outerWidth = (int)(WIDTH_LIMIT * 0.15);
		int outerHeight = (int)(HEIGHT_LIMIT * 0.1);
		headPanel.setPreferredSize(new Dimension((int)WIDTH_LIMIT, outerHeight));
		footPanel.setPreferredSize(new Dimension((int)WIDTH_LIMIT, outerHeight));
		leftPanel.setPreferredSize(new Dimension(outerWidth, (int)HEIGHT_LIMIT));
		rightPanel.setPreferredSize(new Dimension(outerWidth, (int)HEIGHT_LIMIT));
		
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
//		buttonPanel.setBackground(Color.pink);
		
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
		nameField = new CTextField("Ursula", Colors.ZINC.getShade(2));
		
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
		passField = new CPasswordField("Y813K", Colors.ZINC.getShade(2));
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
		submitButton = new CButton("Submit", 13, false);
		
		//Dropdown
		String[] roles = {"Penjual", "Pembeli", "Donatur", "Penerima"};
		roleSelect = new CDropDown<>(roles); 
		roleSelect.setPreferredSize(new Dimension(90, 27));
		
		
		submitButton.setPreferredSize(new Dimension(100, 40));
		

		buttonPanel.add(roleSelect);
		buttonPanel.add(submitButton);
		

		
		validation();

		
	}
	
	private void validation() {
		DocumentListener inputListener = new DocumentListener() {
		    public void insertUpdate(DocumentEvent e) {
		        checkFields();
		    }

		    public void removeUpdate(DocumentEvent e) {
		        checkFields();
		    }

		    public void changedUpdate(DocumentEvent e) {
		        checkFields();
		    }
		};

		nameField.getDocument().addDocumentListener(inputListener);
		passField.getDocument().addDocumentListener(inputListener);
		roleSelect.addActionListener(e -> checkFields());
		


		verification();
	}
	
	private void verification() {
		
		submitButton.addActionListener(e -> {
			getForm();
			String selectedRole = (String)roleSelect.getSelectedItem();
			DataUser.setUserRole(name, pass, selectedRole);
			
			
			if (DataUser.verifyUser()) {
				if (errorPanel != null) {
				    centerPanel.remove(errorPanel);
				}
				pageDirection(selectedRole, e);
			} else {
				if (errorPanel != null) {
				    centerPanel.remove(errorPanel);
				}
				errorPanel = new JPanel();
				errorPanel.setMaximumSize(new Dimension((int)(centerPanel.getWidth() * 0.5), 50));
				errorPanel.setBackground(Colors.RED.getShade(3));
				centerPanel.add(errorPanel);
				
				errorPanel.setLayout(new GridBagLayout());
				JLabel message = new JLabel(DataUser.Error);
				message.setForeground(Colors.RED.getShade(9));
				errorPanel.add(message);
				
				centerPanel.revalidate();
				centerPanel.repaint();
			}
//			for (int i = 0; i < DataUser.getUsers().size(); i++) {
//				System.out.println(DataUser.getDataUser(i).getUsername() + ": " + DataUser.getDataUser(i).getRole());
//			}
//			System.out.println("=============="); //incase need to check users
		});
	}
	
	private void checkFields() {
		String name = nameField.getText().trim();
		String pass = new String(passField.getPassword());
		boolean allValid = !name.isEmpty() && !pass.isEmpty() && roleSelect.getSelectedItem() != null;
		
		submitButton.setEnabled(allValid);
	}
	

	
	private void pageDirection(String selectedRole, ActionEvent e) {
		getForm();
		currentUser = DataUser.getActiveUser();
		switch(selectedRole) {
		case "Penjual":
//			currentUser = new Seller(name, pass);
			pagePenj.actionPerformed(e);
			break;
		case "Donatur":
//			currentUser = new Donator(name, pass);
			pagePenj.actionPerformed(e);
			break;
			
		case "Pembeli":
//			currentUser = new Buyer(name, pass);
	        pagePem.actionPerformed(e);
	        break;
		case "Penerima":
//			currentUser = new Recipient(name, pass);
	        pagePem.actionPerformed(e);
	        break;
	    
	    default:
	    	break;
		}
		
//		DataUser.setDataUser(currentUser);;
		DataBarang.addUserBarangList(currentUser);
		
//		for (User u : DataUser.getUsers()) {
//			System.out.println(u.getUsername());
//		}
		
//		for (User u : DataBarang.data.keySet()) {
//			System.out.println(u.getUsername());
//		}
		
//		for (Barang b : DataBarang.data.get(currentUser)) {
//			System.out.print(b.getName() + "  ");
//		}
		
		nameField.setText(null);
		passField.setText(null);
		
		submitButton.setEnabled(false);
	}
	
	private void getForm() {
		name = nameField.getText().trim();
		pass = new String(passField.getPassword());
	}
	
	static User getCurrentUser() {
		return currentUser;
	}

	@Override
	public void setUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAction(ActionListener... args) {
	    this.pagePenj = args[0];
	    this.pagePem = args[1];
		
	}
	

}
