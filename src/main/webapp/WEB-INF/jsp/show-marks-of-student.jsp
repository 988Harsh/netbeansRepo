<%-- 
    Document   : show-marks-of-student
    Created on : 27-Jul-2020, 3:37:30 PM
    Author     : Lenovo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Marks of Student with id ${student.id}:<br>
        <c:forEach var="temp" items="${marks}">
            
            ${temp.subject}: ${temp.score} <br>
            
        </c:forEach>
    </body>
</html>
