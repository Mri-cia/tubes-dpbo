package app.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import app.model.*;
import app.components.*;

public class WindowPenjual extends JPanel {
	int totalItem = 0;
	int value = 0;
	int expiring = 0;
	JTable table;
	JScrollPane scroller;
	
	public WindowPenjual(ActionListener a, ActionListener b) {
		
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
		
		statPanel.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.black));
		
		//Sizing
		profilePanel.setPreferredSize(new Dimension(0, 100));
		statPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
		tablePanel.setPreferredSize(new Dimension((int)(MainWindow.winWidth * 0.08), 230));
		
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
		JLabel nameLabel = new JLabel("URSULA");
		JLabel roleLabel = new JLabel("Penjual");
		
		nameLabel.setFont(new Font("ARIAL", Font.BOLD, 40));
		roleLabel.setFont(new Font("ARIAL", Font.BOLD, 20));
		
		nameProfile.add(nameLabel);
		nameProfile.add(Box.createRigidArea(new Dimension(0, 7)));
		nameProfile.add(roleLabel);
		
		
		//--logoutPanel--//
		logoutPanel.setLayout(new BoxLayout(logoutPanel, BoxLayout.Y_AXIS));
		CusButton logoutBtn = new CusButton(new ImageIcon("C:\\Users\\rawik\\Documents\\Kuliah\\DPBO\\Tubes\\src\\main\\java\\assets\\logout_icon.png"));
		
		logoutBtn.setHoverEnabled(false);
		
		logoutBtn.setMaximumSize(new Dimension(38, 50));
		
		logoutBtn.setAlignmentX(JButton.RIGHT_ALIGNMENT);
		
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
		
		//--Table Panel-//
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
		CusButton addBtn = new CusButton("add", 12);
		CusButton editBtn = new CusButton("edit", 12);
		CusButton deleteBtn = new CusButton(new ImageIcon("C:\\Users\\rawik\\Documents\\Kuliah\\DPBO\\Tubes\\src\\main\\java\\assets\\delete_icon.png"));
		
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
	        
	        scroller.setPreferredSize(new Dimension((int)(MainWindow.winWidth * 0.8), 260));
	        
	        tablePanel.add(scroller, BorderLayout.CENTER);

	        revalidate();
	        repaint();
	    }
	   
}
