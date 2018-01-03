<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- 
    Document   : listusers
    Created on : 30-Dec-2017, 09:07:28
    Author     : Black
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>All Users</h1>
         <c:if test="${param.message != null}">
            <div>
                 ${param.message}.
            </div>
        </c:if>
       
        <div>
		<table>
			<caption>List of all users</caption>

			<thead>
				<tr>
					<th>Username</th>
                                        <th>Password</th>
					<th>Email</th>
					<th>Enabled</th>
                                        <th>Budget</th>
                                        <th>Team Name</th>
                                        <th>Is User</th>
                                        <th>Is Premium</th>
                                        <th>Is Admin</th>
                                        <th>Update</th>
                                        <th>Delete</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.username}</td>
						<td>${user.password}</td>
						<td>${user.email}</td>
                                                <td>${user.enabled}</td>
                                                <td>${user.budget}</td>
                                                <td>${user.teamName}</td>
                                                <td>${user.roleStringHolder.isUser}</td>
                                                <td>${user.roleStringHolder.isPremium}</td>
                                                <td>${user.roleStringHolder.isAdmin}</td>
                                                ¨
                                                <c:url value="/admin/users/${user.username}/update/" var="updateuser" />
                                                <td><a class="button" href="${updateuser}">Update</a></td>
                                                
                                                <c:url value="/admin/users/delete/" var="deleteuser" />
                                                
                                               
                                                
                                                
                                                
                                                <td> <form action="${deleteuser}" method="post">
                                                    <input type="hidden" id="username" name="username" value="${user.username}" />
                                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                                    <button type="submit">Delete</button>
                                                </form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
    <c:url value="/admin/users/add" var="addUserPath" />
	<a class="button" href="${addUserPath}">Add User</a>
    </body>
</html>
