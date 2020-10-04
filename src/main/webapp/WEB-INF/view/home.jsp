<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="maven.project.util.Mappings" %>

<html>
<head>
    <title> Message Feed Service Application</title>
</head>
<body>
    <div align="center">
        <c:url var="messagesLink" value="${Mappings.MESSAGES}"/>
        <h2><a href="${messagesLink}">Show Messages</a></h2>
    </div>

</body>
</html>