<%-- 
    Document   : create
    Created on : Sep 21, 2024, 9:36:59 AM
    Author     : sonnt-local
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
        <jsp:include page="../master/shortprofile.jsp"></jsp:include>
        <form action="create" method="POST">
            Name: <input type="text" name="name"/> <br/>
            Gender: <input type="radio" name="gender" value="male" checked="checked" /> Male
            <input type="radio" name="gender" value="female" /> Female <br/>
            Dob: <input type="date" name="dob"/> <br/>
            Address: <input type="text" name="address"/> <br/>
            Department: <select name="did">
            <c:forEach items="${requestScope.depts}" var="d">
                <option value="${d.id}">${d.name}</option>
            </c:forEach>
            </select> <br/>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>
