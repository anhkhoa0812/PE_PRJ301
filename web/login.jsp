<%-- 
    Document   : login
    Created on : 113
    Author     : hd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <!--your code here-->
        <form action="MainController" method="POST">
            Enter UserID <input type="text" name="txtUserID" value="" /><br>
            Enter Password <input type="password" name="txtPassword" value="" /><br>
            <input type="submit" value="Login" name="action" />
        </form>
        <c:set var="error" value="${requestScope.ERROR}" />
        <c:if test="${not empty error.incorrectErr}">
            <font color="red">${error.incorrectErr}</font>
        </c:if>
        </body>

    </html>

