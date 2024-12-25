<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>formularz</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/0aada522c4.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/forms.css">
    <%@include file="../segments/stylesheets.jspf" %>
</head>
<body>
<%@ include file="../segments/header.jspf" %>
<form class="user-form" method="post" action="${pageContext.request.contextPath}/companyform">
    <select name="country" required>
        <option value="pl">Polska (PL)</option>
        <option value="de">Niemcy (DE)</option>
        <option value="us">USA (US)</option>
    </select>
    <input name="NIP" placeholder="NIP" required>
    <input name="name" placeholder="Nazwa firmy" required>
    <input name="email" placeholder="email" type="email" required>
    <input name="street" placeholder="ulica" required>
    <input name="houseNumber" placeholder="Nr domu" required>
    <input name="localNumber" placeholder="Nr lokalu">
    <input type="text" name="postalCode" required pattern="[0-9]{2}-[0-9]{3}" placeholder="__-___">
    <input type="text" name="place" required>
    <select name="areaCode" required>
        <option value="48">Polska (+48)</option>
        <option value="49">Niemcy (+49)</option>
        <option value="1">USA (+1)</option>
    </select>
    <input type="tel" name="phone" required placeholder="___ ___ ___">
    <button class="user-form-button" type="submit">Wyślij formularz</button>
</form>
<%@ include file="../segments/header.jspf" %>
</body>
</html>
