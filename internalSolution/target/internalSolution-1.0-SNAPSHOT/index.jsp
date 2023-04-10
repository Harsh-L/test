<%-- 
    Document   : index
    Created on : 06-Apr-2023, 8:25:40 PM
    Author     : ritesh
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entity.Product"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="ejb.BusinessLogic"%>
<%@page import="ejb.BusinessLogicLocal"%>
<%@page import="javax.ejb.EJB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    BusinessLogicLocal logic;
    List<Product> products = new ArrayList<>();

    public void jspInit() {
        try {
            InitialContext context = new InitialContext();
            logic = (BusinessLogicLocal) context.lookup("java:module/BusinessLogic");
            System.out.println("className.methodName()");
        } catch (Exception ex) {
            System.err.println("[index.jsp], Exception: ");
            ex.printStackTrace();
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products Page</title>
    </head>
    <body>
        <%if (session != null) {
                if (session.getAttribute("username") != null) {
        %>
        <%
            products = logic.getProducts();
        %>
        <% if (products.size() > 0) {
        %>
        <form action="PrepareBill" method="POST">
            <table>
                <tr>
                    <th>Add To Cart</th>
                    <th>product name</th>
                    <th>price</th>
                    <th>discount</th>
                    <th>stock</th>
                    <th>Enter Quantity</th>
                </tr>
                <% for (Product p : products) {
                %>
                <tr>
                    <td> <input name="checkedItems" type="checkbox" value="<%= p.getProductid() %>" /> </td>
                    <td><%= p.getProductname()%></td>
                    <td><%= p.getRate()%></td>
                    <td><%= p.getDiscount()%></td>
                    <td><%= p.getStock()%></td>
                    <td> <input type="number" name="qty<%= p.getProductid()%>" placeholder="enter quantity" /> </td>
                </tr>
                <%
                    }
                %>
            </table>
            <input type="submit" name="btnPrepareBill" value="Prepare Bill"/>
        </form>
        <%
        } else {%>
        <p>No Products Found!!</p>
        <%
            }%>
        <%
                } else {%>
        <p>You are not authorized to access this page
            ! click<a href = "login.jsp" > here </a> to login.</p>
                <%
                }
                } else {
                %>
                <p>You are not authorized to access this page! click <a href="login.jsp">here</a> to login.</p>
                <%
            }%>

    </body>
</html>
