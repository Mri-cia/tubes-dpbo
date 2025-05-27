package app.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import app.components.CusButton;
import app.modules.Barang;
import app.modules.DataBarang;
import app.modules.User;

public class BuyerPage extends ProfilePages {
	private String role;
	private int itemsBought = 0;
	private int moneySpent = 0;
	private int moneySaved = 0;
	private String mostType = "";
	JTable table;
	JScrollPane scroller;

	JLabel nameLabel = new JLabel();
	JLabel roleLabel = new JLabel();
	
	public BuyerPage(ActionListener logout, ActionListener catalog) {
		//--MainPanel setup--//
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel profilePanel = new JPanel();
		JPanel statPanel = new JPanel();
		JPanel tablePanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		//testing boundaries
		//profilePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		//tablePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		//buttonPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		
		statPanel.setBorder(BorderFactory.createMatteBorder(2, 0, 1, 0, Color.black));
		
		//Sizing
		profilePanel.setPreferredSize(new Dimension(0, 100));
		statPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
		tablePanel.setPreferredSize(new Dimension((int)(widthLimit * 0.08), 200));
		
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
		CusButton logoutBtn = new CusButton("back");
		
		logoutBtn.setHoverEnabled(false);
		
		logoutBtn.setMaximumSize(new Dimension(38, 50));
		
		logoutBtn.setAlignmentX(JButton.RIGHT_ALIGNMENT);
		
		logoutBtn.addActionListener(logout);
		
		logoutPanel.add(logoutBtn);
		
		
		//--Statistic Panel--//
		statPanel.setLayout(new BoxLayout(statPanel, BoxLayout.Y_AXIS));
		JLabel statLabel = new JLabel("Statistics");
		JPanel numberPanel = new JPanel();
		
		statLabel.setFont(new Font("ARIAL", Font.BOLD, 15));
		
		
		statLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		numberPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		

		statPanel.add(Box.createRigidArea(new Dimension(0, 7)));
		statPanel.add(statLabel);
		statPanel.add(Box.createRigidArea(new Dimension(0, 15)));
		statPanel.add(numberPanel);
		statPanel.add(Box.createRigidArea(new Dimension(0, 18)));
		
		//--numberPanel--//
		numberPanel.setLayout(new BoxLayout(numberPanel, BoxLayout.X_AXIS));
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
		JLabel goodsBought = new JLabel("Total Goods Bought: " + itemsBought);
		JLabel goodsType = new JLabel("Most Bought Type: " + mostType);

		goodsBought.setFont(new Font("ARIAL", Font.BOLD, 13));
		goodsType.setFont(new Font("ARIAL", Font.BOLD, 13));
		
		goodsBought.setPreferredSize(new Dimension(0, 15));
		goodsType.setPreferredSize(new Dimension(0, 15));

		goodsBought.setAlignmentX(Component.CENTER_ALIGNMENT);
		goodsType.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		numPaneLeft.add(goodsBought);
		numPaneLeft.add(Box.createRigidArea(new Dimension(0, 20)));
		numPaneLeft.add(goodsType);
		
		
		//--numPaneRight--//
		numPaneRight.setLayout(new BoxLayout(numPaneRight, BoxLayout.Y_AXIS));
		JLabel moneySpent = new JLabel("Total Money Spent: " + this.moneySpent);
		JLabel moneySaved = new JLabel("Total Money Saved: " + this.moneySaved);
		
		moneySpent.setFont(new Font("ARIAL", Font.BOLD, 13));
		moneySaved.setFont(new Font("ARIAL", Font.BOLD, 13));
		
		moneySpent.setPreferredSize(new Dimension(0, 15));
		moneySaved.setPreferredSize(new Dimension(0, 15));
		
		moneySpent.setAlignmentX(Component.CENTER_ALIGNMENT);
		moneySaved.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		numPaneRight.add(moneySpent);
		numPaneRight.add(Box.createRigidArea(new Dimension(0, 20)));
		numPaneRight.add(moneySaved);
		
		
		//--TablePanel--//
		refreshTable(tablePanel);
		
		
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
		CusButton deleteBtn = new CusButton("To Catalog...", 13);
		
		deleteBtn.addActionListener(catalog);
		
		deleteBtn.setPreferredSize(new Dimension(150, 30));
		
		rightBtnPanel.add(deleteBtn);
		
		
	}
	
	// Mengambil data dari class DataBarang dan tambahkan ke tabel
		private void refreshTable(JPanel tablePanel) {
			
	        // Convert item list to table data
	        String[] columns = {"Nama", "Tipe", "Kadaluarsa", "Price (IDR)"};
	        Object[][] data = new Object[DataBarang.listBarang.size()][4];
	
	        for (int i = 0; i < DataBarang.listBarang.size(); i++) {
	            Barang item = DataBarang.listBarang.get(i);
	            data[i][0] = item.getName();
	            data[i][1] = item.getType();
	            data[i][2] = item.getDate();
	            data[i][3] = item.getHarga();
	        }
	
	        if (table != null) {
	            remove(scroller);
	        }
	
	        table = new JTable(data, columns);
	        scroller = new JScrollPane(table);
	        
	        scroller.setPreferredSize(new Dimension((int)(widthLimit * 0.8), 235));
	        
	        tablePanel.add(scroller, BorderLayout.CENTER);
	
	        revalidate();
	        repaint();
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
			
}
