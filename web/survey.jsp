<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Murach's Java Servlets and JSP</title>
<link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
    <body>
        <h1>Thanks for taking our survey!</h1>
    <p>Here is the information that you entered:</p>
    <table>
        <tr>
            <td>Email:</td>
            <td>${user.email}</td>
        </tr>
        <tr>
            <td>First Name:</td>
            <td>${user.firstName}</td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td>${user.lastName}</td>
        </tr>
        <tr>
            <td>Heard From:</td>
            <td>${user.heardFrom}</td>
        </tr>
        <tr>
            <td>Updates:</td>
            <td>${user.updates}</td>
        </tr>
        <tr>
            <td>Contact Via:</td>
            <td>${user.contactVia}</td>
        </tr>
        <tr>
            <td>Updates:</td>
            <td>${user.updates}</td>
        </tr>
        
        <%-- B?t ??u JSTL c:if --%>
        <c:if test="${user.updates == 'Yes'}"> 
        <tr>
            <td>Contact Via:</td>
            <td>${user.contactVia}</td>
        </tr>
        </c:if>
        <%-- K?t thúc JSTL c:if --%>
    </table>
    <form action="emailList" method="post">
    <input type="hidden" name="action" value="join">
    <input type="submit" value="Return">
</form>
    </body>
</html>
