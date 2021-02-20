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
 * Servlet implementation class Transaction
 */
@WebServlet("/Transaction")
public class Transaction extends HttpServlet {
	//int ac=0;
	//double amtt=0;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transaction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		int ac=Integer.parseInt(request.getParameter("acc"));
		 double amtt=Double.parseDouble(request.getParameter("amt"));
		 HttpSession session = request.getSession();
		 session.setAttribute("accRec", ac);
		session.setAttribute("amt", amtt);
		response.sendRedirect("password1.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String pass=request.getParameter("password");
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
        int accno=(int)session.getAttribute("accno");
	//	int ac=Integer.parseInt(request.getParameter("acc"));
	//	double amtt=Double.parseDouble(request.getParameter("amt"));
		int acc=(int)session.getAttribute("accRec");
		double amt=(double)session.getAttribute("amt");
		
		//response.sendRedirect("password1.html");
		
		
			try {
				if(Sendmoney.chkpass(accno, pass))
				{
					if(Sendmoney.chk(accno,acc, amt))
					{
						Sendmoney.send(accno,acc,amt);
						response.sendRedirect("transSuccessful.html");
					}
			    	else
				    {
					    out.println("Insufficient Balance OR Entered Incorrect Account No.");
					    RequestDispatcher rs=request.getRequestDispatcher("transaction1.html");
					    rs.include(request, response);
				    }
				}
				else
				{
					out.println("Incorrect Password  \n TRY AGAIN");//OR Insufficient Balance OR Entered Incorrect Account No.
					RequestDispatcher rs=request.getRequestDispatcher("transaction1.html");
					rs.include(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}

}
