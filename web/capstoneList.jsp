<%-- 
    Document   : admin
    Created on : Mar 1, 2022, 8:29:12 PM
    Author     : hd
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Capstone list</title>
    </head>
    <body>
        <!--your code here-->
        <c:set var="result"  value="${sessionScope.RESULT}"/>
        <c:if test="${not empty result}">
            <c:set var="fullName" value="${result.fullName}"/>
            <c:if test="${not empty fullName}">
                Welcome, ${fullName}
            </c:if>
        </c:if>
        <form action="MainController">
            <input type="submit" value="Logout" name="action" />
        </form>
        <form action="MainController">
            Search <input type="text" name="txtSearchValue" value="${param.txtSearchValue}" />
            <input type="submit" value="Search" name="action" />
        </form>
        <c:set var="searchValue" value="${param.txtSearchValue}"/>
            <c:if test="${not empty searchValue}">
                <c:set var="listDtoResult" value="${requestScope.LISTDTORESULT}"/>
                <c:if test="${not empty listDtoResult}">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>ID</th>
                                <th>Description</th>
                                <th>userID</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="dto" items="${listDtoResult}" varStatus="counter">
                                <tr>
                                    <td>
                                        ${counter.count}
                                    </td>
                                    <td>
                                        ${dto.id}
                                    </td>
                                    <td>
                                        ${dto.description}
                                    </td>
                                    <td>
                                        ${dto.userID}
                                    </td>
                                    <td>
                                        <c:url var="urlRewrriting" value="MainController">
                                            <c:param name="action" value="Delete"/>
                                            <c:param name="txtID" value="${dto.id}"/>
                                            <c:param name="txtSearchValue" value="${searchValue}"/>
                                        </c:url>
                                        <a href="${urlRewrriting}">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>


                </c:if>
                <c:if test="${empty listDtoResult}">
                    <font>No results</font>
                </c:if>
            </c:if>

        </body>
    </html>
