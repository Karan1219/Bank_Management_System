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
 * Servlet implementation class UpdateServ1
 */
@WebServlet("/UpdateServ1")
public class UpdateServ1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServ1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter ou=response.getWriter();
		 String passnew=request.getParameter("passnew");
		 String passnew1=request.getParameter("passnew1");
				 
	     String pass=request.getParameter("pass");
	     HttpSession session=request.getSession();
	     int accno=(int)session.getAttribute("accno");
	     Update u=new Update();
	     if(passnew.equals(passnew1))
	     {
	     try {
			if(u.updatePass(passnew, passnew1, pass, accno))
			 	{
				 response.sendRedirect("updateSuccess.html");
				 }
				 else
				 { 	ou.println("Incorrect password");
					 RequestDispatcher rs=request.getRequestDispatcher("updatePass.html");
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
	     else
	     {
	    	 ou.println("Password Mismatch");
			 RequestDispatcher rs=request.getRequestDispatcher("updatePass.html");
				rs.include(request, response);
	     }
	}

}
