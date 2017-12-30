<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        
        <!-- Bootstrap -->
        <link href="../../../../resources/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="../../../../resources/css/font-awesome.css" rel="stylesheet">
        <!-- NProgress -->
        <link href="../../../../resources/css/nprogress.css" rel="stylesheet">
        <!-- iCheck -->
        <link href="../../../../resources/css/green.css" rel="stylesheet">
        <!-- bootstrap-progressbar -->
        <link href="../../../../resources/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
        <!-- JQVMap -->
        <link href="../../../../resources/css/jqvmap.min.css" rel="stylesheet"/>

        <!-- Custom Theme Style -->
        <link href="../../../../resources/css/custom.min.css" rel="stylesheet">
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

                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    ${message}
                                    <c:url value="/admin/users/${user.username}/update" var="updateuser" />
                                    <form action="${updateuser}" method="post">
                                        user: ${user.username} <br>
                                        <input type="hidden" id="username" name="username" value="${user.username}" /><br>
                                        <label for="password">Password</label>
                                        <input type="password" class="form-control" placeholder="Password" id="password" name="password" value="${user.password}" /><br>
                                        <label for="email">Email</label>
                                        <input type="email" class="form-control" placeholder="Email" id="email" name="email" value="${user.email}" /><br>
                                        <label for="user">User</label>
                                        <input id="user" name="user" type="checkbox" <c:if test="${user.roleStringHolder.isUser=='yes'}"> checked </c:if> ><br>
                                        <label for="premium">Premium User</label>
                                        <input id="premium" name="premium" type="checkbox" <c:if test="${user.roleStringHolder.isPremium=='yes'}"> checked </c:if> ><br>
                                        <label for="admin">Admin</label>
                                        <input id="admin" name="admin" type="checkbox" <c:if test="${user.roleStringHolder.isAdmin=='yes'}"> checked </c:if> ><br>
                                        <label for="admin">Enabled</label>
                                        <input id="enabled" name="enabled" type="checkbox" <c:if test="${user.enabled=='1'}"> checked </c:if> ><br>
                                        <br />
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                        <button type="submit" class="fa fa-floppy-o">  Update User</button>

                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>  
        <!-- jQuery -->
        <script src="../../../../resources/js/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="../../../../resources/js/bootstrap.min.js"></script>
        <!-- bootstrap-progressbar -->
        <script src="../../../../resources/js/bootstrap-progressbar.min.js"></script>
        <!-- Skycons -->
        <script src="../../../../resources/js/skycons.js"></script>
        <!-- Custom Theme Scripts -->
        <script src="../../../../resources/js/custom.min.js"></script>
    </body>
</html>
