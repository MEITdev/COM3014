<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Player Registration Form</title>
 
<style>
 
    .error {
        color: #ff0000;
    }
</style>
 
</head>
 
<body>
 
    <h2>Registration Form</h2>
  
    <form:form method="POST" modelAttribute="player">
        <form:input type="hidden" path="id" id="id"/>
        <table>
            <tr>
                <td><label for="forename">Forename: </label> </td>
                <td><form:input path="forename" id="forename"/></td>
                <td><form:errors path="forename" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="surname">Surname: </label> </td>
                <td><form:input path="surname" id="surname"/></td>
                <td><form:errors path="surname" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="salary">Salary: </label> </td>
                <td><form:input path="salary" id="salary"/></td>
                <td><form:errors path="salary" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="age">Age: </label> </td>
                <td><form:input path="age" id="age"/></td>
                <td><form:errors path="age" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="offense">Offense: </label> </td>
                <td><form:input path="offense" id="offense"/></td>
                <td><form:errors path="offense" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label for="defense">Defense: </label> </td>
                <td><form:input path="defense" id="defense"/></td>
                <td><form:errors path="defense" cssClass="error"/></td>
            </tr>
            
     
            <tr>
                <td colspan="3">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Register"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
    Go back to <a href="<c:url value='/players' />">List of All Players</a>
</body>
</html>