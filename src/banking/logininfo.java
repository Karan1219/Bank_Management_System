package banking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class logininfo
 */
@WebServlet("/logininfo")
public class logininfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logininfo() {
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
		PrintWriter out=response.getWriter();
		int accno=Integer.parseInt(request.getParameter("acc"));
		String pass=request.getParameter("Password");
		
		if(main1.Chk(accno,pass))
		{
			 HttpSession session = request.getSession();
	           session.setAttribute("accno", accno);
	      //     session.setAttribute("username", accno);
			response.sendRedirect("login1.html");
		}
		else
		{
//			out.println("Incorrect id or password");
			RequestDispatcher rs=request.getRequestDispatcher("login.html");
			rs.include(request, response);
		}
	}

}
