package banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sendmoney {
	static Connection con=null;
	static PreparedStatement ps =null;
//	 ResultSet rs=null;
	public static  boolean chkpass(int accnoSend,String pass) throws SQLException, ClassNotFoundException
	{
		boolean a=false;
	//	String pass1=null;
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			con  = DriverManager.getConnection("jdbc:mysql://localhost/banking", "root", "root");
			ps = con.prepareStatement("select pass from customer where Accno="+accnoSend+" and pass='"+pass+"'"); 
			
			ResultSet rs=ps.executeQuery();
		    a=rs.next();
		    
//		    while(rs.next())
//		    {
//		    	pass1=rs.getString(1);
//		    }
////		    System.out.println(pass1);
//		    if(pass.equals(pass1))
//		    {
//		    	a=rs.next();
//		    }
//		    System.out.println(pass1);
//		    System.out.println(pass);
		  //  System.out.println(a);
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return a;
	}
	public static  boolean chk(int accnoSend ,int accRec,double amount) throws SQLException, ClassNotFoundException
	{
		boolean a=false,b=false;
		Class.forName("com.mysql.jdbc.Driver");
		con  = DriverManager.getConnection("jdbc:mysql://localhost/banking", "root", "root");
		ps = con.prepareStatement("select Accno from customer where Accno="+accRec+""); 
		//System.out.println("before result set");
	   ResultSet rs=ps.executeQuery();
	  // System.out.println("after result set");
	    a=rs.next();	
	 //  System.out.println(a);
	    ps = con.prepareStatement("select Amount from customer where Accno="+accnoSend+""); 
	    rs=ps.executeQuery();
	    while(rs.next())
	    {
	    double amt=rs.getDouble(1);
	  
	    if(amount<amt)
	    {
	    	b=true;
	    }
	    }
	   
	    if(a==true && b==true)
	    	return true;
	    else
	    	return false;
	}
	public static void send(int accnoSend,int accRec,double amount) throws ClassNotFoundException, SQLException
	{
		double amtReceiver=0;
		double amtSender=0;
	//	String name="";
		Class.forName("com.mysql.jdbc.Driver");
		con  = DriverManager.getConnection("jdbc:mysql://localhost/banking", "root", "root");
		
		ps = con.prepareStatement("select Amount from customer where Accno="+accRec+""); 
	   ResultSet rs=ps.executeQuery();
	   while(rs.next())
	   {
	        amtReceiver=rs.getDouble(1);
	   }
		ps = con.prepareStatement("select Amount from customer where Accno="+accnoSend+""); 
	    rs=ps.executeQuery();
	    while(rs.next())
	    {
	    	amtSender=rs.getDouble(1);
	   	}
	    amtSender-=amount;
	    amtReceiver+=amount;
	    ps=con.prepareStatement("insert into transaction(accno,date,to_From,amount) values(?,?,?,?)");
	    ps.setInt(1, accnoSend);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String date = simpleDateFormat.format(new Date());
		ps.setString(2, date);
		ps.setInt(3, accRec);
		amount=-amount;
		ps.setDouble(4, amount);
		ps.executeUpdate();
	//	System.out.println(date);
		ps=con.prepareStatement("insert into transaction(accno,date,to_From,amount) values(?,?,?,?)");
	    ps.setInt(1, accRec);
		//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
	//	String date = simpleDateFormat.format(new Date());
		ps.setString(2, date);
		ps.setInt(3, accnoSend);
		amount=-amount;
		ps.setDouble(4, amount);
		ps.executeUpdate();
		
	    ps = con.prepareStatement("update customer set Amount="+amtSender+" where accno="+accnoSend+"");
	    ps.executeUpdate();
	    
	    ps = con.prepareStatement("update customer set Amount="+amtReceiver+" where accno="+accRec+"");
	    ps.executeUpdate();
	    System.out.println("done");
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//chkpass(6,"param123");
		chk(1,3,10);
		send(1,3,100);
		
	}

}
