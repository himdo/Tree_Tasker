package com.himdo;

import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.plaf.basic.BasicTreeUI;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.AbstractLayoutCache.NodeDimensions;


public class CustomTreeUI extends BasicTreeUI{
	
	
	@Override
	protected void paintHorizontalPartOfLeg(Graphics g, Rectangle clipBounds, Insets insets, Rectangle bounds,
			TreePath path, int row, boolean isExpanded, boolean hasBeenExpanded, boolean isLeaf) {
		
	}
	
	@Override
	protected void paintVerticalPartOfLeg(Graphics g, Rectangle clipBounds, Insets insets, TreePath path) {
		
	}

}
