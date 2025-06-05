package app.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

import app.modules.*;
import app.utils.DateUtils;
import app.components.*;

public class AddGoodsPage extends Page {
  private String role;
	
  JLabel nameLabel = new JLabel();
  JLabel roleLabel = new JLabel();
  
  CTextField nameField;
  CTextField typeField;
  CTextField priceField;
  CTextField expireField;

  CButton submitButton;

  public AddGoodsPage(ActionListener a) {
    // --MainPanel setup--//
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    JPanel profilePanel = new JPanel();
    JPanel lineProfile = new JPanel();
    JPanel nameProfile = new JPanel();
    JPanel backPanel = new JPanel();
    
    JPanel formPanel = new JPanel();

    // Sizing
    profilePanel.setPreferredSize(new Dimension(0, 100));

    add(Box.createRigidArea(new Dimension(0, 20)));
    add(profilePanel);
    add(Box.createRigidArea(new Dimension(0, 20)));
    add(backPanel);
    add(Box.createRigidArea(new Dimension(0, 20)));
    add(formPanel);
    
    
    //testing style
    //backPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3, Color.black));

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
    CButton backBtn = new CButton("back", 12);

    backBtn.addActionListener(e -> {
      a.actionPerformed(e);
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
    
    namePanel.setMaximumSize(new Dimension((int)(widthLimit/1.5), 40));
    typePanel.setMaximumSize(new Dimension((int)(widthLimit/1.5), 40));
    pricePanel.setMaximumSize(new Dimension((int)(widthLimit/1.5), 40));
    datePanel.setMaximumSize(new Dimension((int)(widthLimit/1.5), 40));
    buttonPanel.setMaximumSize(new Dimension((int)(widthLimit/1.5), 40));

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
    JLabel nameLabel = new JLabel("Nama Barang : ");
    nameField = new CTextField("Kopi/Burger", colors[2]);

    nameLabel.setPreferredSize(new Dimension(100, 15));
    nameField.setPreferredSize(new Dimension(350, 25));

    nameGBC.gridx = 1;
    nameGBC.anchor = GridBagConstraints.WEST;
    namePanel.add(nameLabel, nameGBC);
    nameGBC.gridx = 2;
    nameGBC.anchor = GridBagConstraints.EAST;
    nameGBC.weightx = 1.0;
    namePanel.add(nameField, nameGBC);
    
    // --Type Panel--//
    typePanel.setLayout(new GridBagLayout());
    GridBagConstraints typeGBC = new GridBagConstraints();
    JLabel typeLabel = new JLabel("Tipe Barang : ");
    CTextField typeField = new CTextField("Tipe Barang", colors[2]);

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
    JLabel priceLabel = new JLabel("Harga Barang : ");
    CTextField priceField = new CTextField("10000", colors[2]);

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
    JLabel dateLabel = new JLabel("Tanggal Kadaluarsa : ");
    CTextField dateField = new CTextField("01-01-2001", colors[2]);

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
    
    submitButton.addActionListener(e-> {
      String name = nameField.getText().trim();
      String type = typeField.getText().trim();
      int price = Integer.parseInt(priceField.getText().trim());
      LocalDate date = DateUtils.parseDateStr(dateField.getText().trim());
      Barang barang = new Barang(name, type, date, price);
    });
    
    buttonPanel.add(submitButton);
  }
  
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	protected void updateUserInfo() {
	    if (user != null) {
	        // Update UI 
	    	nameLabel.setText(user.getUsername().toUpperCase());
	    	roleLabel.setText(user.getRole().toUpperCase());
	        // you can dynamically update label text if needed
	    }
	}
	
	private void addBarang() {
		
	}

}
