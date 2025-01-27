<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Koszyk</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/0aada522c4.js" crossorigin="anonymous"></script>
    <script src="../jscripts/modal.js"></script>
    <%@include file="../segments/stylesheets.jspf" %>
</head>
<body>
<%@ include file="../segments/header.jspf" %>
<main class="cart-content">
    <h1>Koszyk</h1>
    <h1>Cena całkowita (+5zł za wysyłkę): ${requestScope.cartPrice} zł</h1>
    <table class="cart-table">
        <thead>
        <tr>
            <th>Nazwa</th>
            <th>Cena</th>
            <th>Ilość</th>
            <th>Dodaj</th>
            <th>Usuń</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cartItem" items="${requestScope.cartItems}">
            <tr>
                <td>${cartItem.productName}</td>
                <td>${cartItem.price} zł</td>
                <td>${cartItem.quantity}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/add-to-cart" method="post">
                        <input type="hidden" name="productName" value="${cartItem.productName}">
                        <input type="hidden" name="productPrice" value="${cartItem.price}">
                        <button class="button-add" type="submit">Dodaj</button>
                    </form>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${cartItem.quantity>0}">
                            <form action="${pageContext.request.contextPath}/remove-from-cart" method="post">
                                <input type="hidden" name="productName" value="${cartItem.productName}">
                                <input type="hidden" name="productPrice" value="${cartItem.price}">
                                <button class="button-remove" type="submit">Usuń</button>
                            </form>
                        </c:when>
                        <c:otherwise>
                            <button class="remove-cart" disabled>Usuń</button>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a>Koszt wysyłki wynosi </a>
    <c:choose>
        <c:when test="${not empty cartItems}">
            <form action="${pageContext.request.contextPath}/privateform" method="get">
                <button class="order-button" type="submit">Zamów prywatnie</button>
            </form>
            <form action="${pageContext.request.contextPath}/companyform" method="get">
                <button class="order-button" type="submit">Weź na fakturę</button>
            </form>
        </c:when>
        <c:otherwise>
            <h1>Koszyk jest pusty</h1>
        </c:otherwise>
    </c:choose>
</main>
<%@include file="../segments/footer.jspf" %>
</body>
</html>