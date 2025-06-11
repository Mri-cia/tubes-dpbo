package app.view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;

import app.modules.*;
import app.utils.CurrencyFormat;
import app.utils.DateUtils;
import app.components.*;
import app.exception.AppException;
import app.exception.ErrorMessage;

public class SellerPage extends Page implements updatedPage {
	private JFrame mainFrame;

	private JPanel tablePanel = new JPanel();
	private JPanel modelPanel = new JPanel();
	private GoodsTable sellerTable;

	private JLabel nameLabel = new JLabel("URSULA");
	private JLabel roleLabel = new JLabel("Penjual");
	
	private JPanel numberPanel;

	private CButton logoutBtn;
	private CButton catalogBtn;
	private CButton addBtn;
	private CButton editBtn;
	private CButton deleteBtn;
	ActionListener logout;
	ActionListener tambahBarang;
	ActionListener catalog;

	public SellerPage(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		
		// --MainPanel setup--//
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel profilePanel = new JPanel();
		JPanel statPanel = new JPanel();
		JPanel buttonPanel = new JPanel();

		// testing boundaries
		// profilePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,
		// Color.black));
		// tablePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,
		// Color.black));
		// buttonPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,
		// Color.black));

		statPanel.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.black));

		// Sizing
		profilePanel.setPreferredSize(new Dimension(0, 100));
		statPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));

		tablePanel.setPreferredSize(new Dimension(WIDTH_LIMIT, 200));

		add(Box.createRigidArea(new Dimension(0, 20)));
		add(profilePanel);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(statPanel);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(tablePanel);
		add(Box.createRigidArea(new Dimension(0, 5)));
		add(buttonPanel);

		// --Profile Panel--//
		profilePanel.setLayout(new BoxLayout(profilePanel, BoxLayout.X_AXIS));
		JPanel lineProfile = new JPanel();
		JPanel nameProfile = new JPanel();
		JPanel logoutPanel = new JPanel();

		// testing boundaries
		// logoutPanel.setBackground(Color.red);

		lineProfile.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3, Color.black));

		lineProfile.setMaximumSize(new Dimension(100, 80));
		nameProfile.setMaximumSize(new Dimension(1000, 80));
		logoutPanel.setMaximumSize(new Dimension(200, 80));

		profilePanel.add(lineProfile);
		profilePanel.add(Box.createRigidArea(new Dimension(10, 0)));
		profilePanel.add(nameProfile);
		profilePanel.add(Box.createRigidArea(new Dimension(10, 0)));
		profilePanel.add(logoutPanel);
		profilePanel.add(Box.createRigidArea(new Dimension(50, 0)));

		// --nameProfile Panel--//
		nameProfile.setLayout(new BoxLayout(nameProfile, BoxLayout.Y_AXIS));
		nameLabel = new JLabel();
		roleLabel = new JLabel();

		nameLabel.setFont(new Font("ARIAL", Font.BOLD, 40));
		roleLabel.setFont(new Font("ARIAL", Font.BOLD, 20));

		nameProfile.add(nameLabel);
		nameProfile.add(Box.createRigidArea(new Dimension(0, 7)));
		nameProfile.add(roleLabel);

		// --logoutPanel--//
		logoutPanel.setLayout(new BoxLayout(logoutPanel, BoxLayout.Y_AXIS));

		URL logoutIconURL = getClass().getResource("/app/view/assets/logout_icon.png");
		logoutBtn = new CButton(new ImageIcon(logoutIconURL));

		logoutBtn.setMaximumSize(new Dimension(38, 50));

		logoutBtn.setAlignmentX(JButton.RIGHT_ALIGNMENT);


		logoutPanel.add(logoutBtn);

		// --Statistic Panel--//
		statPanel.setLayout(new BoxLayout(statPanel, BoxLayout.Y_AXIS));
		JLabel statLabel = new JLabel("Statistics");
		numberPanel = new JPanel();

		statLabel.setFont(new Font("ARIAL", Font.BOLD, 15));

		statLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		numberPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

		statPanel.add(Box.createRigidArea(new Dimension(0, 7)));
		statPanel.add(statLabel);
		statPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		statPanel.add(numberPanel);
		statPanel.add(Box.createRigidArea(new Dimension(0, 25)));


		// --Button Panel--//
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		JPanel outerLeft = new JPanel();
		JPanel outerRight = new JPanel();
		JPanel leftBtnPanel = new JPanel();
		JPanel rightBtnPanel = new JPanel();

		// testing boundaries
		// outerLeft.setBackground(Color.red);
		// outerRight.setBackground(Color.red);
		// leftBtnPanel.setBackground(Color.DARK_GRAY);
		// rightBtnPanel.setBackground(Color.blue);

		leftBtnPanel.setPreferredSize(new Dimension(275, 0));
		rightBtnPanel.setPreferredSize(new Dimension(275, 0));

		rightBtnPanel.setAlignmentY(JPanel.CENTER_ALIGNMENT);

		buttonPanel.add(outerLeft);
		buttonPanel.add(leftBtnPanel);
		buttonPanel.add(rightBtnPanel);
		buttonPanel.add(outerRight);

		// --leftBtnPanel--//
		leftBtnPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 9, 5));
		catalogBtn = new CButton("To Catalog", 12);
		catalogBtn.setPreferredSize(new Dimension(100, 30));
		leftBtnPanel.add(catalogBtn);


		// --rightBtnPanel--//
		rightBtnPanel.setLayout(new FlowLayout(FlowLayout.TRAILING, 10, 5));
		addBtn = new CButton("add", 12);
		editBtn = new CButton("edit", 12);

		URL deleteIconURL = getClass().getResource("/app/view/assets/delete_icon.png");
		deleteBtn = new CButton(new ImageIcon(deleteIconURL));

		addBtn.setPreferredSize(new Dimension(100, 30));
		editBtn.setPreferredSize(new Dimension(100, 30));
		deleteBtn.setPreferredSize(new Dimension(50, 30));



		rightBtnPanel.add(addBtn);
		rightBtnPanel.add(editBtn);
		rightBtnPanel.add(deleteBtn);
		

	}
	
	private void countingStatistic() {
		// --numberPanel--//
		if (numberPanel != null) {
			numberPanel.removeAll();
		}
		numberPanel.setLayout(new BoxLayout(numberPanel, BoxLayout.X_AXIS));
		
		int totalItem = 0;
		int expiring = 0;
		
		if(DataBarang.data.get(user) != null) {
			totalItem = DataBarang.data.get(user).size();
			for (Barang b : DataBarang.data.get(user)) {
				try {
					if(b.isKadaluarsa()) {
						expiring++;
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}
		
		
		
		if (user instanceof Seller) {
			
			int value = 0;
			if (DataBarang.data.get(user) != null) {
				for (Barang b : DataBarang.data.get(user)) {
					value = value + b.getPriceInt();
				}
			}
			
			JLabel goodsListed = new JLabel("Barang Terdaftar: " + totalItem);
			JLabel goodsValue = new JLabel("Nilai Barang: " + CurrencyFormat.formatInt(value));
			JLabel goodsExpiring = new JLabel("Barang Kadaluarsa: " + expiring);
			
			goodsListed.setFont(new Font("ARIAL", Font.BOLD, 13));
			goodsValue.setFont(new Font("ARIAL", Font.BOLD, 13));
			goodsExpiring.setFont(new Font("ARIAL", Font.BOLD, 13));
			
			goodsValue.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			numberPanel.add(goodsListed);
			numberPanel.add(Box.createRigidArea(new Dimension(108, 0)));
			numberPanel.add(goodsValue);
			numberPanel.add(Box.createRigidArea(new Dimension(90, 0)));
			numberPanel.add(goodsExpiring);
			
		} 
		else if (user instanceof Donator) {
			
			JLabel goodsListed = new JLabel("Barang Terdaftar: " + totalItem);
			JLabel goodsExpiring = new JLabel("Barang Kadaluarsa: " + expiring);
			
			goodsListed.setFont(new Font("ARIAL", Font.BOLD, 13));
			goodsExpiring.setFont(new Font("ARIAL", Font.BOLD, 13));
			
			
			numberPanel.add(goodsListed);
			numberPanel.add(Box.createRigidArea(new Dimension(118, 0)));
			numberPanel.add(goodsExpiring);
		}

	}

	// Mengambil data dari class DataBarang dan tambahkan ke tabel
	private void refreshTable(JPanel tablePanel) {
	    tablePanel.removeAll(); // Clear old content from the tablePanel

	    modelPanel = new JPanel(); // Create a new instance to ensure old content is gone
	    modelPanel.setPreferredSize(new Dimension((int) (WIDTH_LIMIT * 0.9), 230));

	    String[] columns = new String[0];
	    if (user instanceof Seller) {
	    	columns = new String[]{"Nama", "Tipe", "Kadaluarsa", "Price (IDR)"};	
	    } else if(user instanceof Donator) {
	    	columns = new String[]{ "Nama", "Tipe", "Kadaluarsa"};		
	    }
	    
	    
	    ArrayList<Barang> data = DataBarang.barangUser;

	    Dimension tableSize = new Dimension((int) (WIDTH_LIMIT * 0.9), 400);
	    
	    if(user instanceof Donator) {
	    	sellerTable = new GoodsTable(
	    			modelPanel, 
	    			new Dimension(WIDTH_LIMIT, HEIGHT_LIMIT), 
	    			columns, 
	    			data, 
	    			"catalog",
	    			true
	    			);
	    } else {
	    	sellerTable = new GoodsTable(
	    			modelPanel, 
	    			new Dimension(WIDTH_LIMIT, HEIGHT_LIMIT), 
	    			columns, 
	    			data, 
	    			"catalog",
	    			false
	    			);
	    }
	    
	    tablePanel.add(modelPanel);

	    tablePanel.revalidate();  // Ensure layout update
	    tablePanel.repaint();     // Repaint for visual refresh

	    editBtnAction();
	    deleteBtnAction();
	}

	private void editBtnAction() {
		for (ActionListener al : editBtn.getActionListeners()) {
			editBtn.removeActionListener(al);
		}
		editBtn.addActionListener(e -> {
			if (sellerTable.isEditing()) {
				sellerTable.saveEditedCell();
			}
			int editedRow = sellerTable.getSelectedRow();
			int editedColumn = sellerTable.getSelectedColumn();
			
			
			try {
				if(editedRow < 0) {
					throw new AppException(ErrorMessage.UNSELECTED_CELL);
				} else if (editedColumn >= 3) {
					throw new AppException(ErrorMessage.UNPERMITTED_EDIT);
				} else {
					String editedValue = sellerTable.getSelectedCellValue();
					DataBarang.editBarang(editedRow, editedColumn, editedValue);
				}
			} catch (Exception e2) {
				CErrorDialog preventPop = new CErrorDialog(mainFrame, e2.getMessage(), 1);
				preventPop.setBtn1("Ok");
				preventPop.setVisible(true);
				refreshTable(tablePanel);
			}
			
			sellerTable.revalidate();
			sellerTable.repaint();
				
		});
	}
	
	private void deleteBtnAction() {
		for (ActionListener al : deleteBtn.getActionListeners()) {
			deleteBtn.removeActionListener(al);
		}
		deleteBtn.addActionListener(e -> {
			int selectedRow = sellerTable.getSelectedRow();
	        if (selectedRow >= 0) {
	            DataBarang.data.get(user).remove(selectedRow);
	            DataBarang.getUser(user); // Update barangUser
	            refreshTable(tablePanel); // Refresh table view
	        } else {
				CErrorDialog preventPop = new CErrorDialog(mainFrame, ErrorMessage.UNSELECTED_CELL.getMessage(), 1);
				preventPop.setBtn1("Ok");
				preventPop.setVisible(true);
				refreshTable(tablePanel);
	        }
		});
	}
	
	private void logoutBtnAction() {
		
		for (ActionListener al : logoutBtn.getActionListeners()) {
			logoutBtn.removeActionListener(al);
		}
		logoutBtn.addActionListener(logout);
	}
	
	private void catalogAction() {
		for (ActionListener al : catalogBtn.getActionListeners()) {
			logoutBtn.removeActionListener(al);
		}
		catalogBtn.addActionListener(catalog);
	}


	@Override
	public void setUser(User user) {
		this.user = user;
		DataBarang.getUser(user);
		updateUserInfo();
//	    // Ensures refresh happens after layout switch
//	    SwingUtilities.invokeLater(() -> refreshTable(tablePanel));
		refreshTable(tablePanel);
		countingStatistic();
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
	public void setAction(ActionListener... args) {
		this.logout = args[0];
		this.tambahBarang = args[1];
		this.catalog = args[2];

		logoutBtnAction();
		catalogAction();

		addBtn.addActionListener(tambahBarang);
	}

}
