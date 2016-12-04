 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<html>
    <head> 


        <%@include file="springvars.jsp" %> 
        <title>ezLib - ${publishersTitle}</title>

        <%@include file="links.jsp" %>

    </head>
    <body  style="background:url(${bookCover})">
        <div class="background-overlay">
            <div class="ripple-top"></div>
            <div class="ripple"></div>
            <div class="wrapper">
                <%@include file="header.jsp" %>
                <main>
                    <a href="publisher/add">Create New</a>
                    <table>
                        <tr><th> Publisher Id</th><th> Publisher Name</th><th> Address </th><th>Contact person</th><th>Contact Number </th></tr>
                                <c:forEach items="${pubs}" var="pub">
                            <tr><td> ${pub.publisherId}</td><td> ${pub.publisherName}</td><td> ${pub.address}</td><td> ${pub.contactPerson}</td><td> ${pub.contactNumber}</td>
                            <td>
                            <form:form action="publisher/${pub.publisherId}" method="get" commandName="publisherCommand">

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
