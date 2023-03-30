<%-- 
    Document   : Third
    Created on : 20-Jan-2023, 11:00:30 AM
    Author     : root
--%>
<jsp:useBean id="emp" class="beans.Employee" scope="request">
    <jsp:setProperty name="emp" property="*"/> 
</jsp:useBean>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>I am the Third JSP</h1>
        
        <%
            if(emp.validate())

            {
            %>
        
        
        
        <br/> First Name : <jsp:getProperty name="emp" property="firstName"/>
       <br/> Last Name : <jsp:getProperty name="emp" property="lastName"/>
       <br/> Salary : <jsp:getProperty name="emp" property="salary"/>
       <%
           }
else {
           
           %>
           <jsp:forward page="EmpForm.jsp"/>
          
           <%
               }
%>
        
    </body>
</html>
