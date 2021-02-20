<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.io.PrintWriter" %>
<%@page import="java.sql.PreparedStatement" %>
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
        
        <form action="UpdateServ" method="POST">
      <div class="menu">
       <p class="head2">
           Fill required fields 
          
            <div>
       
            Enter New Email Id
            </div>
            <div>
                <input type="email" placeholder="hint'456@kbank.com'" class="input1" name="emailnew"/>
            </div>
            <p></p>  
            <div>
                Enter Current Password 
                </div>
                <div>
                    <input type="password" placeholder="Enter Password" class="input1" name="pass"/>
                </div>
                <p></p>      
                  <input type="submit" class="button1" value="Proceed"/>
             
               <%
           
        //    String emailnew="";
//            String emailnew=request.getParameter("emailnew");
         //   System.out.println(emailnew);
      //      String pass="-";
//           String pass=request.getParameter("pass");
       /*   if(pass.equals(pass1))
          {
        	  PreparedStatement ps = con.prepareStatement("update customer set email='"+emailnew+"' where accno="+accno+"");
          	ps.executeUpdate();
        
          response.sendRedirect("update1.html");
          }
          else
          {
              out.println("Incorrect Password");
          }
         
       /* 	  String  emailnew=request.getParameter("emailnew");
        	  System.out.println(emailnew);
          String a="Test";String b="hello@rty";
        	  if(emailnew.equals(b))
        	  {
        		  
        		 
        		  System.out.println("Its equal");
        	  }
        	  else
        		  System.out.println("Not equal");*/
        		//  System.out.println(emailol);
        		  //String pass=request.getParameter("pass");
 /*       		  if(pass.equals(pass1))
        		  {
        			  System.out.println("hi");
        		  }
        		  else
        			  System.out.println("hello");
        		  
       /*    if(request.getParameter("emailold").equals(emailol))
           {
        	   System.out.println("Hello");
           }
           else
           {
        	   System.out.println("Not Equal");
           }
     /*       {
               ResultSet r=st.executeQuery("select pass from customer where accno="+accno+" and pass='"+pass+"'");
                while(r.next())
                {
                    pass1=r.getString(1);
                }
                if(pass.equals(pass1))
                {
                	PreparedStatement ps = con.prepareStatement("update customer set email='"+emailnew+"' where accno="+accno+"");
                	ps.executeUpdate();
              
                response.sendRedirect("update1.html");
                }
                else
                {
                    out.println("Incorrect Password");
                }
            }*/
            %>
              
            <!--     <input type="submit" value="Proceed"/>-->
                </div>
            </form> 
       
           
            
            
   
        </body>
        </html>