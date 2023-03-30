<%-- 
    Document   : EmpForm
    Created on : 20-Jan-2023, 11:40:49 AM
    Author     : root
--%>
<jsp:useBean id="emp" class="beans.Employee" scope="request"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
       <form action="Third.jsp" method="POST">
            <table width="50%">  
                <tr><td>     First Name</td> <td> <input type="text" name="firstName" value="<%=emp.getFirstName()%>"></td><td style="color:red"><%=emp.getError("firstName")%> </td></tr>
           <tr><td>     Last Name :</td> <td> <input type="text" name="lastName" value="<%=emp.getLastName()%>"></td><td style="color:red"> <%=emp.getError("lastName")%> </td></tr>
           <tr><td> Salary :</td> <td> <input type="text" name="salary" value="<%=emp.getSalary()%>"></td><td></td></tr>
            <tr><td></td> <td><input type="submit" name="submit" value="Submit"></td><td></td></tr>
            </table>  
            
        </form>
    </center>
    </body>
</html>
