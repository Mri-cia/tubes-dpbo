package app.view;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.time.LocalDate;

import app.modules.*;
import app.utils.Colors;
import app.utils.DateUtils;
import app.components.*;

public class AddGoodsPage extends Page implements updatedPage {
	private String role;

	JLabel nameLabel = new JLabel();
	JLabel roleLabel = new JLabel();

	JLabel nameGLabel;
	JLabel typeLabel;
	JLabel priceLabel;
	JLabel dateLabel;

	CTextField nameField;
	CTextField typeField;
	CTextField priceField;
	CTextField dateField;

	String name, type;
	int price;
	LocalDate expire;

	CButton submitButton;
	JPanel formPanel = new JPanel();
	private JPanel errorPanel;
	
	ActionListener back;

	public AddGoodsPage() {
		// --MainPanel setup--//
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel profilePanel = new JPanel();
		JPanel lineProfile = new JPanel();
		JPanel nameProfile = new JPanel();
		JPanel backPanel = new JPanel();

		// Sizing
		profilePanel.setPreferredSize(new Dimension(0, 100));

		add(Box.createRigidArea(new Dimension(0, 20)));
		add(profilePanel);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(backPanel);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(formPanel);

		// testing style
		// backPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3,
		// Color.black));

		// --Profile Panel--//
		profilePanel.setLayout(new BoxLayout(profilePanel, BoxLayout.X_AXIS));

		lineProfile.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3, Color.black));

		lineProfile.setMaximumSize(new Dimension(100, 80));
		nameProfile.setMaximumSize(new Dimension(1000, 80));
		backPanel.setMaximumSize(new Dimension(200, 80));

		profilePanel.add(lineProfile);
		profilePanel.add(Box.createRigidArea(new Dimension(10, 0)));
		profilePanel.add(nameProfile);
		profilePanel.add(Box.createRigidArea(new Dimension(10, 0)));
		profilePanel.add(backPanel);
		profilePanel.add(Box.createRigidArea(new Dimension(50, 0)));

		// --nameProfile Panel--//
		nameProfile.setLayout(new BoxLayout(nameProfile, BoxLayout.Y_AXIS));
		nameLabel = new JLabel("URSULA");
		roleLabel = new JLabel("Penjual");

		nameLabel.setFont(new Font("ARIAL", Font.BOLD, 40));
		roleLabel.setFont(new Font("ARIAL", Font.BOLD, 20));

		nameProfile.add(nameLabel);
		nameProfile.add(Box.createRigidArea(new Dimension(0, 7)));
		nameProfile.add(roleLabel);

		// --backPanel--//
		backPanel.setLayout(new BoxLayout(backPanel, BoxLayout.Y_AXIS));
		URL homeIconURL = getClass().getResource("/app/view/assets/home_icon.png");
		CButton backBtn = new CButton(new ImageIcon(homeIconURL));

		backBtn.setMaximumSize(new Dimension(40,50));
		
		backBtn.addActionListener(e -> {
			back.actionPerformed(e);
		});

		backPanel.add(backBtn);

		// --Form Panel setup--//
		formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
		JPanel namePanel = new JPanel();
		JPanel typePanel = new JPanel();
		JPanel pricePanel = new JPanel();
		JPanel datePanel = new JPanel();
		JPanel buttonPanel = new JPanel();

		// Sizing

		namePanel.setMaximumSize(new Dimension((int) (WIDTH_LIMIT / 1.5), 40));
		typePanel.setMaximumSize(new Dimension((int) (WIDTH_LIMIT / 1.5), 40));
		pricePanel.setMaximumSize(new Dimension((int) (WIDTH_LIMIT / 1.5), 40));
		datePanel.setMaximumSize(new Dimension((int) (WIDTH_LIMIT / 1.5), 40));
		buttonPanel.setMaximumSize(new Dimension((int) (WIDTH_LIMIT / 1.5), 40));

		formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		formPanel.add(namePanel);
		formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		formPanel.add(typePanel);
		formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		formPanel.add(pricePanel);
		formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		formPanel.add(datePanel);
		formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		formPanel.add(buttonPanel);
		formPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		// --Goods name Panel--//
		namePanel.setLayout(new GridBagLayout());
		GridBagConstraints nameGBC = new GridBagConstraints();
		nameGLabel = new JLabel("Nama Barang : ");
		nameField = new CTextField("Kopi/Burger", Colors.ZINC.getShade(2));

		nameLabel.setPreferredSize(new Dimension(100, 15));
		nameField.setPreferredSize(new Dimension(350, 25));

		nameGBC.gridx = 1;
		nameGBC.anchor = GridBagConstraints.WEST;
		namePanel.add(nameGLabel, nameGBC);
		nameGBC.gridx = 2;
		nameGBC.anchor = GridBagConstraints.EAST;
		nameGBC.weightx = 1.0;
		namePanel.add(nameField, nameGBC);

		// --Type Panel--//
		typePanel.setLayout(new GridBagLayout());
		GridBagConstraints typeGBC = new GridBagConstraints();
		typeLabel = new JLabel("Tipe Barang : ");
		typeField = new CTextField("Tipe Barang", Colors.ZINC.getShade(2));

		typeLabel.setPreferredSize(new Dimension(100, 15));
		typeField.setPreferredSize(new Dimension(350, 25));

		typeGBC.gridx = 1;
		typeGBC.anchor = GridBagConstraints.WEST;
		typePanel.add(typeLabel, typeGBC);
		typeGBC.gridx = 2;
		typeGBC.anchor = GridBagConstraints.EAST;
		typeGBC.weightx = 1.0;
		typePanel.add(typeField, typeGBC);

		// --Price Panel--//
		pricePanel.setLayout(new GridBagLayout());
		GridBagConstraints priceGBC = new GridBagConstraints();
		priceLabel = new JLabel("Harga Barang : ");
		priceField = new CTextField("10000", Colors.ZINC.getShade(2));

		priceLabel.setPreferredSize(new Dimension(100, 15));
		priceField.setPreferredSize(new Dimension(350, 25));

		priceGBC.gridx = 1;
		priceGBC.anchor = GridBagConstraints.WEST;
		pricePanel.add(priceLabel, priceGBC);
		priceGBC.gridx = 2;
		priceGBC.anchor = GridBagConstraints.EAST;
		priceGBC.weightx = 1.0;
		pricePanel.add(priceField, priceGBC);

		// --Date Panel--//
		datePanel.setLayout(new GridBagLayout());
		GridBagConstraints dateGBC = new GridBagConstraints();
		dateLabel = new JLabel("Tanggal Kadaluarsa : ");
		dateField = new CTextField("2026-10-23", Colors.ZINC.getShade(2));

		dateLabel.setPreferredSize(new Dimension(150, 15));
		dateField.setPreferredSize(new Dimension(350, 25));

		dateGBC.gridx = 1;
		dateGBC.anchor = GridBagConstraints.WEST;
		datePanel.add(dateLabel, dateGBC);
		dateGBC.gridx = 2;
		dateGBC.anchor = GridBagConstraints.EAST;
		dateGBC.weightx = 1.0;
		datePanel.add(dateField, dateGBC);

		// --Button Panel--//
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 7, 0));
		submitButton = new CButton("Submit", 13, false);

		submitButton.setPreferredSize(new Dimension(100, 40));

		buttonPanel.add(submitButton);


	}

	private void getForm() {
		name = nameField.getText().trim();
		type = typeField.getText().trim();
		price = Integer.parseInt(priceField.getText().trim());
		expire = DateUtils.parseDateStr(dateField.getText().trim());
	}

	private void verification(ActionListener back) {

		submitButton.addActionListener(e -> {
			getForm();
			if (type.equalsIgnoreCase("makanan") || type.equalsIgnoreCase("minuman")) {
				if (errorPanel != null) {
					formPanel.remove(errorPanel);
				}
				// Tambah barang
			} else {
				if (errorPanel != null) {
					formPanel.remove(errorPanel);
				}
				errorPanel = new JPanel();
				errorPanel.setMaximumSize(new Dimension((int) (formPanel.getWidth() * 0.5), 50));
				errorPanel.setBackground(Colors.RED.getShade(3));
				formPanel.add(errorPanel);

				errorPanel.setLayout(new GridBagLayout());
				JLabel message = new JLabel("Tipe barang harus minuman/makanan");
				message.setForeground(Colors.RED.getShade(9));
				errorPanel.add(message);

				formPanel.revalidate();
				formPanel.repaint();
			}
			submitBarang().actionPerformed(e);
			back.actionPerformed(e);
		});
	}

	private void checkFields() {
		String name = nameField.getText().trim();
		String type = typeField.getText().trim();
		String priceString = priceField.getText().trim();
		String expireString = dateField.getText().trim();

		int price = 0;
		boolean priceValid = false;

		try {
			price = Integer.parseInt(priceString);
			priceValid = price > 1;
		} catch (NumberFormatException e) {
			priceValid = false;
		}

		LocalDate expire = null;
		boolean dateValid = false;

		if (expireString.length() == 10) {
			try {
				expire = DateUtils.parseDateStr(expireString);
				dateValid = expire != null && expire.isAfter(LocalDate.now());
			} catch (Exception e) {
				dateValid = false;
			}
		}

		boolean allValid = !name.isEmpty() && !type.isEmpty() && priceValid && dateValid;

		submitButton.setEnabled(allValid);
	}

	private void validation(ActionListener back) {
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
		typeField.getDocument().addDocumentListener(inputListener);
		priceField.getDocument().addDocumentListener(inputListener);
		dateField.getDocument().addDocumentListener(inputListener);

		verification(back);
	}

	private ActionListener submitBarang() {
		System.out.println("ini masuk");
		return e -> {
			DataBarang.addBarang(new Barang(name, type, expire, price));
			
			nameField.setText(null);;
			typeField.setText(null);
			priceField.setText(null);;
			dateField.setText(null);
			};
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public void updateUserInfo() {
		if (user != null) {
			// Update UI
			nameLabel.setText(user.getUsername().toUpperCase());
			roleLabel.setText(user.getRole().toUpperCase());
			// you can dynamically update label text if needed
		}
	}

	@Override
	public void setUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAction(ActionListener... args) {
		this.back = args[0];
		validation(back);
	}

}
