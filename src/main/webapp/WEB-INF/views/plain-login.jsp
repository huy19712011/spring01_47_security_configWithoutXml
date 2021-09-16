<%-- 
    Document   : plain-login
    Created on : Sep 16, 2021, 9:38:53 AM
    Author     : huynq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
        <style>
            .failed {
                color: red;
            }
        </style>
    </head>
    <body>
        <h3>Custom Login Page</h3>
        <form:form 
            action="${pageContext.request.contextPath}/authenticateTheUser"
            method="POST">
            
            <!--check for login error-->
            <c:if test="${param.error != null}">
                <i class="failed">Invalid username or password!</i>
            </c:if>
            
            <p>
                User name: <input type="text" name="username"/>
            </p>
            <p>
                Password: <input type="password" name="password"/>
            </p>
            <input type="submit" value="Login" />
        </form:form>
    </body>
</html>
