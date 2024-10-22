<%-- 
    Document   : generate
    Created on : Sep 16, 2024, 8:49:53 AM
    Author     : sonnt-local
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="entity.Rect" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>
        ${sessionScope.student.name} <br/>
        ${1+1} <br/>
        ${(1 eq 1)?"I love sonnt":"i hate sonnt"} <br/>
        ${requestScope.rects[0].x} <br/>

        <canvas id="myCanvas" width="500" height="500" style="border:1px solid grey"></canvas>

        <script>
            const c = document.getElementById("myCanvas");
            const ctx = c.getContext("2d");
            <c:forEach items="${requestScope.rects}" var="r">
                <c:if test="${r.x + r.w le 250 }">
                    ctx.fillStyle = "rgb(${r.red},${r.green},${r.blue})";
                    ctx.fillRect(${r.x}, ${r.y}, ${r.w}, ${r.h});
                    ctx.beginPath();
                    ctx.rect(${r.x}, ${r.y}, ${r.w}, ${r.h});
                    ctx.stroke();
                </c:if>
            </c:forEach>
        </script>
    </body>
</html>
