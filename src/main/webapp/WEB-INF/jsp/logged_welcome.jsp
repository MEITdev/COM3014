<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    </body>
</html>
