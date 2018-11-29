package com.vasuki.bsd;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import first.ODBC;


public class insert extends ODBC {
	private JFrame f = new JFrame("Insert");
	public insert() throws SQLException {
		JPanel panel = new JPanel();
		f.getContentPane().add(panel, BorderLayout.NORTH);
		f.setSize(400,400);  
	    f.getContentPane().setLayout(null);
	    
	    JComboBox<ComboItem> comboBox = new JComboBox();
	    comboBox.setBounds(183, 11, 151, 20);
	    f.getContentPane().add(comboBox);
	    ResultSet rs = select("SELECT tname FROM tab");
	    ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while (rs.next()) {
		    for (int i = 1; i <= columnsNumber; i++) {
		        String columnValue = rs.getString(i);
		        comboBox.addItem(new ComboItem(columnValue, columnValue));
		    }
		}
	    
	    
	    JLabel lblSelectTable = new JLabel("Select Table");
	    lblSelectTable.setBounds(85, 14, 88, 14);
	    f.getContentPane().add(lblSelectTable);
	    f.setVisible(true);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
