package app.view;

import java.awt.BorderLayout;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

import app.components.CusButton;
import app.modules.Barang;
import app.modules.DataBarang;

public class CatalogPage extends Page {

	JTable table;
	JScrollPane scroller;
	
	public CatalogPage() {
	    // --MainPanel setup--//
	    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	    JPanel titlePanel = new JPanel();
	    JPanel tablePanel = new JPanel();
	    JPanel buttonPanel = new JPanel();
	    
	    //	Sizing
	    titlePanel.setPreferredSize(new Dimension(0, 30));
	    tablePanel.setPreferredSize(new Dimension(0, (int)(heightLimit * 0.58)));
	    
	    add(Box.createRigidArea(new Dimension(0, 20)));
	    add(titlePanel);
	    add(Box.createRigidArea(new Dimension(0, 20)));
	    add(tablePanel);
	    add(buttonPanel);
	    
	    
	    //Testing Layout
	    //titlePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
	    //tablePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
	    //buttonPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
	    
	    
	    //--Title Panel--//
	    titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
	    JLabel title = new JLabel("KATALOG BARANG");
	    
	    title.setFont(defaultFont);
	    
	    titlePanel.add(title);
	    
	    
	    //--Table Panel--//
	    Dimension tableSize = new Dimension((int)(widthLimit * 0.9), 400);
	    donatedGoods(tablePanel, tableSize);
	    
	    
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
		
		
		//Btn panel sizing
		int outerWidth = -(int)(widthLimit * 0.08);
		
		outerLeft.setPreferredSize(new Dimension(outerWidth,0));
		outerRight.setPreferredSize(new Dimension(outerWidth,0));
		leftBtnPanel.setPreferredSize(new Dimension(275,0));
		rightBtnPanel.setPreferredSize(new Dimension(275,0));
		
		
		//Btn panel layout setup
		rightBtnPanel.setAlignmentY(JPanel.CENTER_ALIGNMENT);
		
		buttonPanel.add(outerLeft);
		buttonPanel.add(leftBtnPanel);
		buttonPanel.add(rightBtnPanel);
		buttonPanel.add(outerRight);
		
		
		//--leftBtnPanel--//
		leftBtnPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 9, 5));
		CusButton backBtn = new CusButton("Back", 12);
		backBtn.setPreferredSize(new Dimension(100, 30));
		leftBtnPanel.add(backBtn);
		
		
		//--rightBtnPanel--//
		rightBtnPanel.setLayout(new FlowLayout(FlowLayout.TRAILING, 9, 5));
		CusButton addBtn = new CusButton("add", 12);
		CusButton editBtn = new CusButton("edit", 12);
		CusButton deleteBtn = new CusButton("Lorem", 12);
		
		addBtn.setPreferredSize(new Dimension(100, 30));
		editBtn.setPreferredSize(new Dimension(100, 30));
		deleteBtn.setPreferredSize(new Dimension(100, 30));
		
		
		rightBtnPanel.add(addBtn);
		rightBtnPanel.add(editBtn);
		rightBtnPanel.add(deleteBtn);
	    
	}
	
	private void tradedGoods(JPanel tablePanel, Dimension tableSize) {
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
        
        scroller.setPreferredSize(tableSize);
        
        tablePanel.add(scroller, BorderLayout.CENTER);

        revalidate();
        repaint();
	}
	
	private void donatedGoods(JPanel tablePanel, Dimension tableSize) {
        // Convert item list to table data
		DataBarang.initializeData();
        String[] columns = {"Nama", "Tipe", "Kadaluarsa", "Price (IDR)"};
        Object[][] data = new Object[DataBarang.listBarang.size()][5];

        for (int i = 0; i < DataBarang.listBarang.size(); i++) {
            Barang item = DataBarang.listBarang.get(i);
            data[i][0] = item.getName();
            data[i][1] = item.getType();
            data[i][2] = item.getDate();
            data[i][3] = item.getHarga();
            data[i][4] = new CusButton("edit");
        }

        if (table != null) {
            remove(scroller);
        }

        table = new JTable(data, columns);
        scroller = new JScrollPane(table);
        
        table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getWidth(), 38));
        table.setRowHeight(30);
        
        table.setBackground(getBackground());
        scroller.setPreferredSize(tableSize);
        
        // Center all columns
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 1; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        // Hide scrollbar UI but keep scroll functionality
        scroller.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        scroller.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
        
 
        tablePanel.add(scroller, BorderLayout.CENTER);

        revalidate();
        repaint();
	}
	
	private void goBack() {
		
	}
}
