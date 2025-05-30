package app.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

public class CPasswordField extends JPasswordField {
	private String placeholder;
	private Color background;
	
	public CPasswordField(String placeholder, Color getBackground) {
		super();
		this.placeholder = placeholder;
		setBackground(getBackground);
		setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black), new EmptyBorder(0, 5, 0, 0)));
	}
	
	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (getPassword().length == 0 && !isFocusOwner()) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(Color.GRAY);
            g2.setFont(getFont().deriveFont(Font.PLAIN));
            Insets insets = getInsets();
            g2.drawString(placeholder, insets.left + 5, getHeight() / 2 + getFont().getSize() / 2 - 2);
            g2.dispose();
        }
    }
	

}
