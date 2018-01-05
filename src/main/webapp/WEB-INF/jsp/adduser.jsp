<%@ include file="/WEB-INF/jspf/header.jspf"%>

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
      
                                <%@ include file="/WEB-INF/jspf/adduserform.jspf"%>
                                </div>
                            </div>
                        </div>
                                
                        <div class="clearfix"></div>
                                
                    </div>
                </div>
            </div>
        </div>
                                
<%@ include file="/WEB-INF/jspf/footer.jspf"%>
</html>