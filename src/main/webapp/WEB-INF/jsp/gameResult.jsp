<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- 
    Document   : gameResult
    Created on : 06-Jan-2018, 21:43:32
    Author     : Ivan
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
                                        <h2>Game Result</h2>
                                      <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">
                                        <c:if test="${param.message != null}">
                                            <div>
                                                 ${param.message}.
                                            </div>
                                        </c:if>
                                        <h2 style="color:DarkCyan ;"> ${winningTeam} ${winningTeamRes} : ${losingTeamRes} ${losingTeam} </h2>
                                    </div> 
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
                                
        <%@ include file="/WEB-INF/jspf/footer.jspf"%>   
        
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
    </body>
</html>
