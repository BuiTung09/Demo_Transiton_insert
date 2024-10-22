<%-- 
    Document   : register_skill
    Created on : Sep 21, 2024, 11:54:06 AM
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
        Name: ${sessionScope.dog.name} <br/>
        Gender: ${sessionScope.dog.gender?"male":"female"} <br/>
        Dob: ${sessionScope.dog.dob} <br/>
        <table border="1px">
            <tr>
                <td>Name</td>
                <td>Level</td>
            </tr>
            <c:forEach items="${sessionScope.dog.skills}" var="s">
            <tr>
                <td>${s.name}</td>
                <td>${s.level}</td>
            </tr>    
            </c:forEach>
        </table>
        <form action="skill" method="POST">
            <input type="hidden" name="action" value="profile"/>
            <input type="submit" value="Back"/>
        </form>
        <form action="skill" method="POST">
            <input type="hidden" name="action" value="skill"/>
            Name: <input type="text" name="name"/> <br/>
            Level: <input type="text" name="level"/> <br/>
            <input type="submit" value="+ Skill"/>
        </form>
        <form action="skill" method="POST">
            <input type="hidden" name="action" value="dog"/>
            <input type="submit" value="Save"/>
        </form>
        
       
    </body>
</html>
