<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<html>
    <head>  

        <%@include file="springvars.jsp" %> 
        <title>ezLib - Add a new category</title>
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
                            <div class="row">
                                
                                <form:form action="/ezLib/category/save" method="post" commandName="categoryForm">
                                    <table>
                                        <tr><th>Description</th>
                                            <td>
                                                <form:hidden path="categoryId" />
                                               <form:input path="description" />
                                            </td>
                                        </tr> 
                                        <tr>
                                            <th>Icon</th>
                                            <td>
                                            <form:input path="icon.iconNumber" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan = 2>
                                                
                                                <input type="submit" name="submit" value="Save" >
                                            </td>
                                        </tr>
                                    </table>

                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
