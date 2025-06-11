package app.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.ArrayList;

import app.components.CButton;
import app.components.GoodsTable;
import app.modules.Barang;
import app.modules.Buyer;
import app.modules.DataBarang;
import app.modules.DataUser;
import app.modules.Donator;
import app.modules.Recipient;
import app.modules.Seller;
import app.modules.User;
import app.utils.Colors;
import app.utils.CurrencyFormat;

public class BuyerPage extends Page implements updatedPage {
	JTable table;
	JScrollPane scroller;

	JLabel nameLabel = new JLabel();
	JLabel roleLabel = new JLabel();
	
	JPanel tablePanel = new JPanel();
	JPanel modelPanel = new JPanel();
	
	private JPanel numberPanel;
	
	private GoodsTable buyerTable;
	
	private CButton logoutBtn;
	private CButton catalogBtn;
	
	ActionListener logout;
	ActionListener catalog;
	
	public BuyerPage() {
		//--MainPanel setup--//
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel profilePanel = new JPanel();
		JPanel statPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		//testing boundaries
		//profilePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		//tablePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		//buttonPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		
		statPanel.setBorder(BorderFactory.createMatteBorder(2, 0, 1, 0, Color.black));
		
		//Sizing
		profilePanel.setPreferredSize(new Dimension(0, 100));
		statPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
		tablePanel.setPreferredSize(new Dimension((int)(WIDTH_LIMIT * 0.08), 200));
		
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(profilePanel);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(statPanel);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(tablePanel);
		add(Box.createRigidArea(new Dimension(0, 0)));
		add(buttonPanel);
		
		
		//--Profile Panel--//
		profilePanel.setLayout(new BoxLayout(profilePanel, BoxLayout.X_AXIS));
		JPanel lineProfile = new JPanel();
		JPanel nameProfile = new JPanel();
		JPanel logoutPanel = new JPanel();
		
		//testing boundaries
		//logoutPanel.setBackground(Color.red);
		
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
		
		
		//--nameProfile Panel--//
		nameProfile.setLayout(new BoxLayout(nameProfile, BoxLayout.Y_AXIS));
		nameLabel = new JLabel();
		roleLabel = new JLabel();
		
		nameLabel.setFont(new Font("ARIAL", Font.BOLD, 40));
		roleLabel.setFont(new Font("ARIAL", Font.BOLD, 20));
		
		nameProfile.add(nameLabel);
		nameProfile.add(Box.createRigidArea(new Dimension(0, 7)));
		nameProfile.add(roleLabel);
		
		
		//--logoutPanel--//
		logoutPanel.setLayout(new BoxLayout(logoutPanel, BoxLayout.Y_AXIS));

		URL logoutIconURL = getClass().getResource("/app/view/assets/logout_icon.png");
		logoutBtn = new CButton(new ImageIcon(logoutIconURL));
		
		logoutBtn.setMaximumSize(new Dimension(38, 50));
		
		logoutBtn.setAlignmentX(JButton.RIGHT_ALIGNMENT);
		
		
		logoutPanel.add(logoutBtn);
		
		
		//--Statistic Panel--//
		statPanel.setLayout(new BoxLayout(statPanel, BoxLayout.Y_AXIS));
		JLabel statLabel = new JLabel("Statistics");
		numberPanel = new JPanel();
		
		statLabel.setFont(new Font("ARIAL", Font.BOLD, 15));
		
		
		statLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		numberPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		

		statPanel.add(Box.createRigidArea(new Dimension(0, 7)));
		statPanel.add(statLabel);
		statPanel.add(Box.createRigidArea(new Dimension(0, 15)));
		statPanel.add(numberPanel);
		statPanel.add(Box.createRigidArea(new Dimension(0, 18)));
		

		//--Button Panel--//
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		JPanel outerLeft = new JPanel();
		JPanel outerRight = new JPanel();
		JPanel leftBtnPanel = new JPanel();
		JPanel rightBtnPanel = new JPanel();
		
		//testing boundaries
		//outerLeft.setBackground(Color.red);
		//outerRight.setBackground(Color.red);
		//leftBtnPanel.setBackground(Color.DARK_GRAY);
		//rightBtnPanel.setBackground(Color.blue);
		
		leftBtnPanel.setPreferredSize(new Dimension(275,0));
		rightBtnPanel.setPreferredSize(new Dimension(275,0));
		
		rightBtnPanel.setAlignmentY(JPanel.CENTER_ALIGNMENT);
		
		buttonPanel.add(outerLeft);
		buttonPanel.add(leftBtnPanel);
		buttonPanel.add(rightBtnPanel);
		buttonPanel.add(outerRight);
		
		
		//--rightBtnPanel--//
		rightBtnPanel.setLayout(new FlowLayout(FlowLayout.TRAILING, 10, 5));
		catalogBtn = new CButton("To Catalog...", 13);
		
		
		catalogBtn.setPreferredSize(new Dimension(150, 30));
		
		rightBtnPanel.add(catalogBtn);
		
		
	}
	
	private void countingStatistic() {
		//--numberPanel--//
		if (numberPanel != null) {
			numberPanel.removeAll();
		}
		numberPanel.setLayout(new BoxLayout(numberPanel, BoxLayout.X_AXIS));
		
		int totalItem = 0;
		String goodsType = "";
		int makan = 0;
		int minum = 0;
		
		if(DataBarang.data.get(user) != null) {
			totalItem = DataBarang.data.get(user).size();
			for (Barang b : DataBarang.data.get(user)) {
				if (b.getType().equalsIgnoreCase("makanan")) {
					makan++;
				} else if (b.getType().equalsIgnoreCase("minuman")) {
					minum++;
				}
			}
		}
		
		if (makan > minum) {
			goodsType = "Makanan";
		} else if (makan < minum) {
			goodsType = "Minuman";
		} else {
			goodsType = "Semua Jenis";
		}
		
		if (user instanceof Buyer) {
			JPanel numPaneLeft = new JPanel();
			JPanel numPaneRight = new JPanel();
			
			//testingboundaries//
			//numPaneLeft.setBackground(Color.red);
			//numPaneRight.setBackground(Color.blue);
			
			numPaneLeft.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
			numPaneRight.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
			
			numPaneRight.setAlignmentX(JPanel.CENTER_ALIGNMENT);
			
			numberPanel.add(numPaneLeft);
			numberPanel.add(numPaneRight);
			
			//--numPaneLeft--//
			numPaneLeft.setLayout(new BoxLayout(numPaneLeft, BoxLayout.Y_AXIS));
			JLabel goodsBought = new JLabel("Total Goods Bought: " + totalItem);
			JLabel mostType = new JLabel("Most Bought Type: " + goodsType);
			
			goodsBought.setFont(new Font("ARIAL", Font.BOLD, 13));
			mostType.setFont(new Font("ARIAL", Font.BOLD, 13));
			
			goodsBought.setPreferredSize(new Dimension(0, 15));
			mostType.setPreferredSize(new Dimension(0, 15));
			
			goodsBought.setAlignmentX(Component.CENTER_ALIGNMENT);
			mostType.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			numPaneLeft.add(goodsBought);
			numPaneLeft.add(Box.createRigidArea(new Dimension(0, 20)));
			numPaneLeft.add(mostType);
			
			
			//--numPaneRight--//
			
			int spent = 0;
			int saved = 0;
			
			if(DataBarang.data.get(user) != null) {
				for (Barang b : DataBarang.data.get(user)) {
					spent = spent + b.getDiscountedPriceInt();			
				}
				
				for (Barang b : DataBarang.data.get(user)) {
					saved = saved + (b.getPriceInt() - b.getDiscountedPriceInt());			
				}
			}
			
			numPaneRight.setLayout(new BoxLayout(numPaneRight, BoxLayout.Y_AXIS));
			JLabel moneySpent = new JLabel("Total Money Spent: " + CurrencyFormat.formatInt(spent));
			JLabel moneySaved = new JLabel("Total Money Saved: " + CurrencyFormat.formatInt(saved));
			
			moneySpent.setFont(new Font("ARIAL", Font.BOLD, 13));
			moneySaved.setFont(new Font("ARIAL", Font.BOLD, 13));
			
			moneySpent.setPreferredSize(new Dimension(0, 15));
			moneySaved.setPreferredSize(new Dimension(0, 15));
			
			moneySpent.setAlignmentX(Component.CENTER_ALIGNMENT);
			moneySaved.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			numPaneRight.add(moneySpent);
			numPaneRight.add(Box.createRigidArea(new Dimension(0, 20)));
			numPaneRight.add(moneySaved);
		} else if(user instanceof Recipient) {
			
			
			JLabel goodsBought = new JLabel("Barang Terdaftar: " + totalItem);
			JLabel mostType = new JLabel("Barang Kadaluarsa: " + goodsType);
			
			goodsBought.setFont(new Font("ARIAL", Font.BOLD, 13));
			mostType.setFont(new Font("ARIAL", Font.BOLD, 13));
			
			mostType.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			numberPanel.add(goodsBought);
			numberPanel.add(Box.createRigidArea(new Dimension(250, 0)));
			numberPanel.add(mostType);
		}
	}
	
	// Mengambil data dari class DataBarang dan tambahkan ke tabel
		private void refreshTable(JPanel tablePanel) {
			modelPanel.removeAll(); //refresh panel
			modelPanel.setPreferredSize(new Dimension((int)(WIDTH_LIMIT * 0.9), 230));
			tablePanel.add(modelPanel);
			
		    String[] columns = new String[0];
		    if (user instanceof Buyer) {
		    	columns = new String[]{"Nama", "Tipe", "Kadaluarsa", "Price (IDR)"};	
		    } else if(user instanceof Recipient) {
		    	columns = new String[]{ "Nama", "Tipe", "Kadaluarsa"};		
		    }
		    
			ArrayList<Barang> data = DataBarang.barangUser;
		    
			Dimension tableSize = new Dimension((int)(WIDTH_LIMIT * 0.9), 400);
			
		    if(user instanceof Donator) {
		    	buyerTable = new GoodsTable(
		    			modelPanel, 
		    			new Dimension(WIDTH_LIMIT, HEIGHT_LIMIT), 
		    			columns, 
		    			data, 
		    			"catalog",
		    			true
		    			);
		    } else {
		    	buyerTable = new GoodsTable(
		    			modelPanel, 
		    			new Dimension(WIDTH_LIMIT, HEIGHT_LIMIT), 
		    			columns, 
		    			data, 
		    			"catalog",
		    			false
		    			);
		    }
			
		    buyerTable.setEditEnabled(false);
		    revalidate();
		    repaint();
	    }
		
		@Override
		public void setUser(User user){
		    this.user = user;
		    DataBarang.getUser(user); // <-- Tambahkan ini
		    updateUserInfo();
		    countingStatistic();
		    refreshTable(tablePanel); // <-- Pastikan dipanggil di sini atau setelah ini
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
			this.catalog = args[1];

			logoutBtn.addActionListener(logout);
			catalogBtn.addActionListener(catalog);
		}
			
}
