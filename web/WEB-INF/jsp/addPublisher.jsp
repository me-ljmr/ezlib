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
                                <form:form action="save" method="post" commandName="publisherForm">
                                    <table>
                                        <tr><th>Publisher Name : </th>
                                            <td>
                                                <form:hidden path="publisherId"></form:hidden>
                                               <form:input path="publisherName" />
                                            </td>
                                        </tr> 
                                        
                                         <tr><th>Address : </th>
                                            <td>
                                               <form:input path="address" />
                                            </td>
                                        </tr> 
                                        
                                         <tr><th>Contact Person</th>
                                            <td>
                                               <form:input path="contactPerson" />
                                            </td>
                                        </tr> 
                                        
                                        <tr>
                                            <th>Contact Number</th>
                                            <td>
                                            <form:input path="contactNumber" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan = 2>
                                                
                                                <input type="submit" name="submit" >
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
                    