package app.view;

import java.awt.BorderLayout;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyEvent;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.*;

import app.components.CButton;
import app.components.CErrorDialog;
import app.components.GoodsTable;
import app.exception.AppException;
import app.exception.ErrorMessage;
import app.modules.*;

public class CatalogPage extends Page implements updatedPage {
	
	JFrame mainFrame;

	JTable table;
	JScrollPane scroller;
	
	JPanel modelPanel = new JPanel();
	
	JPanel rightBtnPanel;
	
	GoodsTable catalogTable;
	CButton backBtn;
	CButton buyBtn;
	
    
	ArrayList<Barang> allItems;
	ArrayList<User> userLists;
	private ArrayList<String> listSeller;
	private ArrayList<String> listDonator;
	
	ActionListener login;
	ActionListener backPenjual;
	ActionListener backPembeli;
	ActionListener refresh;
	
	private boolean hasShownError = false;
	
	public CatalogPage(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.login = login;
		

		
	    // --MainPanel setup--//
	    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	    JPanel titlePanel = new JPanel();
	    JPanel tablePanel = new JPanel();
	    JPanel buttonPanel = new JPanel();
	    
	    //	Sizing
	    titlePanel.setPreferredSize(new Dimension(0, 30));
	    tablePanel.setPreferredSize(new Dimension(0, (int)(HEIGHT_LIMIT * 0.58)));
		modelPanel.setPreferredSize(new Dimension((int)(WIDTH_LIMIT * 0.9), 400));
	    
	    add(Box.createRigidArea(new Dimension(0, 20)));
	    add(titlePanel);
	    add(Box.createRigidArea(new Dimension(0, 20)));
	    add(tablePanel);
	    add(buttonPanel);
	    
		tablePanel.add(modelPanel);
	    
	    //Testing Layout
	    //titlePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
	    //tablePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
	    //buttonPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
	    
	    
	    //--Title Panel--//
	    titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
	    JLabel title = new JLabel("KATALOG BARANG");
	    
	    title.setFont(DEFAULT_FONT);
	    
	    titlePanel.add(title);
	    
	    
	    
	    
		//--Button Panel--//
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		JPanel outerLeft = new JPanel();
		JPanel outerRight = new JPanel();
		JPanel leftBtnPanel = new JPanel();
		rightBtnPanel = new JPanel();
		
		//testing boundaries
		//outerLeft.setBackground(Color.red);
		//outerRight.setBackground(Color.red);
		//leftBtnPanel.setBackground(Color.DARK_GRAY);
		//rightBtnPanel.setBackground(Color.blue);
		
		
		//Btn panel sizing
		int outerWidth = -(int)(WIDTH_LIMIT * 0.08);
		
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
		backBtn = new CButton("Back", 12);
		backBtn.setPreferredSize(new Dimension(100, 30));
		leftBtnPanel.add(backBtn);
		
		
		//--rightBtnPanel--//
		rightBtnPanel.setLayout(new FlowLayout(FlowLayout.TRAILING, 9, 5));
//		CButton addBtn = new CButton("add", 12);
//		CButton editBtn = new CButton("edit", 12);
		URL shopIconURL = getClass().getResource("/app/view/assets/shop_icon.png");
		buyBtn = new CButton(new ImageIcon(shopIconURL));


		buyBtn.setPreferredSize(new Dimension(100, 30));
//		
//		
//		rightBtnPanel.add(addBtn);
//		rightBtnPanel.add(editBtn);


		
		addHierarchyListener(e -> {
		    boolean isShowing = (e.getChangeFlags() & HierarchyEvent.SHOWING_CHANGED) != 0;
		    if (isShowing && isShowing()) {        
		    	SwingUtilities.invokeLater(() -> {
		            if (user == null && !hasShownError) {
		                hasShownError = true; // Prevent repeated popups
		                checkUserAccess();
		            }
		    	});
		    }
		});

		
		
	}
	
	private void tradedGoods() {
		modelPanel.removeAll(); //refresh panel

		// Convert item list to table data
        String[] columns = {"Nama", "Tipe", "Kadaluarsa", "Price (IDR)"};

		allItems = new ArrayList<>();
		userLists = new ArrayList<>();
		for (User u : DataBarang.data.keySet()) {
			if (u instanceof Seller) {
				for (Barang b : DataBarang.data.get(u)) {
					allItems.add(b);
					userLists.add(u);
				}
			}
		}
		
		listSeller = DataBarang.listSellerUser("trade");
		
		catalogTable = new GoodsTable(
				modelPanel, 
				new Dimension(WIDTH_LIMIT, HEIGHT_LIMIT), 
				columns, 
				allItems, 
				"catalog",
				false
				);

        revalidate();
        repaint();
	}
	
	private void donatedGoods() {
		modelPanel.removeAll(); //refresh panel
		
        // Convert item list to table data
        String[] columns = {"Nama", "Tipe", "Kadaluarsa", "Price (IDR)"};

        
		allItems = new ArrayList<>();
		userLists = new ArrayList<>();
		for (User u : DataBarang.data.keySet()) {
			if (u instanceof Donator) {
				for (Barang b : DataBarang.data.get(u)) {
					allItems.add(b);
					userLists.add(u);
				}
			} 
		}
		
		listDonator = DataBarang.listSellerUser("donate");

		catalogTable = new GoodsTable(
				modelPanel, 
				new Dimension(WIDTH_LIMIT, HEIGHT_LIMIT), 
				columns, 
				allItems, 
				"catalog",
				true
				);

        revalidate();
        repaint();
	}
	
	private void showBuyBtn() {
		rightBtnPanel.remove(buyBtn);
		if(user instanceof Buyer || user instanceof Recipient) {
			rightBtnPanel.add(buyBtn);
		}
	}
	
	private void boughtAction() {    
		// Remove all previous action listeners
	    for (ActionListener al : buyBtn.getActionListeners()) {
	        buyBtn.removeActionListener(al);
	    }
		buyBtn.addActionListener(e -> {
			int selectedRow = catalogTable.getSelectedRow();
			System.out.println(selectedRow);
			Barang selectedBarang = allItems.get(selectedRow);
			User itemOwner = userLists.get(selectedRow);
			if (user instanceof Buyer) {
				
				DataBarang.buyBarang(selectedBarang, selectedRow);
				
				DataBarang.data.get(itemOwner).remove(selectedRow);
				
				//reload
				tradedGoods();
				
			} else if (user instanceof Recipient) {
				
				DataBarang.buyBarang(selectedBarang, selectedRow);
				
				DataBarang.data.get(itemOwner).remove(selectedRow);
				
				//reload
				donatedGoods();
			} 

			
		});
	}
	
	private void goBack(ActionListener backPenjual, ActionListener backPembeli) {
		backBtn.addActionListener(e -> {
			if (user instanceof Seller || user instanceof Donator) {
				backPenjual.actionPerformed(e);
			} else if (user instanceof Buyer || user instanceof Recipient) {
				backPembeli.actionPerformed(e);
			}
		});
	}	
	
	public void checkUserAccess() {
	    // Error pop up when enter catalogue without an account 
	    if (this.user == null) { 
	        SwingUtilities.invokeLater(() -> {
	            try {
	                throw new AppException(ErrorMessage.NO_ROLE_FOUND.getMessage());
	            } catch (AppException e) {
	            	CErrorDialog currentError =  new CErrorDialog(mainFrame, e.getMessage(), 2); 
	            	currentError.setBtn1("Go to Login");
	            	currentError.setBtn2("Exit");
	            	currentError.setBtn1Action(login);
	            	currentError.setBtn2Action(event -> System.exit(0));
	            	currentError.setVisible(true);
	            }
	        });
	    }
	}
	
	@Override
	public void setUser(User user){
	    this.user = user;
	    DataBarang.getUser(user);
	    updateUserInfo();


	    if (user instanceof Seller || user instanceof Buyer) {
		    tradedGoods();
	    } else if (user instanceof Donator || user instanceof Recipient) {
	    	donatedGoods();
	    }
	    
	    catalogTable.setEditEnabled(false);
	    
	    showBuyBtn();
		boughtAction();
	}

	@Override
	public void updateUserInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAction(ActionListener... args) {
		this.login = args[0];
		this.backPenjual = args[1];
		this.backPembeli = args[2];
		this.refresh = args[3];
		
		
		goBack(backPenjual, backPembeli);
		
	}

}
