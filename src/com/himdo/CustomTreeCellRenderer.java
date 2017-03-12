package com.himdo;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import com.himdo.Icons;
public class CustomTreeCellRenderer extends DefaultTreeCellRenderer{
	@Override
	public void setIcon(Icon icon) {
		super.setIcon(icon);
	}
	
	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
			int row, boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
		if((value).getClass().getName().equals("com.himdo.IconNode")){
			String txt = ((IconNode)value).getText();
			setText(txt);
		}
		if(expanded){
			super.setIcon(openIcon);
			//setText("open");
		}else{
			super.setIcon(closedIcon);
			//setText("Closed");
		}
		if(leaf){
			
			if(((IconNode)value).completedTask){
				super.setIcon(Icons.taskCompleted);
			}
			else{
				super.setIcon(Icons.taskNotCompleted);
			}
			//setText("Leaf");
		}
		//this.hasFocus = hasFocus;
		//this.selected = sel;
		
		return this;//super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
	}
	
}
