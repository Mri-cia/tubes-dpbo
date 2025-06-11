package app.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellEditor;

import app.exception.ErrorMessage;
import app.modules.Barang;
import app.modules.DataBarang;
import app.utils.CurrencyFormat;
import app.view.CatalogPage;

public class GoodsTable extends JScrollPane{
	private JTable table;
	private boolean isEditable = true;
	
	private Dimension tableSize = new Dimension();
	private int headerSize = 40;
	private int headerFontSize = 12;
	private int rowSize = 30;
	private boolean isSetDonate = false;
	
	
	public GoodsTable(JPanel panel, Dimension tableSize, String[] headerTitle, ArrayList<Barang> data, String tableType, boolean isSetDonate) {
		this.isSetDonate = isSetDonate;
		if(tableType.equalsIgnoreCase("profile")) {
			profileTable(panel, headerTitle, tableSize, data);
		} else if(tableType.equalsIgnoreCase("catalog")) {
			catalogTable(panel, headerTitle, tableSize, data);
		}
		
		triggerUpdate();
	}
	
	public void profileTable(JPanel panel, String[] headerTitle, Dimension tableSize, ArrayList<Barang> data) {
	    // Create or reuse DefaultTableModel
	    DefaultTableModel model;
	    if (table == null) {
	        model = new DefaultTableModel(headerTitle, 0) {
	            @Override
	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return isEditable; // Disable editing
	            }
	        };
	        table = new JTable(model);
	        setViewportView(table);
	        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	        table.getTableHeader().setReorderingAllowed(false);

	        
	        setPreferredSize(new Dimension((int)(tableSize.getWidth() * 0.8), 260));
	        panel.setLayout(new BorderLayout()); // Make sure layout is BorderLayout to use CENTER properly
	        panel.add(this, BorderLayout.CENTER);
	    } else {
	        // If table already exists, get model and clear rows
	        model = (DefaultTableModel) table.getModel();
	        model.setRowCount(0); // Clear existing rows
	    }
	    
    	if (isSetDonate) {
	    	// Add rows from DataBarang.data if donated
    		for (Barang item : data) {
    			Object[] row = {
    					item.getName(),
    					item.getType(),
    					item.getDate()
    			};
    			model.addRow(row);
    		}
    	} else {
    		// Add rows from DataBarang.data
    		for (Barang item : data) {
    			Object[] row = {
    					item.getName(),
    					item.getType(),
    					item.getDate(),
    					item.getDiscountedPriceStr()
    			};
    			model.addRow(row);
    		}
    	}
	    
		
		tableStyle();
	}
	
	public void catalogTable(JPanel panel, String[] headerTitle, Dimension tableSize, ArrayList<Barang> data) {
		
	    // Create or reuse DefaultTableModel
	    DefaultTableModel model;
	    if (table == null) {
	        model = new DefaultTableModel(headerTitle, 0) {
	            @Override
	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return isEditable; // Disable editing
	            }
	        };
	        table = new JTable(model);
	        setViewportView(table);
	        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	        table.getTableHeader().setReorderingAllowed(false);
	        
	        setPreferredSize(new Dimension((int)(tableSize.getWidth() * 0.8), 260));
	        panel.setLayout(new BorderLayout()); // Make sure layout is BorderLayout to use CENTER properly
	        panel.add(this, BorderLayout.CENTER);
	    } else {
	        // If table already exists, get model and clear rows
	        model = (DefaultTableModel) table.getModel();
	        model.setRowCount(0); // Clear existing rows
	    }
	    
	    	if (isSetDonate) {
		    	// Add rows from DataBarang.data if donated
	    		for (Barang item : data) {
	    			item.setHarga(0);
	    			Object[] row = {
	    					item.getName(),
	    					item.getType(),
	    					item.getDate(),
	    			};
	    			model.addRow(row);
	    		}
	    	} else {
	    		// Add rows from DataBarang.data
	    		for (Barang item : data) {
	    			Object[] row = {
	    					item.getName(),
	    					item.getType(),
	    					item.getDate(),
	    					item.getDiscountedPriceStr()
	    			};
	    			model.addRow(row);
	    		}
	    	}
	    
	    

		tableStyle();
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

        //table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        
        // Hide scrollbar UI but keep scroll functionality
        getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));

	}
	
	public void preventEditing(JFrame owner, String message) {
		CErrorDialog preventPop = new CErrorDialog(owner, message, 1);
		preventPop.setBtn1("Ok");
		preventPop.setVisible(true);
	}
	
	public void triggerUpdate() {
		((DefaultTableModel) table.getModel()).fireTableDataChanged();
	}
	
	public boolean isEditing() {
		return table.isEditing();
	}
	
	public void saveEditedCell() {
		if (table.isEditing()) {
		    table.getCellEditor().stopCellEditing();
		}
	}
	
	public int getSelectedRow() {
		System.out.println("ini");
		return table.getSelectedRow();
	}
	
	public int getSelectedColumn() {
		return table.getSelectedColumn();
	}
	
	public String getSelectedCellValue() {
		return (String)table.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
	}
	
	public void setEditEnabled(boolean set) {
		this.isEditable = set;
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

	public void setTableDonate(boolean isSetDonate) {
		this.isSetDonate = isSetDonate;
	}
	
	
}
