package first;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class dbGUI extends ODBC {
	JFrame f = new JFrame();
	Scanner scan = new Scanner(System.in);
	private void reademp() {
		String[] labels = {"Emp Num: ", "Name: ", "Job: ", "Manager: ", "Hire DAte (DD-MON-YY): ", "Salary: ","Commision: ","Dept Num: "};
		int numPairs = labels.length;

		List<String> a1 = new ArrayList<String>();
		for (int i = 0; i < numPairs; i++) {
		    a1.add(JOptionPane.showInputDialog("Enter "+labels[i]));
		}

		//Lay out the panel.
		//SpringUtilities.makeCompactGrid(p,numPairs, 2,6, 6, 6, 6);		    
		
		insert(Integer.parseInt(a1.get(0)),a1.get(1),a1.get(2),Integer.parseInt(a1.get(3)),a1.get(4),Float.parseFloat(a1.get(5)),Float.parseFloat(a1.get(6)),Integer.parseInt(a1.get(7)));
	}
	
	public static void main(String[] args) throws SQLException {
		//connect();
		dbGUI d = new dbGUI();
		ResultSet r = d.select("insert into dept values(11,'abc','def')");
	}

}
