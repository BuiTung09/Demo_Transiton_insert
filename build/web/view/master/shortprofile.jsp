<%-- 
    Document   : shortprofile
    Created on : Sep 21, 2024, 9:39:43 AM
    Author     : sonnt-local
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ${sessionScope.account.username} / ${sessionScope.account.displayname} <br/>
    </body>
</html>
