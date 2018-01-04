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
        <link href="../../../resources/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="../../../resources/css/font-awesome.css" rel="stylesheet">
        <!-- NProgress -->
        <link href="../../../resources/css/nprogress.css" rel="stylesheet">
        <!-- iCheck -->
        <link href="../../../resources/css/green.css" rel="stylesheet">
        <!-- bootstrap-progressbar -->
        <link href="../../../resources/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
        <!-- JQVMap -->
        <link href="../../../resources/css/jqvmap.min.css" rel="stylesheet"/>

        <!-- Custom Theme Style -->
        <link href="../../../resources/css/custom.min.css" rel="stylesheet">
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
                                        <h2>Upgrade Player</h2>
                                      <div class="clearfix"></div>
                                    </div>
                                    <div class="x_content">
                                        <c:if test="${param.message != null}">
                                            <div>
                                                 ${param.message}.
                                            </div>
                                        </c:if>
                                    </div> 
                                    <div class="x_content">
                                        <h4>Budget: ${budget}$</h4>
                                        <h4>Price for defence upgrade: ${pricedef}$</h4>
                                        <h4>Price for offence upgrade ${priceoff}$</h4>
                                    </div>       
                                            <div class="col-lg-4 col-xlg-4 col-md-6">
                                                <div class="card">
                                                    <div class="card-block">
                                                        <center class="m-t-30"> <img src="../../../resources/img/user.png" class="img-circle" width="150" />
                                                            <h4 class="card-title m-t-10">${player.forename} ${player.surname}</h4>
                                                            <div class="row text-center justify-content-md-center">
                                                                <div><font class="font-medium">Age: ${player.age}</font></div>
                                                                <div><font class="font-medium">Salary: ${player.salary}</font></div>
                                                                <c:url value="/players/${player.id}/upgrade/" var="upgrade" />
                                                                <div> 
                                                                    <form  action="${upgrade}" method="POST">
                                                                        <font class="font-medium">Offense: ${player.offense}</font>
                                                                        <input id="type" name="type" type="hidden" value="off"/>
                                                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                                                        <input type="submit" value="+3" /> 
                                                                    </form>
                                                                </div>
                                                                <div>
                                                                    <form  action="${upgrade}" method="POST">
                                                                        <font class="font-medium">Defense: ${player.defense}</font>
                                                                        <input id="type" name="type" type="hidden" value="def"/>
                                                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                                                        <input type="submit" value="+3" /> 
                                                                    </form>
                                                                </div>
                                                            </div>
                                                        </center>
                                                    </div>
                                                </div>
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
        </div>
        <!-- jQuery -->
        <script src="../../../resources/js/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="../../../resources/js/bootstrap.min.js"></script>
        <!-- bootstrap-progressbar -->
        <script src="../../../resources/js/bootstrap-progressbar.min.js"></script>
        <!-- Skycons -->
        <script src="../../../resources/js/skycons.js"></script>
        <!-- Custom Theme Scripts -->
        <script src="../../../resources/js/custom.min.js"></script>        
    </body>
</html>



