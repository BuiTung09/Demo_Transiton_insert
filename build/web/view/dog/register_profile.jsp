<%-- 
    Document   : register_profile
    Created on : Sep 21, 2024, 11:37:19 AM
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
        <form action="profile" method="POST">
            Name:<input type="text" name="name" value="${requestScope.dog.name}" /> <br/>
            Gender:<input type="radio" name="gender" value="male"
                          <c:if test="${(requestScope.dog eq null) or requestScope.dog.gender}">
                              checked="checked"
                          </c:if>
                          /> male 
            <input type="radio" name="gender" value="female"
                   <c:if test="${requestScope.dog ne null and !requestScope.dog.gender}">
                       checked="checked"
                   </c:if>
                   /> female <br/>
            Dob: <input type="date" name="dob" value="${requestScope.dog.dob}"/> <br/>
            <input type="submit" value="Next"/>
        </form>
    </body>
</html>
