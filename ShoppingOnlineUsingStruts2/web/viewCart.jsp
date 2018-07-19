<%-- 
    Document   : viewCart
    Created on : Jul 16, 2018, 1:44:42 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View</title>
    </head>
    <body>
        <h1>Your Cart Items Include</h1>

        <s:if test="%{#session.CART != null}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Mobile Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <s:form action="removeCart" theme="simple">
                        <s:iterator value="%{#session.CART.items}" status="counter">
                            <tr>
                                <td>
                                    <s:property value="%{#counter.count}"/>
                                </td>
                                <td>
                                    <s:property value="key.mobileName"/>
                                </td>
                                <td>
                                    <s:property value="value"/>
                                </td>
                                <td>
                                    <s:property value="key.price"/>
                                </td>
                                <td>
                                    <s:checkbox name="selectedItem"
                                                fieldValue="%{key.mobileId}"/>
                                </td>
                            </tr>
                        </s:iterator>
                            <tr>
                                <td colspan="4">
                                    <s:a href="addMore">Add More Item To Cart</s:a>
                                </td>
                                <td>
                                <s:submit value="Remove Selected Items"/>
                                </td>
                            </tr>

                    </s:form>
                </tbody>
            </table>

        </s:if>
        <s:if test="%{#session.CART == null}">
            <h2>No cart exsited !!!</h2>
        </s:if>
    </body>
</html>
