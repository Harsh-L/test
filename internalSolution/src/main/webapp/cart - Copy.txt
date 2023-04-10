<%-- 
    Document   : cart
    Created on : 10-Apr-2023, 10:42:24 AM
    Author     : ritesh
--%>

<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.List"%>
<%@page import="ejb.CartItem"%>
<%@page import="ejb.CartBeanLocal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!
//    BusinessLogicLocal logic;
//    List<Product> products = new ArrayList<>();
    CartBeanLocal cart;
    List<CartItem> cartItems;

    public void jspInit() {
        try {
            InitialContext context = new InitialContext();
            cart = (CartBeanLocal) context.lookup("java:module/CartBean");
            System.out.println("className.methodName()");
        } catch (Exception ex) {
            System.err.println("[index.jsp], Exception: ");
            ex.printStackTrace();
        }
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
    </head>
    <body>
        <%if (session != null) {
                if (session.getAttribute("username") != null) {
        %>
        <%
            cartItems = cart.getCartItems();
        %>
        <% if (cartItems.size() > 0) {
        %>
        <form action="ConfirmOrder" method="POST">
            <table>
                <tr>
                    <th>product name</th>
                    <th>price</th>
                    <th>discount</th>
                    <th>quantity</th>
                    <th>total</th>

                </tr>
                <% for (CartItem c : cartItems) {
                %>
                <tr>
                    <td><%= c.getItemname()%></td>
                    <td><%= c.getPrice()%></td>
                    <td><%= c.getProductid()%></td>
                    <td><%= c.getPrice()%></td>
                    <td><%= c.getQuantity()%></td>
                </tr>
                <%
                    }
                %>
            </table>
            <input type="submit" name="btnConfirmOrder" value="Confirm Order"/>
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
