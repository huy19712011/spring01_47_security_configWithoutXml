<%-- 
    Document   : home
    Created on : Sep 15, 2021, 10:37:00 PM
    Author     : huynq
--%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring config without XML</title>
    </head>
    <body>
        <h1>Spring mvc configuration without XML - tutorial 1 </h1>
        
        <!--add logout button-->
        <form:form action="${pageContext.request.contextPath}/logout"
                   method="POST">
            <input type="submit" value="Logout"/>
        </form:form>
    </body>
    
</html>
