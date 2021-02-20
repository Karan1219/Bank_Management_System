<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.Statement" %>
<%@page import="javax.servlet.http.HttpServlet" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
        <link href="style.css" rel="stylesheet" type="text/css" >
<title>Insert title here</title>
</head>
<body class="body1">
        <div class="head1" >
                <a href="index.html" class="title" > KAY'S BANK</a>
        </div>
        <div class="menu" >
            <p class="head2">
            Account No. is :
            <%
           session = request.getSession();
           int accno=(int)session.getAttribute("accno");
	       // <!-- int accno = Integer.parseInt(a); -->
            Class.forName("com.mysql.jdbc.Driver");
         // <!--   String t="Current Account"; -->
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost/banking", "root", "root");
            Statement st = con.createStatement();
            ResultSet rs=st.executeQuery("select * from customer where accno="+accno+"");//order by desc limit 1
            while(rs.next())
            {
            	 %> 
                <%=rs.getString(2) %>
                
                </p>
                <table id="tableview">
                     <tr>
                        <td class="tdcol">
                            Type
                        </td>
                        <td class="tdcol">
                            <%=rs.getString(1) %>
                        </td>
                    </tr>
                     <tr>
                        <td class="tdcol">
                            Name
                        </td>
                        <td class="tdcol">
                            <%=rs.getString(3) %>
                        </td>
                    </tr>
                     <tr>
                        <td class="tdcol">
                           Phone No.
                        </td>
                        <td class="tdcol">
                            <%=rs.getString(8) %>
                        </td>
                    </tr>
                     <tr>
                        <td class="tdcol">
                            Email
                        </td>
                        <td class="tdcol">
                            <%=rs.getString(9) %>
                        </td>
                    </tr>
                     <tr>
                        <td class="tdcol">
                            GSTN
                        </td>
                        <td class="tdcol">
                            <%=rs.getString(5) %>
                        </td>
                    </tr>
                     <tr>
                        <td class="tdcol">
                          Residence Proof
                        </td>
                        <td class="tdcol">
                            <%=rs.getString(7) %>
                        </td>
                    </tr>
                     <tr>
                        <td class="tdcol">
                            PAN
                        </td>
                        <td class="tdcol">
                            <%=rs.getString(4) %>
                        </td>
                    </tr>
                     <tr>
                        <td class="tdcol">
                          ID Proof
                        </td>
                        <td class="tdcol">
                            <%=rs.getString(6) %>
                        </td>
                    </tr>
                     <tr>
                        <td class="tdcol">
                            Amount
                        </td>
                        <td class="tdcol">
                           Rs <%=rs.getString(10) %>
                        </td>
                    </tr>
                </table>
       <% } %>
       <p>
             <a href="transStatement.jsp" class="link2">Want to see your Recent Transaction?</a>
  		</p>
  		 <footer class="footer1">
            <a href="index.html" class="logout" >  Log Out</a>
        </footer>
  </div>
  </body>
  </html>
  