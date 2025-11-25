<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>TestServlet Form</title>
</head>
<body>
    <h2>TestServlet Form</h2>
    <form action="/test" method="post">
        <label>First Name:</label>
        <input type="text" name="firstName" required><br><br>

        <label>Last Name:</label>
        <input type="text" name="lastName" required><br><br>

       
    </form>
</body>
</html>
