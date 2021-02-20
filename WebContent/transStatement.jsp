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
        <div class="head1">
                <a href="index.html" class="title" > KAY'S BANK</a>
        </div>
        <div class="menu" >
                <p class="head2">
                Transaction Details
                </p>
               
                <%
                String name="";
                session = request.getSession();
                  int accno=(int)session.getAttribute("accno");
	       
               Class.forName("com.mysql.jdbc.Driver");
              
		    	Connection con  = DriverManager.getConnection("jdbc:mysql://localhost/banking", "root", "root");
               Statement st = con.createStatement();
               ResultSet rs=st.executeQuery("select * from transaction where accno="+accno+"");
                %>  <table id="tableview" style="margin-left: 37%" >
               <tr>
                       <td class="tdcol1">
                            Transaction_Date
                       </td>
                       <td class="tdcol1">   
                            From/To
                            <br>
                            Account No.
                        </td>
                       
                        <td class="tdcol1">
                           Amount
                        </td>
                     </tr>
                  
         <%
               while(rs.next())
               {
                 %> 
        
                        <tr>
                           <td class="tdcol1">
                                 <%=rs.getString(3) %>
                           </td>
                           <td class="tdcol1">   
                                <%=rs.getString(4) %>
                            </td>
                            
                            <td class="tdcol1">
                                <%
                                if(Double.parseDouble(rs.getString(5))<=0)
                                {
                                    %>
                                    <%=rs.getString(5) %>
                                    <%
                                }
                                else
                                {
                                    %>
                                    +<%=rs.getString(5) %>
                                    <%
                                }
                                   
                                %>
                            </td>
                            
                         </tr>
              
                <p></p>
                <%} %>
                </table>
        </div>
       
</body>
</html>
