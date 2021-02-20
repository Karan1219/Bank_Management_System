<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.Statement" %>
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
            Your Account No. is :
            <%
            Class.forName("com.mysql.jdbc.Driver");
    		String t="Saving Account";
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost/banking", "root", "root");
            Statement st = con.createStatement();
            ResultSet rs=st.executeQuery("select * from customer where Type='"+t+"'order by Accno desc limit 1");//order by desc limit 1
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
                            <%=rs.getString(10) %>
                        </td>
                    </tr>
                </table>
       <% } %>
       <footer class="footer1">
            <a href="login.html" class="logout" >  Log In</a>
        </footer>
     
  </div>
  </body>
  </html>
  