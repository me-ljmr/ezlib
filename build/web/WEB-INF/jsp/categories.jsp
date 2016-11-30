 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head> 
        
            
         <%@include file="springvars.jsp" %> 
         <title>ezLib - ${categoriesTitle}</title>

         <%@include file="links.jsp" %>
        
    </head>
    <body  style="background:url(${bookCover})">
        <div class="background-overlay">
            <div class="ripple-top"></div>
            <div class="ripple"></div>
            <div class="wrapper">
                <%@include file="header.jsp" %>
                <main>
                    <a href="category/add">Create New</a>
                    <table>
                        <tr><th>Category Id</th><th>Description</th><th>Icon Number</th></tr>
                        <c:forEach items="${cats}" var="cat">
                            <tr><td>${cat.categoryId}</td><td>${cat.description}</td><td>${cat.icon}</td></tr>
                         </c:forEach>
                    </table>
                    
                </main>
            </div> 
        </div> 
    </body>
        
</html>
