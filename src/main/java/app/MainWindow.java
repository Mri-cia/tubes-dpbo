package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
		
		WindowLogin winLogin = new WindowLogin(e -> cardLayout.show(mainPane, "Register"));
		
		mainPane.add(winLogin, "Login");
		
		
		add(mainPane);
		setVisible(true);
	}
	
	
}
