package app;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class CusButton extends JButton {
	
	private void defaultStyle() {
		setEnabled(true);
		setFocusable(false);
		setFont(new Font("ARIAL", Font.BOLD, 10));
		setBorder(null);
		setBackground(new Color(0x404040));
		setForeground(new Color(0xf5f5f5));
	}
	
	public void hoverEffect() {
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0xf5f5f5)));
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				defaultStyle();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				defaultStyle();
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
	}
	
	public CusButton(String text, int fontSize) {
		defaultStyle();
		hoverEffect();
		setText(text);
		setFont(new Font(this.getName(), Font.BOLD, fontSize));
	}
	
	public CusButton(String text, int fontSize, boolean isEnabled) {
		defaultStyle();
		hoverEffect();
		setText(text);
		setFont(new Font(this.getName(), Font.BOLD, fontSize));
		setEnabled(isEnabled);
	}
}
