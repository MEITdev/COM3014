<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
    </head>
    <body class="nav-md">
        <div class="container body">
            <div class="main_container">
                <div class="col-md-3 left_col">
                    <div class="left_col scroll-view">
                        
                            
<div class="navbar nav_title" style="border: 0;">
                <a class="site_title"><i class="fa fa-futbol-o" aria-hidden="true"></i> <span>Footballs!</span></a>
                
            </div>
            
            <div class="clearfix"></div>
            
            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <ul class="nav side-menu">
                  <li><a href="login"><i class="fa fa-home"></i> Login</a>
                  </li>
                  
                  
                  
                  
              
                  
                </ul>
              </div>
            </div>
                        

                                                         
                    </div>                          
                </div>
                <!-- page content -->
                <div class="right_col" role="main">
                    <div class="">

                       

                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                     <div class="clearfix">
                                         <h1>Welcome to Footballs</h1>
                                         <h2><a href="login">Please click here to login or register!</a><h2>
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
    </body>
</html>
