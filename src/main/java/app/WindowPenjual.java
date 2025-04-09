package app;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class WindowPenjual extends JPanel {
	JLabel name;
	JLabel role;
	JPanel statPane;
	JLabel goodsListed;
	JLabel goodsValue;
	JLabel goodsExpiring;
	int totalItem = 0;
	int value = 0;
	int expiring = 0;
	JTable table;
	JScrollPane scroller;
	
	public WindowPenjual(ActionListener a) {
		
		
		//STYLING
		//Set layout
		setLayout(null);
		
		//Profile
		name = new JLabel("URSULA");
		name.setFont(new Font("Arial", Font.BOLD, 30));
		name.setBounds((int)(MainWindow.winWidth * 0.1), (int)(MainWindow.winHeight * 0.1) - 30, 200, 30);
		
		role = new JLabel("Penjual");
		role.setFont(new Font("Arial", Font.PLAIN, 15));
		role.setBounds((int)(MainWindow.winWidth * 0.1), (name.getY()) + 50, 200, 17);
		
		//Statistic
		statPane= new JPanel();
		statPane.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK));
		statPane.setBounds(0, (role.getY() + role.getHeight()) + 30, (int)MainWindow.winWidth, 60);
		
		goodsListed = new JLabel("Listed Goods: " + totalItem);
		goodsListed.setBounds((int)(MainWindow.winWidth * 0.1), (int)(statPane.getY() + (statPane.getHeight() * 0.5)) - 10, 100, 20);
		
		goodsValue = new JLabel("Value of Goods: " + value);
		goodsValue.setBounds((int)(MainWindow.winWidth * 0.5) - 55, (int)(statPane.getY() + (statPane.getHeight() * 0.5)) - 10, 100, 20);
		
		goodsExpiring = new JLabel("Expiring Goods: " + expiring);
		goodsExpiring.setBounds((int)(MainWindow.winWidth * 0.9) - 120, (int)(statPane.getY() + (statPane.getHeight() * 0.5)) - 10, 120, 20);
		
		
		refreshTable();
		
		//Adding components
		//Profile
		add(name);
		add(role);
		
		//Statistic
		add(goodsListed);
		add(goodsValue);
		add(goodsExpiring);
		add(statPane);
	}
	
	// Mengambil data dari class DataBarang dan tambahkan ke tabel
		private void refreshTable() {
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
	        
	        scroller.setBounds((int)(MainWindow.winWidth * 0.1), (int)(statPane.getY() + (statPane.getHeight())) + 10, (int)(statPane.getWidth() * 0.8), 300);
	        
	        add(scroller, BorderLayout.CENTER);

	        revalidate();
	        repaint();
	    }
}
