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
                    <form:form method="post" action="saveBook" commandName="addBookCommand"   >


                        <center>
                            <table >
                                <tr>
                                    <td>ISBN : </td>
                                    <td><form:input  path="ISBN"/></td>

                                </tr>
                                <tr>
                                    <td>Title : </td>
                                    <td><form:input path="Title" /></td>

                                </tr>

                                <tr>
                                    <td>Description : </td>
                                    <td><form:textarea id="description"  path="Description"/></td>

                                </tr>

                                <tr>
                                    <td>Category</td>
                                    <td><form:select path="categoryId"  >

                                            <form:option value="dropdown"/>Pls select one

                                            <c:forEach items= "${cats}" var="cats">
                                                <form:option  value='${cats.categoryId}'>${cats.description}</form:option>

                                            </c:forEach>
                                        </form:select></td>

                                </tr>

                                <tr>
                                    <td> Cover Image : </td>
                                    <td><input type="file"></td>

                                </tr>

                                <tr>


                                    <td>Publisher</td>

                                    <td><form:select  path="publisherId" >
                                            <form:option value="dropdown"/>Pls select one

                                            <c:forEach items= "${pubs}" var="pubs">
                                                <form:option value='${pubs.publisherId}'>${pubs.publisherName}</form:option>

                                            </c:forEach>
                                        </form:select></td>

                                </tr>

                                <tr>
                                    <td>Published Year</td>
                                    <td><form:input path="year" /></td>

                                </tr>

                                <tr>
                                    <td>Author Name</td>
                                    <td><form:select multiple="multiple" path="authorId">
                                            <form:option value="dropdown"/>Pls select one

                                            <c:forEach items= "${aut}" var="aut">
                                                <form:option value='${aut.authorId}'>${aut.firstName} ${aut.lastName}</form:option>

                                            </c:forEach>
                                        </form:select>


                                </tr>
                                <tr>
                                    <td><span id="fooBar"></span></td>

                                </tr>

                                <tr>
                                    <td>Pages : </td>
                                    <td><form:input path="Pages"/></td>

                                </tr>

                                <tr>
                                    <td>Price : </td>
                                    <td><form:input path="price" /></td>

                                </tr>

                                <tr>
                                    <td>Allowed for Reservation : </td>
                                    <td><form:select  path="allowedForReservation">
                                            <form:option value="0"/>Pls select one

                                            <form:option value='1'>Yes</form:option>
                                            <form:option value='0'>No</form:option>

                                        </form:select>
                                    </td>
                                    
                                     <tr>
                                    <td>Book Type : </td>
                                    <td><form:select  path="bookType">
                                            <form:option value="0"/>Pls select one

                                            <form:option value='1'>Ebook</form:option>
                                            <form:option value='0'>Paperback</form:option>

                                        </form:select>
                                    </td>



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
