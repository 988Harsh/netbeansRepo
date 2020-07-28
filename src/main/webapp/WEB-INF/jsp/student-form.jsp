<%-- 
    Document   : student-form
    Created on : 23-Jul-2020, 2:59:26 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Form</title>
    </head>
    <body>
        
        <form:form action="processForm" modelAttribute="student">
            
            First Name: <form:input path="fname"/>
            Last Name: <form:input path="lname"/>
            Email: <form:input path="email"/>
            <input type="text" hidden value="">
            <input type="submit" value="Submit" />
        </form:form>
        
    </body>
</html>
