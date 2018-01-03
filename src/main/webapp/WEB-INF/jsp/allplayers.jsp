<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>TEST</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 
<body>
    <h2>List of Players</h2>  
    <table>
        <tr>
            <td>ID</td><td>Forename</td><td></td><td></td><td></td>
        </tr>
        <c:forEach items="${players}" var="player">
            <tr>
            <td>${player.id}</td>
            <td>${player.forename}</td>
            
            <td><a href="<c:url value='/edit-${player.id}-employee' />">${player.id}</a></td>
            
            <td>
                <form action="<c:url value='/player/delete' />" method="delete">
                    <input type="hidden" name="id" value="${player.id}"/>
                    <input type="submit" value="Delete"/>
                </form>
            
            
           </td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <form:form method="DELETE" action="/client/invoices/a"><input type="submit" value="delete"></form:form>

    
    <a href="<c:url value='/new' />">Add New Employee</a>
</body>
</html>