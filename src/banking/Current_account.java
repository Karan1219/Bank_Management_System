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
 * Servlet implementation class Current_account
 */
@WebServlet("/Current_account")
public class Current_account extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Current_account() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=res.getWriter();
		String name=req.getParameter("name");
		String pin=req.getParameter("pin");
		String phone=req.getParameter("phone");
		String email=req.getParameter("email");
		String gstn=req.getParameter("gstn");
		String regid=req.getParameter("id");
		String mob=pin+" "+phone;
		String type="Current Account";
		String msg="";
		String pass=req.getParameter("pass").toString();
		
		String pass1=req.getParameter("pass1").toString();
		if(pass.isBlank())
		{
			out.println("Both passwords are not same");
			RequestDispatcher rs=req.getRequestDispatcher("currentacc.html");
			rs.include(req, res);
		}
		
		else if(pass.equals(pass1))
		{
			main1 m=new main1();
			try {
				msg=m.savedataC(type, name, mob, email, gstn, regid, pass);
				if(msg.equals("save"))
				{
				res.sendRedirect("currentacc1.jsp"); 
				}
				} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		else
		{
			out.println("Both passwords are not same");
			RequestDispatcher rs=req.getRequestDispatcher("currentacc.html");
			rs.include(req, res);
		}
		res.getWriter().append(msg);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,res);
	
	}

}
