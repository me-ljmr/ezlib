<%-- 
    Document   : login
    Created on : 13-Oct-2016, 2:58:40 PM
    Author     : SAUMIL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form:form method="post" action="main" commandName="loginForm">
            
  <div class="container">
    <label><b>Username</b></label>
    <form:input path="userName"/> 
    <span style="color:#FF0000"><form:errors path="userName"/></span><br>
    <label><b>Password</b></label>
    <form:password path="password"/> 
    <span style="color:#FF0000"> <form:errors path="password"></form:errors></span> <br>
  
    <input type="submit" value="Login"/>
  </div>

        </form:form>
    </body>
</html>
