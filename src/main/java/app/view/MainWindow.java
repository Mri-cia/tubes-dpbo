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

    WindowLogin winLogin = new WindowLogin(e -> cardLayout.show(mainPane, "Penjual"),
        e -> cardLayout.show(mainPane, "Pembeli"));
    WindowPenjual winPenj = new WindowPenjual(e -> cardLayout.show(mainPane, "Login"),
        e -> cardLayout.show(mainPane, "TambahBarang"));
    WindowPembeli winPem = new WindowPembeli(e -> cardLayout.show(mainPane, "Login"));
    WindowTambahBarang winTambahBarang = new WindowTambahBarang(e -> cardLayout.show(mainPane, "Penjual"));

    mainPane.add(winLogin, "Login");
    mainPane.add(winPenj, "Penjual");
    mainPane.add(winPem, "Pembeli");
    mainPane.add(winTambahBarang, "TambahBarang");

    add(mainPane);
    cardLayout.show(mainPane, "Login"); // untuk testing layout
    setVisible(true);
  }

}
