<%-- 
    Document   : Another
    Created on : 20-Jan-2023, 10:51:38 AM
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
        <hr/>
        <h1> Page Header Content</h1>
        <%--
        <jsp:include page="Third.jsp">
            <jsp:param name="username" value="Narendra"/>
        </jsp:include>
        --%>
        <jsp:setProperty name="emp" property="firstName" value="Narendra"/>
        <jsp:setProperty name="emp" property="lastName" value="Patel"/>
        <jsp:setProperty name="emp" property="salary" value="4500.00"/>
        
       
        <jsp:forward page="Third.jsp">
            <jsp:param name="username" value="Narendra"/>
        </jsp:forward>
        
        <hr/>
    </body>
</html>
