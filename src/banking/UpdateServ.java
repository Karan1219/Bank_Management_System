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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateServ
 */
@WebServlet("/UpdateServ")
public class UpdateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter ou=response.getWriter();
		String pin=request.getParameter("pin");
		 String phonenew=request.getParameter("phonenew");
		 phonenew=pin+" "+phonenew;
	     String pass=request.getParameter("pass");
	     HttpSession session=request.getSession();
	     int accno=(int)session.getAttribute("accno");
	     Update u=new Update();
	     try {
			if(u.updatePhone(phonenew,pass,accno))
			 {
				 response.sendRedirect("updateSuccess.html");
			 }
			 else
			 { 	ou.println("Incorrect password");
				 RequestDispatcher rs=request.getRequestDispatcher("updatePhone.html");
					rs.include(request, response);
			 }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter ou=response.getWriter();
		 String emailnew=request.getParameter("emailnew");
		 
	     String pass=request.getParameter("pass");
	     HttpSession session=request.getSession();
	     int accno=(int)session.getAttribute("accno");
	     Update u=new Update();
	     try {
			if(u.updateEmail(emailnew,pass,accno))
			 {
			 response.sendRedirect("updateSuccess.html");
			 
			 }
			 else
			 { 	ou.println("Incorrect password");
				 RequestDispatcher rs=request.getRequestDispatcher("updateEmail.html");
					rs.include(request, response);
			 }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }

}
