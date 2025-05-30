package app.view;

import javax.swing.*;

import app.modules.DataBarang;
import app.modules.DataUser;
import app.modules.User;

import app.exception.*;

import java.awt.*;
import java.util.HashMap;

public class MainWindow extends JFrame {
  private CardLayout cardLayout;
  private JPanel mainPane;
  private static Dimension winSize = new Dimension(800, 600);
  public static double winWidth = winSize.getWidth();
  public static double winHeight = winSize.getHeight();
  

  public MainWindow() {
    setSize(winSize);
    setTitle("TuBes DPBO");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setLocationRelativeTo(null);
    
    setBackground(new Color(0xfafafa));
    
    DataUser.initData();
    DataBarang.initializeData(); //Inisialisasi data awal
    managePages();
  }
  
  private void managePages() {
	  cardLayout = new CardLayout();
	  mainPane = new JPanel(cardLayout);
	  
	  Page winTambahBarang;
	  Page winKatalog;
	  Page winPenj;
	  Page winPem;
	  Page winLogin;
	  
	  
	  
	  winTambahBarang = new AddGoodsPage(
			  e -> cardLayout.show(mainPane, "Penjual")
			  );
	  
	  winKatalog = new CatalogPage(
			  e -> cardLayout.show(mainPane, "Login"),
			  e -> cardLayout.show(mainPane, "Pembeli"),
			  this
			  );
	  
	  winPenj = new SellerPage(
			  e -> cardLayout.show(mainPane, "Login"),
			  e -> {winTambahBarang.setUser(LoginPage.getCurrentUser()); cardLayout.show(mainPane, "TambahBarang");},
			  e -> {winKatalog.setUser(LoginPage.getCurrentUser()); cardLayout.show(mainPane, "Katalog");}
			  );
	  
	  winPem = new BuyerPage(
			  e -> cardLayout.show(mainPane, "Login"), 
			  e -> {winKatalog.setUser(LoginPage.getCurrentUser()); cardLayout.show(mainPane, "Katalog");}
			  );
	  
	  
	  winLogin = new LoginPage(
			  e -> {winPenj.setUser(LoginPage.getCurrentUser()); cardLayout.show(mainPane, "Penjual");},
			  e -> {winPem.setUser(LoginPage.getCurrentUser()); cardLayout.show(mainPane, "Pembeli");}
			  );
	  
	  
	  
	  mainPane.add(winLogin, "Login");
	  mainPane.add(winPenj, "Penjual");
	  mainPane.add(winPem, "Pembeli");
	  mainPane.add(winTambahBarang, "TambahBarang");
	  mainPane.add(winKatalog, "Katalog");
	  
	  add(mainPane);
	  cardLayout.show(mainPane, "Katalog");// untuk testing layout
	  setVisible(true);
  }
  
  
  
  //--Metode untuk class user terisi atau tidak
//  private void checkUserClass() { 
//	  User user = LoginPage.getCurrentUser();
//	  System.out.println(user.getUsername() + user.getPassword()); 
//  }
}
