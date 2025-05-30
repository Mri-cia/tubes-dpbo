package app.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class CDropDown<E> extends JComboBox<E> {
	
    public CDropDown(E[] items) {
        super(items);
        setUI(createCustomUI());
        setOpaque(true);
        setFocusable(false); // Optional: disables focus border
        setBorder(new EmptyBorder(0,5,0,0));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the border manually
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(new Color(0x3f3f46)); // Your border color
        g2.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        g2.dispose();
    }

    private BasicComboBoxUI createCustomUI() {
        return new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton arrowButton = new JButton("▼");
                arrowButton.setBorder(BorderFactory.createLineBorder(new Color(0x3f3f46)));
                arrowButton.setBackground(new Color(0x3f3f46)); // Custom color
                arrowButton.setForeground(new Color(0xf4f4f5)); // Arrow color
                arrowButton.setFocusPainted(false);
                arrowButton.setOpaque(true);
                return arrowButton;
            }
        };
    }
}
