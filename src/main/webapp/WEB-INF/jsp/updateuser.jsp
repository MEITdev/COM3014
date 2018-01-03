<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update User</h1>
        ${message}
        <c:url value="/admin/users/${user.username}/update" var="updateuser" />
        <form action="${updateuser}" method="post">
            user: ${user.username} <br>
            <input type="hidden" id="username" name="username" value="${user.username}" /><br>
            <label for="password">Password</label>
            <input type="password" class="form-control" placeholder="Password" id="password" name="password" value="${user.password}" /><br>
            <label for="email">Email</label>
            <input type="email" class="form-control" placeholder="Email" id="email" name="email" value="${user.email}" /><br>
            <label for="budget">Budget</label>
            <input type="budget" class="form-control" placeholder="budget" id="budget" name="budget"  value="${user.budget}" /><br>
            <label for="teamName">Team Name</label>
            <input type="teamName" class="form-control" placeholder="teamName" id="teamName" name="teamName" value="${user.teamName}"  /><br>
            
            <label for="user">User</label>
            <input id="user" name="user" type="checkbox" <c:if test="${user.roleStringHolder.isUser=='yes'}"> checked </c:if> ><br>
            <label for="premium">Premium User</label>
            <input id="premium" name="premium" type="checkbox" <c:if test="${user.roleStringHolder.isPremium=='yes'}"> checked </c:if> ><br>
            <label for="admin">Admin</label>
            <input id="admin" name="admin" type="checkbox" <c:if test="${user.roleStringHolder.isAdmin=='yes'}"> checked </c:if> ><br>
            <label for="admin">Enabled</label>
            <input id="enabled" name="enabled" type="checkbox" <c:if test="${user.enabled=='1'}"> checked </c:if> ><br>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button type="submit">Update User</button>

        </form>
    </body>
</html>
