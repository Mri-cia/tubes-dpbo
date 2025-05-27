package app.view;

import javax.swing.*;

import app.modules.User;

import java.awt.*;

public class MainWindow extends JFrame {
  private CardLayout cardLayout = new CardLayout();
  private JPanel mainPane = new JPanel(cardLayout);
  private static Dimension winSize = new Dimension(800, 600);
  public static double winWidth = winSize.getWidth();
  public static double winHeight = winSize.getHeight();

  public MainWindow() {
    setSize(winSize);
    setTitle("TuBes DPBO");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setLocationRelativeTo(null);
    
    managePages();

  }
  
  private void managePages() {
	  
	  
	  ProfilePages winTambahBarang = new AddGoodsPage(e -> cardLayout.show(mainPane, "Penjual"));
	  
	  ProfilePages winPenj = new SellerPage(
			  e -> cardLayout.show(mainPane, "Login"),
			  e -> {winTambahBarang.setUser(LoginPage.getCurrentUser());cardLayout.show(mainPane, "TambahBarang");},
			  e -> cardLayout.show(mainPane, "Katalog")
			  );
	  
	  ProfilePages winPem = new BuyerPage(
			  e -> cardLayout.show(mainPane, "Login"), 
			  e -> cardLayout.show(mainPane, "Katalog")
			  );
	  
	  Page winKatalog = new CatalogPage(
			  e -> cardLayout.show(mainPane, "Pembeli")
			  );
	  
	  Page winLogin = new LoginPage(
			  e -> {winPenj.setUser(LoginPage.getCurrentUser()); cardLayout.show(mainPane, "Penjual");},
			  e -> {winPem.setUser(LoginPage.getCurrentUser()); cardLayout.show(mainPane, "Pembeli");}
			  );
	  
	  mainPane.add(winLogin, "Login");
	  mainPane.add(winPenj, "Penjual");
	  mainPane.add(winPem, "Pembeli");
	  mainPane.add(winTambahBarang, "TambahBarang");
	  mainPane.add(winKatalog, "Katalog");
	  
	  add(mainPane);
	  cardLayout.show(mainPane, "Katalog"); // untuk testing layout
	  setVisible(true);
  }
  
  
  //--Metode untuk class user terisi atau tidak
//  private void checkUserClass() {
//	  User user = LoginPage.getCurrentUser();
//	  System.out.println(user.getUsername() + user.getPassword()); 
//  }

}
