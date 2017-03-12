package com.himdo;

import java.awt.Dialog;
import java.awt.EventQueue;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.io.File;
import java.io.Serializable;
import javax.swing.JSeparator;
public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	public Main() {
		setTitle("Task Tasker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 832, 623);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		
		mnFile.add(mntmSave);
		
		JMenuItem mntmLoad = new JMenuItem("Load");
		
		mnFile.add(mntmLoad);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmAddNode = new JMenuItem("Add Node");
		
		mnEdit.add(mntmAddNode);
		
		JMenuItem mntmDeleteSelected = new JMenuItem("Delete Selected");
		
		mnEdit.add(mntmDeleteSelected);
		
		JSeparator separator = new JSeparator();
		mnEdit.add(separator);
		
		JMenuItem mntmClearNodeSelection = new JMenuItem("Clear Node Selection");
		
		mnEdit.add(mntmClearNodeSelection);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmGettingStarted = new JMenuItem("Getting Started");
		
		mnHelp.add(mntmGettingStarted);
		
		JMenuItem mntmCreatingAFolder = new JMenuItem("Creating a Folder");
		
		mnHelp.add(mntmCreatingAFolder);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 11, 116, 491);
		contentPane.add(scrollPane);
		
		JTree Tree = new JTree();
		Tree.setRootVisible(false);	
		
		Tree.setUI(new CustomTreeUI());
		Tree.setCellRenderer(new CustomTreeCellRenderer());
		scrollPane.setViewportView(Tree);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(124, 55, 682, 497);
		contentPane.add(scrollPane_1);
		
		JTextPane textPane = new JTextPane();
		scrollPane_1.setViewportView(textPane);
		
		
		Tree.setModel(new DefaultTreeModel(
				new IconNode("JTree")));
		
		JCheckBox chckbxTaskCompleted = new JCheckBox("Task Completed");
		chckbxTaskCompleted.setBounds(122, 9, 159, 39);
		contentPane.add(chckbxTaskCompleted);
		
		JButton btnApply = new JButton("Apply");
		
		btnApply.setBounds(717, 13, 89, 31);
		contentPane.add(btnApply);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(287, 9, 52, 39);
		contentPane.add(lblName);
		
		nameField = new JTextField();
		nameField.setBounds(349, 10, 133, 39);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JButton btnAddNewNode = new JButton("Add New Node");
		
		btnAddNewNode.setBounds(0, 513, 116, 39);
		contentPane.add(btnAddNewNode);
	
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IconNode node = (IconNode)Tree.getLastSelectedPathComponent();
				if(node == null)
					return;
			
				node.completedTask=chckbxTaskCompleted.isSelected();
				node.description=textPane.getText();
				node.name=nameField.getText();
				
				DefaultTreeModel treeModel = (DefaultTreeModel) Tree.getModel();
				treeModel.nodeChanged(node);
				Tree.setModel(treeModel);
				
				Tree.repaint();
			}
		});
	
		Tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent arg0) {
				IconNode node = (IconNode)Tree.getLastSelectedPathComponent();
				String txt = "";
				if(node == null)
					return;
				
				txt = node.description;
				chckbxTaskCompleted.setSelected(node.completedTask);
				
				nameField.setText(node.name);
				textPane.setText(txt);
			}
		});
		
		btnAddNewNode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IconNode node = (IconNode)Tree.getLastSelectedPathComponent();
				
				DefaultTreeModel model = (DefaultTreeModel) Tree.getModel();
				if(node == null){
					node = (IconNode) model.getRoot();
				}
				
				model.insertNodeInto(new IconNode("New Node"), node, node.getChildCount());
				
				if(model.getChildCount(model.getRoot())<2)
					model.reload();	
			}
		});
		
		
		mntmAddNode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IconNode node = (IconNode)Tree.getLastSelectedPathComponent();
				
				DefaultTreeModel model = (DefaultTreeModel) Tree.getModel();
				if(node == null){
					node = (IconNode) model.getRoot();
				}
				
				model.insertNodeInto(new IconNode("New Node"), node, node.getChildCount());
				
				if(model.getChildCount(model.getRoot())<2)
					model.reload();
			}
		});
		
		mntmDeleteSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IconNode node = (IconNode)Tree.getLastSelectedPathComponent();
				if(node == null)
					return;
				
				DefaultTreeModel model = (DefaultTreeModel) Tree.getModel();
				model.removeNodeFromParent(node);
			}
		});
		
		mntmClearNodeSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tree.clearSelection();
			}
		});
		
		
		
		
		
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {

					File file = fileChooser.getSelectedFile();
					Searalizer.save(Tree, file.getAbsolutePath());
				}
			}
		});
		
		mntmLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					Tree.setModel(((JTree)Searalizer.load(file.getAbsolutePath())).getModel());
				}
			}
		});
		
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		
		
		mntmGettingStarted.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new JPanel();
				panel.setLayout(null);
				int result = JOptionPane.showConfirmDialog(null, panel, "HELP", JOptionPane.OK_CANCEL_OPTION);
			}
		});
		
		mntmCreatingAFolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new JPanel();
				panel.setLayout(null);
				int result = JOptionPane.showConfirmDialog(null, panel, "HELP", JOptionPane.OK_CANCEL_OPTION);
			}
		});
	}
}
