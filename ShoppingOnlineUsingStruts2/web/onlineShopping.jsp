<%-- 
    Document   : onlineShopping
    Created on : Jul 16, 2018, 12:56:21 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ABC Store</title>
    </head>
    <body>
        <h1>ABC Store</h1>
        <s:form action="addToCart">
            <s:select name="item" list="itemList" label="Choose Item"/>
            <s:submit value="Add Selected Item to Your Cart"/>
        </s:form><br/>
        <s:a href="viewCart">View Cart</s:a>
    </body>
</html>
