<%-- 
    Document   : filter
    Created on : Oct 2, 2024, 11:06:11 AM
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
        <form action="filter" method="GET"> 
            Id: <input type="text" name="id" value="${param.id}"/> <br/>
            Name: <input type="text" name="name" value="${param.name}"/> <br/>
            Gender: <input type="radio" ${param.gender ne null and param.gender eq "male"?"checked=\"checked\"":""} 
                           name="gender" value="male"/> Male
            <input type="radio" ${param.gender ne null and param.gender eq "female"?"checked=\"checked\"":""}
                   name="gender" value="female"/> Female
            <input type="radio" ${param.gender eq null or param.gender eq "both"?"checked=\"checked\"":""} name="gender" value="both"/> Both
            <br/>
            Dob - From : <input type="date" name="from" value="${param.from}"/> - To: <input type="date" name="to" value="${param.to}"/> <br/>
            Address: <input type="text" name="address" value="${param.address}"/> <br/>
            Department: <select name="did">
                <option value="-1">--------------ALL--------------</option>
                <c:forEach items="${requestScope.depts}" var="d">
                    <option 
                        ${param.did ne null and param.did eq d.id ?"selected=\"selected\"":""}
                        value="${d.id}">${d.name}</option>
                </c:forEach>
            </select> 
            <br/>
            <input type="submit" value="Search"/>
        </form>
        <table border="1px">
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>Gender</td>
                <td>Dob</td>
                <td>Address</td>
                <td>Department</td>
            </tr>
            <c:forEach items="${requestScope.emps}" var="e">
             <tr>
                <td>${e.id}</td>
                <td>${e.name}</td>
                <td>${e.gender?"Male":"Female"}</td>
                <td>${e.dob}</td>
                <td>${e.address}</td>
                <td>${e.dept.name}</td>
            </tr>   
            </c:forEach>
        </table>
    </body>
</html>
