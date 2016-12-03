 
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
                    <a href="member/add">Create New</a>
                   

                    <table>
                        <tr><th>&nbsp;</th>
                            <th>memberId</th>
                            <th>firstName</th>
                            <th>lastName</th>
                            <th>email</th>
                            <th>Password</th>
                            <th>gender</th>
                            <th>status</th>
                            <th>profilePicUrl</th>
                            <th>cellNumber</th>
                            <th>address</th>
                            <th>postalCode</th>
                            <th>balance</th>
                            <th>libraryCardNumber</th>
                            <th>verficationStatus</th>
                            <th>confirmationCode</th>

                        </tr>
                        <c:forEach items="${members}" var="member"> 
                            <tr>
                            <td>${member.memberId}</td>
                            <td>${member.firstName}</td>
                            <td>${member.lastName}</td>
                            <td>${member.email}</td>
                            <td>${member.password}</td>
                            <td>${member.gender}</td>
                            <td>${member.status}</td>
                            <td>${member.profilePicUrl}</td>
                            <td>${member.cellNumber}</td>
                            <td>${member.address}</td>
                            <td>${member.postalCode}</td>
                            <td>${member.balance}</td>
                            <td>${member.libraryCardNumber}</td>
                            <td>${member.verficationStatus}</td>
                            <td>${member.confirmationCode}</td>

                            </tr>

                        </c:forEach>
                    </table>

                </main>
            </div> 
        </div> 
    </body>

</html>
