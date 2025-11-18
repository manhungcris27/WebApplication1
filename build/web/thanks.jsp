<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Murach's Java Servlets and JSP</title>
<link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>

<body>

<h1>Thank you for filling out our survey!</h1>

<p>Here is the information that you entered:</p>

<label>First Name:</label>
<span>${user.firstName}</span><br>

<label>Last Name:</label>
<span>${user.lastName}</span><br>

<label>Email:</label>
<span>${user.email}</span><br>

<label>Date of Birth:</label>
<span>${user.dob}</span><br>

<h3>How did you hear about us?</h3>
<span>${user.hear}</span><br><br>

<h3>Announcements & Offers</h3>
<label>Receive CD offers:</label>
<span>${user.receiveCDs}</span><br>

<label>Receive email announcements:</label>
<span>${user.receiveEmails}</span><br><br>

<label>Contact Method:</label>
<span>${user.contactMethod}</span><br><br>

<p>To submit another response, click Back or use the Return button below.</p>

<form action="emailList" method="post">
    <input type="hidden" name="action" value="join">
    <input type="submit" value="Return">
</form>

</body>
</html>
