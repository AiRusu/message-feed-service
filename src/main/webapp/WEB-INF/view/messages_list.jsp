<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="maven.project.util.Mappings" %>

<html>
<head>
    <title>Messages</title>
</head>
<body>
    <div align="center">
    <c:url var="addUrl" value="${Mappings.ADD_MESSAGE}"/>
    <a href="${addUrl}">New Message</a>

        <table border="1" cellpadding="5">

            <caption><h2>Messages</h2></caption>

            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>View</th>
                <th>Edit</th>
            </tr>

            <c:forEach var="message" message="${messageData.message}">

                <c:url var="viewUrl" value="${Mappings.MESSAGES}">
                    <c:param name="id" value="${message.id}"/>
                </c:url>

                <c:url var="editUrl" value="${Mappings.ADD_MESSAGE}">
                    <c:param name="id" value="${message.id}"/>
                </c:url>

                <tr>
                    <td><c:out value="${message.name}"/></td>
                    <td><c:out value="${message.message}"/></td>
                    <td><c:out value="${message.created}"/></td>
                    <td><c:out value="${message.updated}"/></td>
                    <td><a href="${viewUrl}">View</a></td>
                    <td><a href="${editUrl}">Edit</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>