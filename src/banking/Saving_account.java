package banking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Saving_account
 */
@WebServlet("/Saving_account")
public class Saving_account extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Saving_account() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		//res.getWriter().append("Served at: ").append(req.getContextPath());
		PrintWriter out=res.getWriter();
		String name=req.getParameter("name").toString();
		String pin=req.getParameter("pin").toString();
		String phone=req.getParameter("phone").toString();
		String email=req.getParameter("email").toString();
		String pan=req.getParameter("pan").toString();
		String id=req.getParameter("id").toString();
		String mob=pin+" "+phone;
		String type="Saving Account";
		String msg="";
//		String pass=null;
		String pass=req.getParameter("pass").toString();
//		System.out.println(pass);
		String pass1=req.getParameter("pass1").toString();
		if(pass.isBlank())
		{
			out.println("Enter Password");
			RequestDispatcher rs=req.getRequestDispatcher("savingacc.html");
			rs.include(req, res);
		}
		
		
		else if(pass.equals(pass1))
		{
			main1 m=new main1();
			try {
				msg=m.savedataS(type, name, mob, email, pan, id, pass);
				if(msg.equals("save"))
				{
				res.sendRedirect("savingacc1.jsp"); 
				}
				} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		else if(pass.equals(pass1)==false)
		{
			out.println("Password Mismatch");
			RequestDispatcher rs=req.getRequestDispatcher("savingacc.html");
			rs.include(req, res);
		}
		else if(name.isBlank()||pin.isBlank()||phone.isBlank()||email.isBlank()||pan.isBlank()||id.isBlank())
		{
			out.println("Empty Fields");
			RequestDispatcher rs=req.getRequestDispatcher("savingacc.html");
			rs.include(req, res);
		}
//		if(pass!=pass1||pass==null)
//		{
//			
////			res.sendRedirect("savingacc.html");
////			out.println("Both passwords are not same");
//			out.println("Both passwords are not same");
//			RequestDispatcher rs=req.getRequestDispatcher("savingacc.html");
//			rs.include(req, res);
//		}
//		else
//		{
//			res.sendRedirect("savingacc1.html");
//		}
	res.getWriter().append(msg);
	}
		


	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(req,res);
	}
}
