package first;

import java.awt.*;  
import java.awt.event.*;
import java.lang.ArithmeticException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.*;
public class test {
	
	public static void readFile() {
		JFileChooser chooser = new JFileChooser();
	    chooser.showOpenDialog(null);
	    File f1 = chooser.getSelectedFile();
	    String fname = f1.getAbsolutePath();
        String line = null;
        JFrame f = new JFrame();
        try
        {
        	StringBuilder strBuilder = new StringBuilder("File: "+fname+"\n\n"+"=====\nContents\n=====\n\n");
            /* FileReader reads text files in the default encoding */
            FileReader fileReader = new FileReader(fname);
            
            /* always wrap the FileReader in BufferedReader */
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while((line = bufferedReader.readLine()) != null)
            {
            	strBuilder.append(line+"\n");
            }
            
            /* always close the file after use */
            bufferedReader.close();
            
            /* Dialog printing the file contents */
            JOptionPane.showMessageDialog(f,strBuilder,"Result",JOptionPane.WARNING_MESSAGE);
        }
        catch(IOException ex)
        {
            System.out.println("Error reading file named '" + fname + "'");
        }
        catch(Exception ex1) {
        	JOptionPane.showMessageDialog(f,"Error Reading File\nOR\nFile Format Not Supported","Result",JOptionPane.WARNING_MESSAGE);
        }
	}
	public static void calc(int i) {
		JFrame f = new JFrame();
		try{
			String num= JOptionPane.showInputDialog("Enter 1st Number");
			int a = Integer.parseInt(num);
			String num1= JOptionPane.showInputDialog("Enter 2nd Number");
			int aa = Integer.parseInt(num1);
			if(i==1) {
				JOptionPane.showMessageDialog(f,String.valueOf((a+aa)),"Result",JOptionPane.WARNING_MESSAGE);
			}
			else if(i==2) {
				JOptionPane.showMessageDialog(f,String.valueOf((a-aa)),"Result",JOptionPane.WARNING_MESSAGE);
			}
			else {
				throw new ArithmeticException();
			}
		}
		catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(f,e1,"Result",JOptionPane.WARNING_MESSAGE);
		} 
		catch(ArithmeticException e) {
			JOptionPane.showMessageDialog(f,e,"Result",JOptionPane.WARNING_MESSAGE);
		}
			
	}
	public static void main(String[] args) {  
	    final Frame f=new Frame("Calculator");  
	    Button b=new Button("Add");  
	    b.setBounds(50,100,60,30);  
	    b.addActionListener(new ActionListener(){  
	    public void actionPerformed(ActionEvent e){  
	    	calc(1);
	        }  
	    });  
	    Button b1=new Button("Subtract");  
	    b1.setBounds(100,150,60,30);  
	    b1.addActionListener(new ActionListener(){  
	    public void actionPerformed(ActionEvent e){  
	    	calc(2);
	        }  
	    });
	    Button b2=new Button("Print Error");  
	    b2.setBounds(150,200,60,30);  
	    b2.addActionListener(new ActionListener(){  
	    public void actionPerformed(ActionEvent e){  
	    	try {
	    		throw new ArithmeticException();
	    	}
	    	catch(ArithmeticException e1) {
	    		JOptionPane.showMessageDialog(f,e1,"Result",JOptionPane.WARNING_MESSAGE);
	    	}
	        }  
	    });
	    Button b3=new Button("Read File");  
	    b3.setBounds(200,250,60,30);  
	    b3.addActionListener(new ActionListener(){  
	    public void actionPerformed(ActionEvent e){  
	    		readFile();
	        }  
	    });
	    Button b4=new Button("Exit");  
	    b4.setBounds(250,300,60,30);  
	    b4.addActionListener(new ActionListener(){  
	    public void actionPerformed(ActionEvent e){  
	    	f.setVisible(false);
	    	f.dispose();
	        }  
	    });
	    f.add(b);f.add(b1);f.add(b2);f.add(b3);f.add(b4); 
	    f.setSize(400,400);  
	    f.setLayout(null);  
	    f.setVisible(true);   
	}  
}
