package app.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import app.model.*;
import app.components.*;

public class WindowTambahBarang extends JPanel {

  JLabel nameLabel;
  JLabel passLabel;

  JTextField nameField;
  JTextField passField;

  CusButton submitButton;

  public WindowTambahBarang(ActionListener a) {
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
    JLabel nameLabel = new JLabel("URSULA");
    JLabel roleLabel = new JLabel("Penjual");

    nameLabel.setFont(new Font("ARIAL", Font.BOLD, 40));
    roleLabel.setFont(new Font("ARIAL", Font.BOLD, 20));

    nameProfile.add(nameLabel);
    nameProfile.add(Box.createRigidArea(new Dimension(0, 7)));
    nameProfile.add(roleLabel);

    // --backPanel--//
    backPanel.setLayout(new BoxLayout(backPanel, BoxLayout.Y_AXIS));
    CusButton backBtn = new CusButton("back", 12);

    backBtn.addActionListener(e -> {
      a.actionPerformed(e);
    });

    backPanel.add(backBtn);

    // --Form Panel setup--//
    formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
    JPanel namePanel = new JPanel();
    JPanel passPanel = new JPanel();
    JPanel buttonPanel = new JPanel();

    // Sizing
    namePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
    passPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
    buttonPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));

    formPanel.add(Box.createRigidArea(new Dimension(0, 20)));
    formPanel.add(namePanel);
    formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
    formPanel.add(passPanel);
    formPanel.add(Box.createRigidArea(new Dimension(0, 10)));
    formPanel.add(buttonPanel);
    formPanel.add(Box.createRigidArea(new Dimension(0, 10)));

    // --Username Panel--//
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

    // --Password Panel--//
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

    // --Button Panel--//
    buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 7, 0));
    submitButton = new CusButton("Submit", 13, false);

    submitButton.setPreferredSize(new Dimension(100, 40));

    buttonPanel.add(submitButton);
  }

}
