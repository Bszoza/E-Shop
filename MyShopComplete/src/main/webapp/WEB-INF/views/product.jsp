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
    <div class="product">
        <h1>${requestScope.product.name}</h1>
        <div class="images">
            <img class="main-photo-product" title="product" src="${product.image1}">
            <img class="additional-photos-product" title="product" src="${product.image2}">
            <img class="additional-photos-product" title="product" src="${product.image3}">
        </div>
        <c:choose>
            <c:when test="${product.discount>0.0}">
                <p class="price-discount">Cena: <s>${product.price}zł </s><fmt:formatNumber
                        value="${product.price - (product.price * (product.discount / 100))}" type="number"
                        maxFractionDigits="2"/>zł</p>
            </c:when>
            <c:otherwise>
                <p class="price-discount"><c:out value="${product.price}"/>zł</p>
            </c:otherwise>
        </c:choose>
        <p class="discount">Obniżka: <c:out value="${product.discount}"/>%</p>
        <p class="in-stock"> W magazynie: <c:out value="${product.in_stock}"/></p>
        <p class="product-detail">Opis: ${product.description}</p>
        <a href="#">
            <button class="add-cart">Do koszyka</button>
        </a>
    </div>
</main>
<%@include file="../segments/footer.jspf" %>
>
</body>
</html>