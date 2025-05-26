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
    setLocationRelativeTo(null);
    
    managePages();

  }
  
  private void managePages() {
	  
	  Page winLogin = new LoginPage(
			  e -> cardLayout.show(mainPane, "Penjual"),
			  e -> cardLayout.show(mainPane, "Pembeli")
			  );
	  
	  Page winPenj = new SellerPage(
			  e -> cardLayout.show(mainPane, "Login"),
			  e -> cardLayout.show(mainPane, "TambahBarang"),
			  e -> cardLayout.show(mainPane, "Katalog")
			  );
	  
	  Page winPem = new BuyerPage(
			  e -> cardLayout.show(mainPane, "Login"), 
			  e -> cardLayout.show(mainPane, "Katalog")
			  );
	  
	  Page winTambahBarang = new AddGoodsPage(e -> cardLayout.show(mainPane, "Penjual"));
	  Page winKatalog = new CatalogPage();
	  
	  mainPane.add(winLogin, "Login");
	  mainPane.add(winPenj, "Penjual");
	  mainPane.add(winPem, "Pembeli");
	  mainPane.add(winTambahBarang, "TambahBarang");
	  mainPane.add(winKatalog, "Katalog");
	  
	  add(mainPane);
	  cardLayout.show(mainPane, "Login"); // untuk testing layout
	  setVisible(true);
  }

}
