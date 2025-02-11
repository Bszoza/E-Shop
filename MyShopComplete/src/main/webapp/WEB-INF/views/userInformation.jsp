<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Twoje dane</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/0aada522c4.js" crossorigin="anonymous"></script>
    <script src="../jscripts/modal.js"></script>
    <%@include file="../segments/stylesheets.jspf" %>
</head>
<body>
<h1>Twoje dane:</h1>
<table class="cart-table">
    <thead>
    <tr>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>email</th>
        <th>Nazwa użytkownika</th>
        <th>Data rejestracji</th>
    </tr>
    </thead>
    <tbody>
    <td>${userInfo.name}</td>
    <td>${userInfo.lastName}</td>
    <td>${userInfo.email}</td>
    <td>${userInfo.username}</td>
    <td>${userInfo.registrationDate}</td>
    </tbody>
</table>
<%@include file="../segments/footer.jspf" %>
</body>
</html>
