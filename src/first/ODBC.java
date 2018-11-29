package first;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ODBC {
	
	JFrame f = new JFrame();
	String username = null;
	static Connection conn = null;
	public static void connect() {
        
        try {
            // db parameters
        	JFrame f= new JFrame();
            String url = "jdbc:oracle:thin:@orcl11g.thbs.india.com:1521:orac11g";
            String usr = "vasuki_g";
            String pwd = "thbs123";
            JOptionPane.showMessageDialog(f,url,"Result",JOptionPane.WARNING_MESSAGE);
            // create a connection to the database
            conn = DriverManager.getConnection(url,usr,pwd);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
    }
	public static void connClose() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
	
	protected boolean login(String user,String pass) {
		String log="SELECT * FROM login WHERE users='"+user+"' AND password='"+pass+"'";
		queryPrint(log);
		System.out.println(user+pass);
		JOptionPane.showMessageDialog(f,log,"Result",JOptionPane.WARNING_MESSAGE);
		boolean login_status=false;
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs    = stmt.executeQuery(log);
			if(rs.next()) {
				login_status=true;
				setSession(user);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(login_status);
		return login_status;
	}
	
	protected void queryPrint(String a) {
		JFrame f = new JFrame();
		try {
			StringBuilder strBuilder = new StringBuilder("");
			Statement stmt = conn.createStatement();
			ResultSet rs    = stmt.executeQuery(a);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			while (rs.next()) {
			    for (int i = 1; i <= columnsNumber; i++) {
			        if (i > 1) strBuilder.append(",  ");
			        String columnValue = rs.getString(i);
			        strBuilder.append(columnValue + " ");
			    }
			    strBuilder.append("\n");
			}
			JOptionPane.showMessageDialog(f,strBuilder,"Result",JOptionPane.WARNING_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected ResultSet select(String a) {
		
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs    = stmt.executeQuery(a);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	protected void insert(int num, String dname,String loc) {
        String sql = "INSERT INTO warehouses(name,capacity) VALUES(?,?)";
 
        try
        {  PreparedStatement pstmt = conn.prepareStatement(sql); 
            pstmt.setInt(1, num);
            pstmt.setString(2, dname);
            pstmt.setString(3, loc);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	protected void insert(int empno, String ename,String job,int mgr,String hdate,float sal,float comm,int dnum) {
        String sql = "INSERT INTO emp VALUES(?,?,?,?,?,?,?,?)";
 
        try
        {  PreparedStatement pstmt = conn.prepareStatement(sql); 
            pstmt.setInt(1, empno);
            pstmt.setString(2, ename);
            pstmt.setString(3, job);
            pstmt.setInt(4, mgr);
            pstmt.setString(5, hdate);
            pstmt.setFloat(6, sal);
            pstmt.setFloat(7, comm);
            pstmt.setInt(8, dnum);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	public void setSession(String u){
		username=u;
	}
	
	public String getSession(){
		return username;
	}
    /**
     * @param args the command line arguments
     
    public static void main(String[] args) {
        connect();
        System.out.println("Enter a query");
        Scanner sc=new Scanner(System.in);
        String str = sc.nextLine();
        ODBC o = new ODBC();
        o.select(str);
    }*/
}
