<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 07/06/2023
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<center>
    <h1>Edit Product Type</h1>
</center>
<body>
<form action="/productType?action=edit" method="post">
    <table>
        <tr>
            <td><label for="id">Id Product</label></td>
            <td><input  readonly name="id" id="id" value="${id}"></td>
        </tr>
        <tr>
            <td><label for="productType">Product Type</label></td>
            <td><input name="productType" id="productType" type="text" value="${name}"></td>
        </tr>
    </table>
    <input type="submit" value="SUBMIT">
</form>
</body>
</html>
