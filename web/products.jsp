<%@ page import="java.util.*, murach.business.*, murach.data.ProductIO, murach.business.Product" %>

<html>
<head><title>CD list</title></head>
<body>
<h1>CD list</h1>

<table border="1">
<tr>
    <th>Description</th>
    <th>Price</th>
    <th></th>
</tr>

<%
    ServletContext sc = getServletContext();
    String path = sc.getRealPath("/WEB-INF/products.txt");
    ArrayList<Product> products = ProductIO.getProducts(path);
    for (Product p : products) {
%>
<tr>
    <td><%= p.getDescription() %></td>
    <td>$<%= p.getPrice() %></td>
    <td>
        <form action="cart" method="post">
            <input type="hidden" name="action" value="add">
            <input type="hidden" name="productCode" value="<%= p.getCode() %>">
            <input type="submit" value="Add To Cart">
        </form>
    </td>
</tr>
<% } %>

</table>

</body>
</html>
