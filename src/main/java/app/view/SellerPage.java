package app.view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

import app.modules.*;
import app.components.*;

public class SellerPage extends ProfilePages{
	int totalItem = 0;
	int value = 0;
	int expiring = 0;
	JTable table;
	JScrollPane scroller;
	
	private JPanel tablePanel = new JPanel();
	private JPanel modelPanel = new JPanel();

	private JLabel nameLabel = new JLabel("URSULA");
	private JLabel roleLabel = new JLabel("Penjual");
	
	public SellerPage(ActionListener logout, ActionListener b, ActionListener catalog) {
		
		//--MainPanel setup--//
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel profilePanel = new JPanel();
		JPanel statPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		//testing boundaries
		//profilePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		//tablePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		//buttonPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		
		statPanel.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.black));
		
		//Sizing
		profilePanel.setPreferredSize(new Dimension(0, 100));
		statPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
		
		tablePanel.setPreferredSize(new Dimension(widthLimit, 200));
		
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(profilePanel);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(statPanel);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(tablePanel);
		add(Box.createRigidArea(new Dimension(0, 5)));
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
		CButton logoutBtn = new CButton("Back");
		
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
		statPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		statPanel.add(numberPanel);
		statPanel.add(Box.createRigidArea(new Dimension(0, 25)));
		
		
		//--numberPanel--//
		numberPanel.setLayout(new BoxLayout(numberPanel, BoxLayout.X_AXIS));
		JLabel goodsListed = new JLabel("Goods Listed: " + totalItem);
		JLabel goodsValue = new JLabel("Value of Goods: " + value);
		JLabel goodsExpiring = new JLabel("Expiring Goods: " + expiring);
		
		goodsListed.setFont(new Font("ARIAL", Font.BOLD, 13));
		goodsValue.setFont(new Font("ARIAL", Font.BOLD, 13));
		goodsExpiring.setFont(new Font("ARIAL", Font.BOLD, 13));
		
		goodsValue.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		numberPanel.add(goodsListed);
		numberPanel.add(Box.createRigidArea(new Dimension(118, 0)));
		numberPanel.add(goodsValue);
		numberPanel.add(Box.createRigidArea(new Dimension(100, 0)));
		numberPanel.add(goodsExpiring);
		
		
		
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
		CButton addBtn = new CButton("add", 12);
		CButton editBtn = new CButton("edit", 12);
		CButton deleteBtn = new CButton(new ImageIcon("C:\\Users\\rawik\\Documents\\Kuliah\\DPBO\\Tubes\\src\\main\\java\\assets\\delete_icon.png"));
		
		addBtn.setPreferredSize(new Dimension(100, 30));
		editBtn.setPreferredSize(new Dimension(100, 30));
		deleteBtn.setPreferredSize(new Dimension(50, 30));
		
		addBtn.addActionListener(e -> {
		  b.actionPerformed(e);
		});
		
		rightBtnPanel.add(addBtn);
		rightBtnPanel.add(editBtn);
		rightBtnPanel.add(deleteBtn);
	}
	
	// Mengambil data dari class DataBarang dan tambahkan ke tabel
	private void refreshTable(JPanel tablePanel) {
		modelPanel.removeAll(); //refresh panel
		modelPanel.setPreferredSize(new Dimension((int)(widthLimit * 0.9), 230));
		tablePanel.add(modelPanel);

		String[] columns = {"Nama", "Tipe", "Kadaluarsa", "Price (IDR)"};

	    
		Dimension tableSize = new Dimension((int)(widthLimit * 0.9), 400);
		GoodsTable sellerTable = new GoodsTable(modelPanel, columns, widthLimit, heightLimit);
				
	    revalidate();
	    repaint();
	}
		
	@Override
	public void setUser(User user) {
	    this.user = user;
	    DataBarang.getUser(user);
	    updateUserInfo();
	    refreshTable(tablePanel);
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
