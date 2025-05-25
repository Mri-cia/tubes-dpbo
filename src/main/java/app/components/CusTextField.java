package app.components;

import java.awt.*;
import javax.swing.*;

public class CusTextField extends JTextField{
	private Dimension size;
	private int radius = 0;
	private int opacity = 255;
	
	public CusTextField(Dimension size) {
		super();
		this.size = size;
	}
	
	public CusTextField(Dimension size, int radius) {
		super();
		this.size = size;
		this.radius = radius;
	}
	
	public CusTextField(Dimension size, int radius, int opacity) {
		super();
		this.size = size;
		this.radius = radius;
		this.opacity = opacity;
	}

	@Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        // Smooth edges
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Background
        g2.setColor(new Color(255, 255, 255, opacity));
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);

        // Draw the text
        super.paintComponent(g2);
        g2.dispose();
    }
	
	 @Override
	    protected void paintBorder(Graphics g) {
	        Graphics2D g2 = (Graphics2D) g.create();

	        // Smooth border
	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	        // Border color
	        g2.setColor(Color.GRAY);
	        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
	        g2.dispose();
	    }
}
