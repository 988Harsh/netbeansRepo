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
        <h1>Student!</h1>
        <table border="2">
            <tr>
                <td>id</td>
                <td>fname</td>
                <td>lname</td>
                <td>email</td>
                <td colspan="4">Changes/View</td>
            </tr>
        <c:forEach var="st" items="${theStudents}">
            <tr>
                <td>${st.id}</td>
                <td>${st.fname}</td>
                <td>${st.lname}</td>
                <td>${st.email}</td>
                <td><form action="editStudent" ><input hidden type="text" value="${st.id}" name="id"><input type="submit" value="Edit"></form></td>
                <td><form action="deleteStudent" ><input hidden type="text" value="${st.id}" name="id"><input type="submit" value="Delete"></form></td>
                <td><form action="../marks/addMarksStudent" ><input hidden type="text" value="${st.id}" name="id"><input type="submit" value="Add Marks"></form></td>
                <td><form action="../marks/getMarksStudent" ><input hidden type="text" value="${st.id}" name="id"><input type="submit" value="Show Marks"></form></td>
            </tr>
        </c:forEach>
            
        </table>
        <a href="../">Home!!</a>
    </body>
</html>
