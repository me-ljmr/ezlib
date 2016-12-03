<%-- 
    Document   : addBook
    Created on : 28-Nov-2016, 6:44:25 PM
    Author     : SAUMIL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>

<html><head>
        <title>ezLib</title>

        <link type="text/css" rel="stylesheet" href="http://pdflibrary.me/assets/css/min.css">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet" type="text/css">

    </head>
    <body>
        <div class="background-overlay">
            <div class="ripple-top"></div>
            <div class="ripple"></div>
            <div class="wrapper">
                <div class="header">

                    <div>Add New Book</div></div>

                <div class="main" >
                    <form:form method="post" action="/ezlib/member/save" commandName="addMemberCommand"   >




                        <center>
                            <table >
                                <tr>
                                    <td>First Name : </td>
                                    <td><form:input  path="firstName"/></td>

                                </tr>
                                <tr>
                                    <td>Last Name : </td>
                                    <td><form:input path="lastName" /></td>

                                </tr>

                                <tr>
                                    <td>Email : </td>
                                    <td><form:input path="email"/></td>

                                </tr>

                                <tr>
                                    <td>Password : </td>
                                    <td><form:password path="password"/></td>

                                </tr>

                                <tr>
                                    <td>Confirm Password : </td>
                                    <td><input type="password" /></td>

                                </tr>

                                <td>Gender : </td>
                                <td><form:select  path="gender">
                                        <form:option value="0">Pls select one</form:option>

                                        <form:option value='M'>Male</form:option>
                                        <form:option value='F'>Female</form:option>

                                    </form:select>
                                </td>

                                <tr>
                                    <td>Status : </td>
                                    <td><form:input path="status"/></td>

                                </tr>

                                <tr>
                                    <td>Profile Pic</td>
                                    <td><input type="file"/></td>
                                </tr>

                                <tr>
                                    <td>Cell Number : </td>
                                    <td><form:input path="cellNumber"/></td>

                                </tr>

                                <tr>
                                    <td>Address</td>
                                    <td><form:textarea path="address"/></td>
                                </tr>

                                <tr>
                                    <td>Postal code : </td>
                                    <td><form:input path="postalCode"/></td>
                                </tr>


                                <tr>
                                    <td><input type="submit" value="Add"></td>
                                    <td><input type="submit" value="Cancel"></td>

                                </tr>


                            </table>
                        </center>
                    </form:form>
                </div>


            </div>

        </div>

    </body></html>
