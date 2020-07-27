<%-- 
    Document   : newjspshow-student
    Created on : 24-Jul-2020, 2:45:53 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     
        <form:form action="addToMarks" modelAttribute="marks">
            
            Subject: <form:input path="subject"/>
            Score: <form:input path="score"/>
            <input type="hidden" value="${id}" name="id" />
            <input type="submit" value="add"/>
            
        </form:form>
    
        
    </body>
</html>
