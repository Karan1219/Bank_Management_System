package banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

public class main1
{
//	public static void dbconnection() throws ClassNotFoundException, SQLException
//	{
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con  = DriverManager.getConnection("jdbc:mysql://localhost/bank", "root", "root");
//		
//	}
	public static boolean Chk(int acc,String pass)
	{
		boolean a=false;
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con  = DriverManager.getConnection("jdbc:mysql://localhost/banking", "root", "root");
			ps = con.prepareStatement("select * from customer where Accno="+acc+" and pass='"+pass+"'"); 
		    rs=ps.executeQuery();
		a=rs.next();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
//		if(a)
//		{
//			ps = con.prepareStatement("select name from customer where Accno="+acc+"");
//			rs=ps.executeQuery();
//			HttpSession session = 
//			String name=rs.getString(1);
//			session.setAttribute("username", name);
//		}
		return a;
	}
	 public  String savedataS(String type,String name, String mobile, String email, String pan, String id, String pass) throws ClassNotFoundException, SQLException
	 {
		 String msg="";
		 try {
		 Class.forName("com.mysql.jdbc.Driver");
		
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost/banking", "root", "root");
			PreparedStatement st = con.prepareStatement("insert into customer(Type,Name,Amount,Pan,"
					+ "IDProof,Pass,phoneno,email,Gstn,ResProof) values(?,?,?,?,?,?,?,?,?,?)");
			 int amt=10000;
			 String gstn="-",regid="-";
			st.setString(1, type);													//giving values to sql command											
			st.setString(2, name);													//giving values to sql command
			st.setInt(3, amt);														//giving values to sql command
			st.setString(4, pan);													//giving values to sql command
			st.setString(5, id);													//giving values to sql command
			st.setString(6, pass);													//giving values to sql command
			st.setString(7, mobile);												//giving values to sql command
			st.setString(8, email);													//giving values to sql command
			st.setString(9, gstn);													//giving values to sql command
			st.setString(10, regid);												//giving values to sql command				
			st.executeUpdate(); 													//Executing my sql command
//			con.close();	
			msg="save";
		 }
		 catch (Exception e) {
			msg=e.toString();
		}
		 return msg;
	 }
	 public  String savedataC(String type,String name, String mobile, String email, String gstn, String regid, String pass) throws ClassNotFoundException, SQLException
	 {
		 String msg="";
		 try {
		 Class.forName("com.mysql.jdbc.Driver");
		
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost/banking", "root", "root");
			PreparedStatement st = con.prepareStatement("insert into customer(Type,Name,Amount,Gstn,"
					+ "ResProof,Pass,phoneno,email,Pan,IDProof) values(?,?,?,?,?,?,?,?,?,?)");
			 int amt=10000;
			 String pan="-",id="-";
			st.setString(1, type);													//giving values to sql command														
			st.setString(2, name);													//giving values to sql command
			st.setInt(3, amt);														//giving values to sql command
			st.setString(4, gstn);													//giving values to sql command
			st.setString(5, regid);													//giving values to sql command
			st.setString(6, pass);													//giving values to sql command
			st.setString(7, mobile);												//giving values to sql command
			st.setString(8, email);													//giving values to sql command
			st.setString(9, pan);													//giving values to sql command
			st.setString(10, id);													//giving values to sql command
			st.executeUpdate(); 													//Executing my sql command
//			con.close();	
			msg="save";
		 }
		 catch (Exception e) {
			msg=e.toString();
		}
		 return msg;
	 }

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
//		String k="hell";
//		savedataS(k,k,k,k,k,k,k);
		System.out.println("hello");

	}

}
