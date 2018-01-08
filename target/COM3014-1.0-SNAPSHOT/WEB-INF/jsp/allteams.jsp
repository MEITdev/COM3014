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
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Footballs</title>
        
        <!-- Bootstrap -->
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="resources/css/font-awesome.css" rel="stylesheet">
        <!-- NProgress -->
        <link href="resources/css/nprogress.css" rel="stylesheet">
        <!-- iCheck -->
        <link href="resources/css/green.css" rel="stylesheet">
        <!-- bootstrap-progressbar -->
        <link href="resources/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">

        <!-- JQVMap -->
        <link href="resources/css/jqvmap.min.css" rel="stylesheet"/>

        <!-- Custom Theme Style -->
        <link href="resources/css/custom.min.css" rel="stylesheet">
        <!-- Player Profile Style -->
        <link href="resources/css/profile-css/style.css" rel="stylesheet">
        <link href="resources/css/profile-css/blue.css" rel="stylesheet">
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
                            <div class="col-md-6 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Play Game</h2>
                                        <ul class="nav navbar-right">
                                            <a class="collapse-link"></a>
                                        </ul>
                                      <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">
                                        <c:if test="${param.message != null}">
                                            <div>
                                                 ${param.message}.
                                            </div>
                                        </c:if> 
                                        <br />
                                            <legend>Select an opponent:  
                                                <select class="id" placeholder="Select Team">
                                                    <option disabled selected value> -- select an option -- </option>
                                                    <c:forEach items="${teams}" var="team">
                                                    <option value="${team.name}"> ${team.name}</option>
                                                    </c:forEach>
                                                </select>
                                                <c:url value="game/play/id" var="playGame" />
                                                <a id="link" href="${playGame}" class="btn btn-primary" role="button"><b>Play Game </b></a>
                                            </legend>                                               
                                        </div>
                                    </div>
                                </div>  
                            </div>
                        </div>
                    </div>
                </div>
                <%@ include file="/WEB-INF/jspf/footer.jspf"%>
            </div>
        </div>
        <!-- jQuery -->
        <script src="resources/js/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="resources/js/bootstrap.min.js"></script>
        <!-- bootstrap-progressbar -->
        <script src="resources/js/bootstrap-progressbar.min.js"></script>
        <!-- Skycons -->
        <script src="resources/js/skycons.js"></script>
        <!-- Custom Theme Scripts -->
        <script src="resources/js/custom.min.js"></script>
        <script>
            $(document).ready(function(){
                $("select.id").change(function(){

                    var selectedid  = $(".id option:selected").val();
                    $("#link").attr("href","game/play/"+selectedid);  //-----this will change href 
                });
            });
        </script>
    </body>
</html>
