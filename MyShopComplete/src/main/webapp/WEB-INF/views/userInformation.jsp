<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Twoje dane</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/0aada522c4.js" crossorigin="anonymous"></script>
    <script src="../jscripts/modal.js"></script>
    <%@include file="../segments/stylesheets.jspf" %>
</head>
<body style="margin-top: 125px">
<%@ include file="../segments/header.jspf" %>
<h1 style="text-align: center;color: darkgoldenrod">Twoje dane:</h1>
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
<h1 style="text-align: center;color: darkgoldenrod">Historia zamówień</h1>
<table class="cart-table">
    <thead>
    <tr>
        <th>Produkty</th>
        <th>Cena całkowita</th>
        <th>Adres</th>
        <th>Telefon</th>
        <th>Data zamówienia</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="historyInfo" items="${userOrderHistoryInfo}">
        <tr>
            <td>${historyInfo.productNames}</td>
            <td>${historyInfo.totalPrice} zł</td>
            <td>${historyInfo.address}</td>
            <td>${historyInfo.phoneNumber}</td>
            <td>${historyInfo.orderDate}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%@include file="../segments/footer.jspf" %>
</body>
</html>
