package app.components;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicTextFieldUI;

public class CTextField extends JTextField{
	private String placeholder;
	
	public CTextField(String placeholder, Color getBackground) {
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
        if (getText().isEmpty() && !isFocusOwner()) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(Color.GRAY);
            g2.setFont(getFont().deriveFont(Font.PLAIN));
            Insets insets = getInsets();
            g2.drawString(placeholder, insets.left + 5, getHeight() / 2 + getFont().getSize() / 2 - 2);
            g2.dispose();
        }
		

    }
	

}
