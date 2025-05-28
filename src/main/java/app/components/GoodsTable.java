package app.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import app.modules.Barang;
import app.modules.DataBarang;

public class GoodsTable extends JScrollPane{
	private JTable table;
	
	
	private Dimension tableSize = new Dimension();
	private int headerSize = 40;
	private int headerFontSize = 12;
	private int rowSize = 30;
	
	
	public GoodsTable(JPanel panel, String[] headerTitle, int widthLimit, int heightLimit) {
		
	    // Create or reuse DefaultTableModel
	    DefaultTableModel model;
	    if (table == null) {
	        model = new DefaultTableModel(headerTitle, 0);
	        table = new JTable(model);
	        setViewportView(table);;
	        
	        setPreferredSize(new Dimension((int)(widthLimit * 0.8), 260));
	        panel.setLayout(new BorderLayout()); // Make sure layout is BorderLayout to use CENTER properly
	        panel.add(this, BorderLayout.CENTER);
	    } else {
	        // If table already exists, get model and clear rows
	        model = (DefaultTableModel) table.getModel();
	        model.setRowCount(0); // Clear existing rows
	    }
	    
	    // Add rows from DataBarang.barangUser
	    for (Barang item : DataBarang.barangUser) {
	        Object[] row = {
	            item.getName(),
	            item.getType(),
	            item.getDate(),
	            item.getHarga()
	        };
	        model.addRow(row);
	    }
		
		tableStyle();
	}
	
	public void setTableSize(Dimension tableSize) {
		this.tableSize = tableSize;
	}
	
	public void setHeaderSize(int size) {
		this.headerSize = size;
	}
	
	public void setHeaderFontSize(int fontSize) {
		this.headerFontSize = fontSize;
	}
	
	public void setRowHeight(int rowSize) {
		this.rowSize = rowSize;
	}
	
	private void tableStyle() {
	    //Table Styling
    	table.getTableHeader().setFont(new Font("ARIAL", Font.BOLD, headerFontSize));;
        table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getWidth(), headerSize));
		table.getTableHeader().setBackground(new Color(0x404040));
		table.getTableHeader().setForeground(new Color(0xf5f5f5));
		
        table.setRowHeight(rowSize);
        
        table.setBackground(getBackground());
        
        
        setPreferredSize(this.tableSize);
        
        // Center all columns
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);

        for (int i = 1; i < table.getColumnCount()-1; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        
        // Hide scrollbar UI but keep scroll functionality
        getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
	}
}
