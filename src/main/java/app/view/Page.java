package app.view;

import java.awt.*;
import javax.swing.*;

public abstract class Page extends JPanel{
	protected int widthLimit = (int)MainWindow.winWidth;
	protected int heightLimit = (int)MainWindow.winHeight;
	protected Font defaultFont = new Font("ARIAL", Font.BOLD, 20);
	protected Color[] colors;
	
	public Page() {
		super();
	}
}
