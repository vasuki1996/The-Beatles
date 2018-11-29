package com.vasuki.bsd;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import first.ODBC;


public class Dashboard extends ODBC {
private JFrame f = new JFrame("Second");
	
	public Dashboard() {
		String session = null;
		session = getSession();
		
		JPanel panel = new JPanel();
		f.getContentPane().add(panel, BorderLayout.NORTH);
		f.setSize(400,400);  
	    f.getContentPane().setLayout(null);  
	    
	    JLabel lblNewLabel = new JLabel("Welcome "+session);
	    lblNewLabel.setBounds(10, 0, 107, 14);
	    f.getContentPane().add(lblNewLabel);
	    
	    JButton btnCreateTable = new JButton("Create Table");
	    btnCreateTable.setBounds(79, 40, 219, 23);
	    f.getContentPane().add(btnCreateTable);
	    btnCreateTable.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e) {  
		    	new create();
		        }  
		    });
	    
	    JButton btnInsert = new JButton("Insert");
	    btnInsert.setBounds(79, 74, 219, 23);
	    f.getContentPane().add(btnInsert);
	    btnInsert.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e) {  
		    	try {
					new insert();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        }  
		    });
	    
	    JButton btnUpdate = new JButton("Update");
	    btnUpdate.setBounds(79, 108, 219, 23);
	    f.getContentPane().add(btnUpdate);
	    btnUpdate.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e) {  
		    	new underDev();
		        }  
		    });
	    
	    JButton btnDelete = new JButton("Delete");
	    btnDelete.setBounds(79, 142, 219, 23);
	    f.getContentPane().add(btnDelete);
	    btnDelete.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e) {  
		    	new underDev();
		        }  
		    });
	    
	    JButton btnDrop = new JButton("Drop");
	    btnDrop.setBounds(79, 176, 219, 23);
	    f.getContentPane().add(btnDrop);
	    btnDrop.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e) {  
		    	new underDev();
		        }  
		    });
	    
	    JLabel lblVersion = new JLabel("Version 0.0.1");
	    lblVersion.setBounds(267, 336, 107, 14);
	    f.getContentPane().add(lblVersion);
	    f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}
