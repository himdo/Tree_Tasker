package com.himdo;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class Icons {
	static Icon DefaultFolderClosed = UIManager.getIcon("Tree.closedIcon");
	static Icon DefaultFolderOpen = UIManager.getIcon("Tree.openIcon");
	static Icon DefaultLeaf = UIManager.getIcon("Tree.leafIcon");
	static ImageIcon taskCompleted = new ImageIcon("Icon/Completed.png");
	static ImageIcon taskNotCompleted = new ImageIcon("Icon/NotCompleted.png");
}
