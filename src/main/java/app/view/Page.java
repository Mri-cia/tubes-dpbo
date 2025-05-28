package app.view;

import java.awt.*;
import javax.swing.*;

import app.modules.User;

public abstract class Page extends JPanel{
	protected int widthLimit = (int)MainWindow.winWidth;
	protected int heightLimit = (int)MainWindow.winHeight;
	protected Font defaultFont = new Font("ARIAL", Font.BOLD, 20);
	
	//colors to use brightest to darkest
	//Zinc pallete
	protected Color[] colors = {
			new Color(0xfafafa),
			new Color(0xf4f4f5),
			new Color(0xe4e4e7),
			new Color(0xd4d4d8),
			new Color(0xa1a1aa),
			new Color(0x71717a),
			new Color(0x52525b),
			new Color(0x3f3f46),
			new Color(0x27272a),
			new Color(0x18181b),
			new Color(0x09090b),
	};
	
	
}
