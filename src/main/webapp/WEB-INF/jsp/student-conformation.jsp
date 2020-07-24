<%-- 
    Document   : student-conformation
    Created on : 23-Jul-2020, 3:09:34 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Student Added!!</h3>
        Fname: ${student.fname} <br>
        Lname: ${student.lname}<br>
        Email: ${student.email}<br><br>
        
        <a href="../">Home</a>
        <a href="show-student">Show-Students</a>
    </body>
</html>
