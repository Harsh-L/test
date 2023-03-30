<%-- 
    Document   : Sample
    Created on : 19-Jan-2023, 12:03:08 PM
    Author     : root
--%>

<%@page contentType="text/html" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include  file="Another.jsp" %>
          
        <c:out value="I am using out tag in JSTL"/>
        
        
        <h1>Hello World of JSP!<br/><!-- comment -->
            <%!
                String fname;
                String lname;
                
                
                %>
                
                
                <%
                    fname = request.getParameter("fname");
                    lname = request.getParameter("lname");
                    
                    out.println("<h3>Full Name : "+ fname+ " "+ lname+"<br/>");
                    
                    
                    for(int i=0; i<10; i++)
                    {
                    
                     out.println("The value of i is :"+i+"<br/>");
                
                    
                        }
                    
                    
                    
                    
                    %>
            
                 
            
        The date today is <%=new Date().toString()%>
        
        
        
        
        
        </h1>
        
        
    </body>
</html>
