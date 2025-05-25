package app.view;

import javax.swing.*;
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
    
    managePages();

  }
  
  private void managePages() {
	  LoginPage winLogin = new LoginPage(e -> cardLayout.show(mainPane, "Penjual"),
			  e -> cardLayout.show(mainPane, "Pembeli"));
	  SellerPage winPenj = new SellerPage(e -> cardLayout.show(mainPane, "Login"),
			  e -> cardLayout.show(mainPane, "TambahBarang"));
	  BuyerPage winPem = new BuyerPage(e -> cardLayout.show(mainPane, "Login"));
	  AddGoodsPage winTambahBarang = new AddGoodsPage(e -> cardLayout.show(mainPane, "Penjual"));
	  
	  mainPane.add(winLogin, "Login");
	  mainPane.add(winPenj, "Penjual");
	  mainPane.add(winPem, "Pembeli");
	  mainPane.add(winTambahBarang, "TambahBarang");
	  
	  add(mainPane);
	  cardLayout.show(mainPane, "TambahBarang"); // untuk testing layout
	  setVisible(true);
  }

}
