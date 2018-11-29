package com.vasuki.bsd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import first.ODBC;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class dbmain extends ODBC implements dbInterface {
	boolean logStat=false;
	public dbmain() {
		// TODO Auto-generated constructor stub
		ODBC.connect();
	}
	public void logs(String u,String p) {
		logStat = login(u,p);
	}
	JFrame f = new JFrame();
	private static JTextField textField;
	private static JTextField textField_1;
	private String[] getLabels(int i) {
			String[] a = {"Emp Num: ", "Name: ", "Job: ", "Manager: ", "Hire DAte (DD-MON-YY): ", "Salary: ","Commision: ","Dept Num: "};
			String[] b = {"Dept No: ","Dept Name: ","Location: "};
		if(i != 1 || i != 2) {
			JOptionPane.showMessageDialog(f,"Error getting Labels","Result",JOptionPane.WARNING_MESSAGE);
		}
		return ((i == 1) ? a : (i == 2) ? b : null);
	}
	
	public static void main(String[] args) {
		
		dbmain d = new dbmain();
		JFrame f = new JFrame();

		JPanel panel = new JPanel();
		f.getContentPane().add(panel, BorderLayout.NORTH);
		f.setSize(400,400);  
	    f.getContentPane().setLayout(null);  
	    
	    JLabel lblUsername = new JLabel("Username");
	    lblUsername.setBounds(93, 92, 53, 14);
	    f.getContentPane().add(lblUsername);
	    
	    textField = new JTextField();
	    textField.setBounds(156, 89, 139, 20);
	    f.getContentPane().add(textField);
	    textField.setColumns(10);
	    
	    JLabel lblPassword = new JLabel("Password");
	    lblPassword.setBounds(93, 130, 46, 14);
	    f.getContentPane().add(lblPassword);
	    
	    textField_1 = new JTextField();
	    textField_1.setBounds(156, 127, 139, 20);
	    f.getContentPane().add(textField_1);
	    textField_1.setColumns(10);
	    
	    JButton btnLogin = new JButton("Login");
	    btnLogin.setBounds(147, 158, 89, 23);
	    f.getContentPane().add(btnLogin);
	    btnLogin.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	d.logs(textField.getText(),textField_1.getText());
		    	if(d.logStat) {
					JOptionPane.showMessageDialog(f,"Sucessfully Logged in","Result",JOptionPane.WARNING_MESSAGE);
					new Dashboard();
				}
				else {
					JOptionPane.showMessageDialog(f,"Error logging in","Result",JOptionPane.WARNING_MESSAGE);
				}
		        }  
		    });
	    
	    JButton btnExit = new JButton("Exit");
	    btnExit.setBounds(147, 192, 89, 23);
	    f.getContentPane().add(btnExit);
	    btnExit.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	f.setVisible(false);
		    	f.dispose();
		        }  
		    });
	    f.setVisible(true);
	}
}
