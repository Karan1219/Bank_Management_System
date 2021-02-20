<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.Statement" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
    <head>
            <link href="style.css" rel="stylesheet" type="text/css" >

        <title>

        </title>
    </head>
    <body class="body1">
        <div class="head1" >
                <a href="index.html" class="title" > KAY'S BANK</a>
        </div>
        <div class="menu" style="border-bottom: 0px " >
            <p class="head3">
            Total Balance in your account 
            </p>
            <%
            session = request.getSession();
            int accno=(int)session.getAttribute("accno");
              Class.forName("com.mysql.jdbc.Driver");
              Connection con  = DriverManager.getConnection("jdbc:mysql://localhost/banking", "root", "root");
              Statement st = con.createStatement();
              ResultSet rs=st.executeQuery("select Amount from customer where accno="+accno+"");
              while(rs.next())
              {
                   %> 
                  <p class="amount">
                  Rs
                  <%=rs.getString(1) %>
                  <p>
                  <% } %>
                  <p>
                  <a href="transaction1.html" class="link1">Send money to someone? </a>
                  </p>
        </div>
         <footer class="footer1">
            <a href="index.html" class="logout" >  Log Out</a>
        </footer>
</body>
</html>
