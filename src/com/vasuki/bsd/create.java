package com.vasuki.bsd;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import first.ODBC;

import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

class ComboItem
{
    private String key;
    private String value;

    public ComboItem(String key, String value)
    {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString()
    {
        return key;
    }

    public String getKey()
    {
        return key;
    }

    public String getValue()
    {
        return value;
    }
}

public class create extends ODBC{
	private JFrame f = new JFrame("Create");
	String tabName;
	String tabColCount;
	public create() {
		tabName = JOptionPane.showInputDialog("Enter the Table Name");
		tabColCount = JOptionPane.showInputDialog("Enter the number of columns of the table");
		init(); 
		f.setVisible(true);
		f.setSize(400,400);  
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
		public void init() {
			try {
			SwingUtilities.invokeLater(
			new Runnable() {
			public void run() {
			makeGUI();
			}
			}
			);
			} catch (Exception exc) {
			System.out.println("Can't create because of " + exc);
			}
			}
		
		
			private void makeGUI() {
				int i,j;
			// Add 400 buttons to a panel.
			ArrayList<JComboBox<ComboItem>> l = new ArrayList<JComboBox<ComboItem>>();
			ArrayList<JTextField> txl = new ArrayList<JTextField>();
			JPanel jp = new JPanel();
			JComboBox<ComboItem> jb = new JComboBox<ComboItem>();
			int b = 0;
			jp.setLayout(new GridLayout(20, 20));
			for(i = 0; i < Integer.parseInt(tabColCount); i++) {
			for(j = 0; j < Integer.parseInt(tabColCount); j++) {
				if(j == 0) {
					
					l.add(new JComboBox<ComboItem>());
					jp.add(l.get(i));
					jb = l.get(i);
					jb.addItem(new ComboItem("Varchar2", "Varchar2"));
					jb.addItem(new ComboItem("Number", "Number"));
					jb.addItem(new ComboItem("Number(x,y)", "Number(x,y)"));
				}
				if(j == 1) {
					
					txl.add(new JTextField());
					jp.add(txl.get(i));
				}
				if(j == 2) jp.add(new JToggleButton("ifPK"));
				++b;
			}
			}
			JButton btnSubmit = new JButton("Submit");
			btnSubmit.addActionListener(new ActionListener(){  
			    public void actionPerformed(ActionEvent e) { 
			    	StringBuilder str = new StringBuilder();
			    	for(int i=0;i<Integer.parseInt(tabColCount);i++) {
			    		str.append(txl.get(i).getText()+"\t"+l.get(i).getSelectedItem().toString()+"\n");
			    	}
			    	JOptionPane.showMessageDialog(f,str,"Result",JOptionPane.WARNING_MESSAGE);
			        }  
			    });
			jp.add(btnSubmit, BorderLayout.CENTER);
			// Create the scroll pane.
			JScrollPane jsp = new JScrollPane(jp);
			// Add the scroll pane to the content pane.
			// Because the default border layout is used,
			// the scroll pane will be added to the center.
			f.getContentPane().add(jsp, BorderLayout.CENTER);
			}
}
