package banking;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Update {

	public boolean updateEmail(String emailnew, String pass, int accno) throws ClassNotFoundException, SQLException
	{
		boolean a=false;
			
			String pass1="";
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con  = DriverManager.getConnection("jdbc:mysql://localhost/banking", "root", "root");
	        PreparedStatement st=con.prepareStatement("select pass from customer where accno="+accno+"");
	        ResultSet rs=st.executeQuery();
	        while(rs.next())
	        {
	            
	            pass1=rs.getString(1);
	        
	        } 
	        if(pass.equals(pass1))
            {
            	PreparedStatement ps = con.prepareStatement("update customer set email='"+emailnew+"' where accno="+accno+"");
            	ps.executeUpdate();
            	a=true;
//            response.sendRedirect("update1.html");
            }
           
	        return a;
	}
	public boolean updatePhone(String phonenew, String pass, int accno) throws ClassNotFoundException, SQLException
	{
		boolean a=false;
			
			String pass1="";
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con  = DriverManager.getConnection("jdbc:mysql://localhost/banking", "root", "root");
	        PreparedStatement st=con.prepareStatement("select pass from customer where accno="+accno+"");
	        ResultSet rs=st.executeQuery();
	        while(rs.next())
	        {
	            
	            pass1=rs.getString(1);
	        
	        } 
	        if(pass.equals(pass1))
            {
            	PreparedStatement ps = con.prepareStatement("update customer set Phoneno='"+phonenew+"' where accno="+accno+"");
            	ps.executeUpdate();
            	a=true;
//            response.sendRedirect("update1.html");
            }
           
	        return a;
	}
	public boolean updatePass(String passnew,String passnew1, String pass, int accno) throws ClassNotFoundException, SQLException
	{ 	
		
		boolean a=false;
		//	if(passnew.equals(passnew1))
		//	{
			String pass1="";
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con  = DriverManager.getConnection("jdbc:mysql://localhost/banking", "root", "root");
	        PreparedStatement st=con.prepareStatement("select pass from customer where accno="+accno+"");
	        ResultSet rs=st.executeQuery();
	        while(rs.next())
	        {
	            
	            pass1=rs.getString(1);
	        
	        } 
	        if(pass.equals(pass1))
            {
            	PreparedStatement ps = con.prepareStatement("update customer set pass='"+passnew+"' where accno="+accno+"");
            	ps.executeUpdate();
            	a=true;
//            response.sendRedirect("update1.html");
            }
		//	}
			
	        return a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
