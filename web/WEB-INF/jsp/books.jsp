 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
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
                        <tr><th>&nbsp;</th><th>ISBN</th>
                            <th>Title</th>
                            <th>Description</th>
                            <th>Cover image</th>
                            <th>Publisher ID</th>
                            <th>Pages</th>
                            <th>likes</th>
                            <th>Price</th>
                            <th>Published Year</th>
                            <th>Category Id</th>
                            <th>Book Type</th>
                            <th>Allowed for reservation</th>

                        </tr>
                        <c:forEach items="${books}" var="book"> 
                            <tr ><td>${book.ISBN}</td>
                                <td>${book.title}</td>
                            <td>${book.description}</td>
                            <td>${book.coverImage}</td>
                            <td>${book.publisherId}</td>
                            <td>${book.pages}</td>
                            <td>${book.likes}</td>
                            <td>${book.price}</td>
                            <td>${book.year}</td>
                            <td>${book.categoryId}</td>
                            <td>${book.bookType}</td>
                            <td>${book.allowedForReservation}</td>

                            </tr>

                        </c:forEach>
                    </table>

                </main>
            </div> 
        </div> 
    </body>

</html>
