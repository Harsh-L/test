<%-- 
    Document   : items
    Created on : 03-Apr-2023, 8:44:49 AM
    Author     : ritesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
                <th>product name</th>
                <th>category</th>
                <th>price</th>
                <th>quantity</th>
            </tr>
            <form action="handleSubmit">
                <tr>
                    <th> <input name="checkedItems" type="checkbox" value="1" /> </th>
                    <th>Parle G</th>
                    <th>snack</th>
                    <th>12</th>
                    <th> <input type="number" name="qty1" placeholder="enter quantity" /> </th>
                </tr>
                <tr>
                    <th> <input name="checkedItems" type="checkbox" value="2" /> </th>
                    <th>himalaya shampoo</th>
                    <th>cosmetics</th>
                    <th>189</th>
                    <th> <input type="number" name="qty2" placeholder="enter quantity" /> </th>
                </tr>
                <tr>
                    <th> <input name="checkedItems" type="checkbox" value="3" /> </th>
                    <th>Kaju Fine 1KG</th>
                    <th>dry fruit</th>
                    <th>1250</th>
                    <th> <input type="number" name="qty3" placeholder="enter quantity" /> </th>
                </tr>
                <input type="submit" name="btnSubmit" value="make bill"/>
            </form>

        </table>
    </body>
</html>
