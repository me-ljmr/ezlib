 
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
                    pstmt.setString(1,b.getISBN());
                    pstmt.setString(2,b.getTitle());
                    pstmt.setString(3,b.getDescription());
                    pstmt.setString(4,b.getCoverImage());
                    pstmt.setLong(5,b.getPublisherId());
                    pstmt.setInt(6,b.getPages());
                    pstmt.setInt(7, 0);
                    pstmt.setDouble(8,b.getPrice());
                    pstmt.setInt(9,b.getYear());
                    pstmt.setLong(10,b.getCategoryId());
                    pstmt.setString(11, Character.toString('e'));
                    pstmt.setInt(12,2);

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
                            <th>Description</th>
                        </tr>
                        <c:forEach items="${cats}" var="cat"> 
                            <tr ><td><img src="${iconFolder}${cat.icon.fileName}" /></td><td>${cat.categoryId}</td><td>${cat.description}</td>
                                <td>
                                    <form:form action="category/edit/${cat.categoryId}" method="get" commandName="categoryForm">

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
