<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>${requestScope.product.name}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/0aada522c4.js" crossorigin="anonymous"></script>
    <script src="../jscripts/modal.js"></script>
    <%@include file="../segments/stylesheets.jspf" %>
</head>
<body>
    <%@ include file="../segments/header.jspf" %>
<main>
    <h1>${requestScope.product.name}</h1>
    <p class="price-discount">Cena: <s>${product.price}zł </s><fmt:formatNumber
            value="${product.price - (product.price * (product.discount / 100))}" type="number"
            maxFractionDigits="2"/>zł</p>
    <p class="in-stock"> W magazynie: <c:out value="${product.in_stock}"/></p>
    <p class="discount">Obniżka: <c:out value="${product.discount}"/>%</p>
    <p class="product-detail">Opis: ${product.description}</p>
</main>
<%@include file="../segments/footer.jspf" %>
>
</body>
</html>