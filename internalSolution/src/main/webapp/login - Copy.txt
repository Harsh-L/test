<%-- 
    Document   : login
    Created on : 06-Apr-2023, 8:25:31 PM
    Author     : ritesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <div>
            <form action="Login" method="POST">
                <div>
                    <input name="userid" placeholder="enter userid"/>
                </div>
                <div>
                    <% if(request.getAttribute("error")!=null){
                    %>
                    <p style="color:red"><%=request.getAttribute("error")%></p>
                    <%
                        }%>
                </div>
                <div>
                    <input type="submit" name="loginBtn" value="login"/>
                </div>
            </form>   
        </div>
    </body>
</html>
