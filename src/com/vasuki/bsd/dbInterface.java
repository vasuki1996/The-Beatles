package com.vasuki.bsd;

import java.io.File;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public interface dbInterface {
	default List<String> read(String[] a) {
		int numPairs = a.length;

		List<String> a1 = new ArrayList<String>();
		for (int i = 0; i < numPairs; i++) {
		    a1.add(JOptionPane.showInputDialog("Enter "+a[i]));
		}
		return a1;
	}
	default void display(ResultSet rs) throws SQLException {
		JFrame f = new JFrame();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		StringBuilder strBuilder = new StringBuilder();
		while (rs.next()) {
		    for (int i = 1; i <= columnsNumber; i++) {
		        if (i > 1) strBuilder.append(",  ");
		        String columnValue = rs.getString(i);
		        strBuilder.append(columnValue + " ");
		    }
		    strBuilder.append("\n");
		}
		JOptionPane.showMessageDialog(f,strBuilder,"Result",JOptionPane.WARNING_MESSAGE);
	}
}
