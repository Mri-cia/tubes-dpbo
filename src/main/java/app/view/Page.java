package app.view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import app.modules.User;

abstract class Page extends JPanel{
	final int WIDTH_LIMIT = (int)MainWindow.winWidth;
	final int HEIGHT_LIMIT = (int)MainWindow.winHeight;
	final Font DEFAULT_FONT = new Font("ARIAL", Font.BOLD, 20);
	
	protected User user;
}
