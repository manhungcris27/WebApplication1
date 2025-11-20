<%@ page import="murach.business.*" %>
<%@ page import="java.util.*" %>

<html>
<head>
    <title>Your cart</title>
    <style>
        table { border-collapse: collapse; width: 70%; }
        th, td { border: 1px solid #999; padding: 8px; }
        input[type="text"] { width: 30px; text-align: center; }
        form { margin: 0; }
    </style>
</head>
<body>

<h1>Your cart</h1>

<%
    Cart cart = (Cart) session.getAttribute("cart");
    if (cart == null || cart.getItems().size() == 0) {
%>
    <p>Your cart is empty.</p>
<%
    } else {
%>

<table>
<tr>
    <th>Quantity</th>
    <th>Description</th>
    <th>Price</th>
    <th>Amount</th>
    <th></th>
</tr>

<%
    for (LineItem item : cart.getItems()) {
%>
<tr>
    <td>
        <form action="cart" method="post" style="display:inline;">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="productCode" value="<%= item.getProduct().getCode() %>">
            <input type="text" name="quantity" value="<%= item.getQuantity() %>">
            <input type="submit" value="Update">
        </form>
    </td>

    <td><%= item.getProduct().getDescription() %></td>

    <td>$<%= item.getProduct().getPrice() %></td>

    <td>$<%= item.getTotal() %></td>

    <td>
        <form action="cart" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="productCode" value="<%= item.getProduct().getCode() %>">
            <input type="hidden" name="quantity" value="0">
            <input type="submit" value="Remove Item">
        </form>
    </td>
</tr>
<% } %>

</table>

<br>

<form action="cart" method="post">
    <input type="hidden" name="action" value="continue">
    <input type="submit" value="Continue Shopping">
</form>

<form action="cart" method="post" style="margin-top:10px;">
    <input type="hidden" name="action" value="checkout">
    <input type="submit" value="Checkout">
</form>


<% } %>

</body>
</html>
