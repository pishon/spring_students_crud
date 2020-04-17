<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
    <head>
        <title>Edit student page</title>
    </head>

    <body>

        <h1>Student info</h1>


        <jstl:if test="${empty student.id}">
            <jstl:url value="/add" var="var"/>
        </jstl:if>
        <jstl:if test="${!empty student.id}">
            <jstl:url value="/edit" var="var"/>
        </jstl:if>


        <form action="${var}" method="POST">
            <jstl:if test="${!empty student.id}">
                <input type="hidden" name="id" value="${student.id}">
            </jstl:if>

            <div class="row">
                <div class="left-column">
                    <label for="name">Name</label>
                </div>
                <div class="right-column">
                    <input type="text" name="name" id="name" value="${student.name}">
                </div>
            </div>
            <br/>

            <div class="row">
                <div class="left-column">
                    <label for="age">Age</label>
                </div>
                <div class="right-column">
                    <input type="number" name="age" id="age" value="${student.age}">
                </div>
            </div>
            <br/>

            <div class="row">
                <div class="left-column">
                    <label for="group"">Group</label>
                </div>
                <div class="right-column">
                    <input type="text" name="group" id="group" value="${student.group}">
                </div>
            </div>
            <br/>

            <input type="submit" value="Submit">
        </form>
    </body>

</html>
