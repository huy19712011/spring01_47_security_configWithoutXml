<%-- 
    Document   : home
    Created on : Sep 15, 2021, 10:37:00 PM
    Author     : huynq
--%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
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
        <hr>

        <!--display user name and role(s)-->
        <p>
            User: <security:authentication property="principal.username"/>
            <br><br>
            Role(s): <security:authentication property="principal.authorities" />
        </p>


        <security:authorize access="hasRole('MANAGER')">
            <!--add link point to /leaders--> manager
            <p>
                <a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
                (Only for Manager peeps)
            </p>
        </security:authorize>

        <security:authorize access="hasRole('ADMIN')">
            <!--add link point to /systems--> admin
            <p>
                <a href="${pageContext.request.contextPath}/systems">IT systems Meeting</a>
                (Only for Admin peeps)
            </p>
        </security:authorize>

        <hr>

        <!--add logout button-->
        <form:form action="${pageContext.request.contextPath}/logout"
                   method="POST">
            <input type="submit" value="Logout"/>
        </form:form>
    </body>

</html>
