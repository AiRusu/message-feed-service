<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="maven.project.util.AttributeNames" %>

<html>
<head>
    <title>Add Messages</title>
</head>
<body>
    <div align="center">
        <form:form method="POST" modelAttribute="${AttributeNames.MESSAGE_ITEM}">
                <table>
                    <tr>
                        <td><label>ID</label></td>
                        <td>
                            <form:input path="id" disabled="true" />
                        </td>
                    </tr>
                    <tr>
                        <td><label>Name</label></td>
                        <td><form:input path="name"/></td>
                    </tr>
                    <tr>
                        <td><label>Email</label></td>
                        <td><form:input path="email"/></td>
                    </tr>
                    <tr>
                        <td><label>Message</label></td>
                        <td><form:textarea path="Message"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit"/></td>
                    </tr>
                </table>

        </form:form>
    </div>

</body>
</html>