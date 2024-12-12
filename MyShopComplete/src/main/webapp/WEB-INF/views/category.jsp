<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>${requestScope.category.name}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/0aada522c4.js" crossorigin="anonymous"></script>
    <script src="../jscripts/modal.js"></script>
    <%@include file="../segments/stylesheets.jspf" %>
</head>
<body>
<%@ include file="../segments/header.jspf" %>
<div class="top">
    <h1>${requestScope.category.name}</h1>
    <p class="category-description">${requestScope.category.description}</p>
</div>
<main>
    <c:forEach var="product" items="${requestScope.products}">
        <div class="product">
            <a href="${pageContext.request.contextPath.concat('/product?id=').concat(product.id)}">
                <h2 class="product-header"><c:out value="${product.name}"/></h2>
                <div class="images">
                    <img class="main_photo" title="product" src="${product.image1}">
                    <img class="additional-photos" title="product" src="${product.image2}">
                    <img class="additional-photos" title="product" src="${product.image3}">
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
                <a href="${pageContext.request.contextPath.concat('/product?id=').concat(product.id)}">
                    <button class="buy-button">Wyświetl</button>
                </a>
            </a>
        </div>
    </c:forEach>
</main>
<%@include file="../segments/footer.jspf" %>
>
</body>
</html>