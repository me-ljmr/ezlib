<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
    <head>  
            
         <%@include file="springvars.jsp" %> 
         <title>ezLib - Home</title>
         <%@include file="links.jsp" %>
    </head>
    <body  style="background:url(${bookCover})">
        <div class="background-overlay">
            <div class="ripple-top"></div>
            <div class="ripple"></div>
            <div class="wrapper">
                <%@include file="header.jsp" %>
                <div class="main"> 
                    <div class="row">
                         <div class="col-lg-4 col-md-6 col-sm-12">
                            <%@include file="catalogwidget.jsp" %>
                         </div>
                         <div class="col-lg-4 col-md-6 col-sm-12">
                            2nd column
                         </div>
                         <div class="col-lg-4 col-md-6 col-sm-12">
                            3rd Column 
                         </div>
                    </div>
                </div> 
                
            </div>

        </div>

    </body>
        
</html>