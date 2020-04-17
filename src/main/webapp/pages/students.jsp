<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Students list</title>
    </head>
    <body>

        <h1>Students</h1>
        <table border="1">
            <tr>
                <th style="width: 50px">ID</th>
                <th style="width: 200px">Name</th>
                <th style="width: 50px">Age</th>
                <th style="width: 200px">Group</th>
            </tr>

            <jstl:forEach var="stud" items="${studentsList}">
                <tr>
                    <td>${stud.id}</td>
                    <td>${stud.name}</td>
                    <td>${stud.age}</td>
                    <td>${stud.group}</td>

                    <td>
                        <a href="/edit/${stud.id}">edit</a>
                    </td>

                    <td>
                        <a href="/delete/${stud.id}">delete</a>
                    </td>
                </tr>
            </jstl:forEach>

        </table>

        <br/>

        <a href="/add">Add new student</a>

    </body>
</html>
