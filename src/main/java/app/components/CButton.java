package app.components;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class CButton extends JButton {
	private int fontSize = 10;
	private boolean isEnabled = true;
	private boolean isAllowedHover = true;
	private int radius = 0;
	private int opacity = 255;
	
	private void defaultStyle() {
		setFocusable(false);
		setFont(new Font("ARIAL", Font.BOLD, fontSize));
		setBorder(null);
		setBackground(new Color(0x3f3f46));
		setForeground(new Color(0xf4f4f5));
		setVisible(true);
	}
	
	public CButton(String text) {
		defaultStyle();
		
		setText(text);
		setEnabled(isEnabled);
	}
	
	public CButton(ImageIcon icon) {
		defaultStyle();
		
		setIcon((Icon)icon);
		setEnabled(isEnabled);
	}
	
	public CButton(String text, int fontSize) {
		this.fontSize = fontSize;
		defaultStyle();
		
		setText(text);
		setEnabled(isEnabled);
	}
	
	public CButton(String text, int fontSize, boolean isEnabled) {
		this.fontSize = fontSize;
		this.radius = radius;
		this.isEnabled = isEnabled;
		defaultStyle();
		
		setText(text);
		setEnabled(isEnabled);
	}
	
//	public void setSize(int x, int y) {
//		setPreferredSize(new Dimension(x,y));
//	}
	
	public void setIconSize(int x, int y) {
		Image image = ((Image) this.getIcon()).getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		this.setIcon((Icon) image);
	}
	
}
