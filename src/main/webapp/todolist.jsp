<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My ToDo List</title>
</head>
<body>
<h2>My ToDo List</h2>

<form action="update" method="POST">
    <table width="90%" border="1" align="center">
        <tr bgcolor="#dcdcdc">
            <th width="50%">Name</th>
            <th width="35%">Category</th>
            <th width="15%">Complete</th>
        </tr>
        <c:forEach items="${sessionScope.tasks}" var="entry">
            <tr>
                <td align="center"><c:out value="${entry.key}"/></td>
                <td align="center"><c:out value="${entry.value}"/></td>
                <td align="center"><input type="checkbox" name="complete" value="${entry.key}"/></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <input type="submit" value="Update Tasks"/>
</form>

<form action="add" method="POST">
    Task name: <input type="text" name="task_name"/>
    <br/>
    Task category: <input type="text" name="task_category"/>
    <br/><br/>
    <input type="submit" value="Add Task"/>
</form>

</body>
</html>