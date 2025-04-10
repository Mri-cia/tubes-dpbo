package app.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.*;

public class WindowPembeli extends JPanel {
	JLabel test = new JLabel();
	JPanel panel = new JPanel();
	
	public WindowPembeli(ActionListener a) {
		panel.add(new JLabel("Halaman 2"));
		add(panel);
	}
}
