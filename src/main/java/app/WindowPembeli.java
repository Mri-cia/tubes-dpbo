package app;

import javax.swing.*;
import java.awt.*;

public class WindowPembeli extends MainWindow {
	JLabel test = new JLabel();
	JPanel panel = new JPanel();
	
	public WindowPembeli() {
		panel.add(new JLabel("Halaman 2"));
		add(panel);
	}
}
