<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<html>
    <head>  
            
         <%@include file="springvars.jsp" %> 
         <title>ezLib - Author</title>
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
                                
                                <form:form action="/ezLib/author/save" method="post" commandName="authorForm">
                                    <table>
                                        <tr><th>First Name</th>
                                            <td>
                                                <form:hidden path="authorId" />
                                               <form:input path="firstName" />
                                            </td>
                                        </tr> 
                                        <tr>
                                            <th>Last Name</th>
                                            <td>
                                            <form:input path="lastName" />
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
                    