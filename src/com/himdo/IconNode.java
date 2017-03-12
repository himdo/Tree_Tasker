package com.himdo;

import javax.swing.Icon;
import javax.swing.tree.DefaultMutableTreeNode;

public class IconNode extends DefaultMutableTreeNode {
	
	//protected Icon icon;
	protected String name;

	Boolean completedTask = false;
	String description;
	
	
	//Contains only the node text
	public IconNode(String name)
	{
		super();
		this.name=name;
	}

	//The node that contains the structure of text and pictures
	/*public IconNode(Icon icon,String txt)
	{
	super();
	this.icon = icon;
	this.txt = txt;
	}
	
	public void setIcon(Icon icon)
	{
	this.icon = icon;
	}

	public Icon getIcon()
	{
	return icon;
	}*/

	public void setText(String name)
	{
	this.name=name;
	}

	public String getText()
	{
	return name;
	} 
}
