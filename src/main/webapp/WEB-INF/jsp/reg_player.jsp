<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Footballs</title>
        
        <c:choose>
            <c:when test="${edit}">
                <!-- Bootstrap -->
        <link href="../../resources/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="../../resources/css/font-awesome.css" rel="stylesheet">
        <!-- NProgress -->
        <link href="../../resources/css/nprogress.css" rel="stylesheet">
        <!-- iCheck -->
        <link href="../../resources/css/green.css" rel="stylesheet">
        <!-- bootstrap-progressbar -->
        <link href="../../resources/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
        <!-- JQVMap -->
        <link href="../../resources/css/jqvmap.min.css" rel="stylesheet"/>

        <!-- Custom Theme Style -->
        <link href="../../resources/css/custom.min.css" rel="stylesheet">
            </c:when>
            <c:otherwise>
                <!-- Bootstrap -->
        <link href="../resources/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="../resources/css/font-awesome.css" rel="stylesheet">
        <!-- NProgress -->
        <link href="../resources/css/nprogress.css" rel="stylesheet">
        <!-- iCheck -->
        <link href="../resources/css/green.css" rel="stylesheet">
        <!-- bootstrap-progressbar -->
        <link href="../resources/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
        <!-- JQVMap -->
        <link href="../resources/css/jqvmap.min.css" rel="stylesheet"/>

        <!-- Custom Theme Style -->
        <link href="../resources/css/custom.min.css" rel="stylesheet">
            </c:otherwise>
        </c:choose>
        
    </head>
    <body class="nav-md">
        <div class="container body">
            <div class="main_container">
                <div class="col-md-3 left_col">
                    <div class="left_col scroll-view">         
                         <%@ include file="/WEB-INF/jspf/sidebar.jspf"%>
                    </div>
                </div>
                      


                <!-- page content -->
                <div class="right_col" role="main">
                    <div class="">

                        <div class="clearfix"></div>
                        <c:choose>
                            <c:when test="${edit}">
                                <h2>Edit User</h2>
                            </c:when>
                            <c:otherwise>
                                <h2>Add User</h2>
                            </c:otherwise>
                        </c:choose>
                        
                            
                            ${message}
                            <form:form method="POST" modelAttribute="player">
                                <form:input type="hidden" path="id" id="id"/>
                                <table>
                                    <tr>
                                        <td><label for="forename">Forename: </label> </td>
                                        <td><form:input path="forename" id="forename" /></td>
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
                                        <td><label for="offense">Offence: </label> </td>
                                        <td><form:input path="offense" id="offense"/></td>
                                        <td><form:errors path="offense" cssClass="error"/></td>
                                    </tr>
                                    <tr>
                                        <td><label for="defense">Defence: </label> </td>
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
                                Go back to <a href="<c:url value='/admin/players' />">List of All Players</a>
                          </div>
                </div>
                <%@ include file="/WEB-INF/jspf/footer.jspf"%>
            </div>
        </div>
        
            <c:choose>
            <c:when test="${edit}">
                <!-- jQuery -->
        <script src="../../resources/js/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="../../resources/js/bootstrap.min.js"></script>
        <!-- bootstrap-progressbar -->
        <script src="../../resources/js/bootstrap-progressbar.min.js"></script>
        <!-- Skycons -->
        <script src="../../resources/js/skycons.js"></script>
        <!-- Custom Theme Scripts -->
        <script src="../../resources/js/custom.min.js"></script>
            </c:when>
            <c:otherwise>
                <!-- jQuery -->
        <script src="../resources/js/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="../resources/js/bootstrap.min.js"></script>
        <!-- bootstrap-progressbar -->
        <script src="../resources/js/bootstrap-progressbar.min.js"></script>
        <!-- Skycons -->
        <script src="../resources/js/skycons.js"></script>
        <!-- Custom Theme Scripts -->
        <script src="../resources/js/custom.min.js"></script>
            </c:otherwise>
        </c:choose>
        
    </body>
</html>
