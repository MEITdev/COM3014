<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome page (User Logged in)</h1>
        Username: <b>${principal.name}</b>!<br/>
        <c:url value="/admin/users" var="admin" />
        <a href="${admin}" >Admin page</a>
        <form action="logout" method="post">
            <input type="submit" value="Logout"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>   
        </form>
        
        
        <table>
			<caption>Your squad</caption>

			<thead>
				<tr>
					<th>Forename</th>
                                        <th>Surname</th>
					<th>Etc</th>
                                        <th>Update</th>
                                        <th>Delete</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${players}" var="player">
					<tr>
						<td>${player.forename}</td>
						<td>${player.surname}</td>
						<td></td>
                                                
                                                <c:url value="/players/${player.id}/upgrade/" var="updateplayer" />
                                                <td><a class="button" href="${updateplayer}">Upgrade</a></td>
                                                
                                                <c:url value="/players/${player.id}/switch/" var="switchplayer" />
                                                <td><a class="button" href="${switchplayer}">Switch</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
        
        
        
        
         
    </body>
</html>
