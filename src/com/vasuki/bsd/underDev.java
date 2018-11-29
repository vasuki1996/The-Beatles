package com.vasuki.bsd;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class underDev{
	private JFrame f = new JFrame("Insert");
	public underDev() {
		// TODO Auto-generated constructor stub
		JPanel panel = new JPanel();
		f.getContentPane().add(panel, BorderLayout.NORTH);
		f.setSize(400,400);  
	    f.getContentPane().setLayout(null);
	    
	    JLabel lblHelloBoss = new JLabel("Hello Boss");
	    lblHelloBoss.setBounds(152, 99, 222, 14);
	    f.getContentPane().add(lblHelloBoss);
	    
	    JLabel lblThisPageStill = new JLabel("This page still is in development");
	    lblThisPageStill.setBounds(113, 124, 261, 14);
	    f.getContentPane().add(lblThisPageStill);
	    f.setVisible(true);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
