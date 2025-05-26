package app.components;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class CusButton extends JButton {
	private int fontSize = 10;
	private boolean isEnabled = true;
	private boolean isAllowedHover = true;
	private int radius = 0;
	private int opacity = 255;
	
	private void defaultStyle() {
		setFocusable(false);
		setFont(new Font("ARIAL", Font.BOLD, fontSize));
		setBorder(null);
		setBackground(new Color(0x404040));
		setForeground(new Color(0xf5f5f5));
	}
	
	public void hoverEffect() {
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				if(isEnabled && isAllowedHover) {
					defaultStyle();

				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				defaultStyle();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				setBackground(new Color(0xffffff));
				setForeground(Color.black);
				setCursor(new Cursor(Cursor.HAND_CURSOR));
				setOpaque(true);
				repaint();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				defaultStyle();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				defaultStyle();
			}
		});
	}
	
	public CusButton(String text) {
		defaultStyle();
		hoverEffect();
		setText(text);
		setEnabled(isEnabled);
	}
	
	public CusButton(ImageIcon icon) {
		defaultStyle();
		hoverEffect();
		setIcon((Icon)icon);
		setEnabled(isEnabled);
	}
	
	public CusButton(String text, int fontSize) {
		this.fontSize = fontSize;
		defaultStyle();
		hoverEffect();
		setText(text);
		setEnabled(isEnabled);
	}
	
	public CusButton(String text, int fontSize, boolean isEnabled) {
		this.fontSize = fontSize;
		this.radius = radius;
		this.isEnabled = isEnabled;
		defaultStyle();
		hoverEffect();
		setText(text);
		setEnabled(isEnabled);
	}
	
	public void setIconSize(int x, int y) {
		Image image = ((Image) this.getIcon()).getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		this.setIcon((Icon) image);
	}
	
	public void setHoverEnabled(boolean isAllowedHover) {
		this.isAllowedHover = isAllowedHover;
	}

	
}
