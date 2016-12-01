 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<html>
    <head> 
        
            
         <%@include file="springvars.jsp" %> 
         <title>ezLib - ${authorsTitle}</title>

         <%@include file="links.jsp" %>
        
    </head>
    <body  style="background:url(${bookCover})">
        <div class="background-overlay">
            <div class="ripple-top"></div>
            <div class="ripple"></div>
            <div class="wrapper">
                <%@include file="header.jsp" %>
                <main>
                    <a href="author/add">Create New</a>
                    
                        <table>
                            <tr><th>Author ID</th><th>Name</th><th>No. of Books</th></tr>
                            <c:forEach items="${authors}" var="aut"> 
                                <tr ><td>${aut.authorId}</td><td>${aut.firstName}&nbsp;${aut.lastName}</td><td>${aut.writtenBooks}</td>
                                    <td>
                                        <form:form action="author/edit/${aut.authorId}" method="get" commandName="authorForm">
                                             
                                            <input type="submit" value="Modify"   />
                                        
                                        </form:form>
                                    </td>
                                </tr>
                                
                             </c:forEach>
                        </table>
                    
                </main>
            </div> 
        </div> 
    </body>
        
</html>
