<%@ include file="/WEB-INF/jspf/header.jspf"%>
    <body class="nav-md">
        <div class="container body">
            <div class="main_container">
                <div class="col-md-3 left_col">
                    <div class="left_col scroll-view">
                        
                            <!-- sidebar profile quick info -->
                            <div class="profile clearfix">
                                <div class="profile_pic">
                                    <img src="resources/img/user.png" alt="..." class="img-circle profile_img">
                                </div>
                                <div class="profile_info">
                                    <span>Welcome,</span>
                                    <h2>${principal.name}</h2>
                                </div>
                            </div>
                            <!-- /sidebar profile quick info -->

                        <%@ include file="/WEB-INF/jspf/sidebar.jspf"%>

                        <form action="logout" method="post">
                            <input type="submit" value="Logout"/>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>   
                        </form>                                          
                    </div>                          
                </div>
                <!-- page content -->
                <div class="right_col" role="main">
                    <div class="">

                        <div class="clearfix"></div>

                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%@ include file="/WEB-INF/jspf/footer.jspf"%>
            </div>
        </div>
            
    </body>
</html>
