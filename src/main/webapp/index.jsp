<%-- 
    Document   : index
    Created on : 23-Jul-2020, 6:02:27 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Startup index!<br>
        <a href="student/showStudents">Show Students</a><br>
        
        <security:authorize access="hasAnyRole('ROLE_MANAGER','ROLE_ADMIN')">
            <a href="student/showForm">Add Students</a>
        </security:authorize>
            
        <security:authorize access="isAuthenticated()">
            <form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
                <input type="submit" value="Logout" />
            </form:form>
        </security:authorize>    
    </body>
</html>
