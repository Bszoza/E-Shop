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
    <!-- Dodaje font awesome - darmowe loga-->
    <link rel="stylesheet" href="./styles/category.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Libre+Baskerville:ital,wght@0,400;0,700;1,400&family=PT+Sans:ital,wght@0,400;0,700;1,400;1,700&display=swap"
          rel="stylesheet">
</head>
<body>

<nav class="navigation">
    <a href="${pageContext.request.contextPath}" class="logo">
        <i class="fa-solid fa-robot" style="color: #B8860B;"></i>
        <!--kod do konkretnego loga linie wyzej powrot do strony głównej -->
        Figurant
    </a>
    <aside class="categories">
        <ul>
            <c:forEach var="category" items="${requestScope.categories}">
                <li class="category"><a
                        href="${pageContext.request.contextPath.concat('/category?id=').concat(category.id)}">${category.name}</a>
                    <!--/category, wysyła żadanie do Controllera -->
                </li>
                <!--Zwróci link typu aplikacja/category?id=1 -->
            </c:forEach>
        </ul>
    </aside>
    <aside class="user-actions">
        <a href="#" class="help-link"><img src="images/help_icon.png" class="help-button" title="Pomoc"></a>
        <a href="#" class="shopping-cart"><img src="images/shopping-cart.png" class="cart-button" title="Koszyk"></a>
        <a href="#" class="login-link"><img src="images/login.png" class="login-button" title="Zaloguj"></a>
    </aside>
</nav>
<div class="top">
    <h1>${requestScope.category.name}</h1>
    <p class="category-description">${requestScope.category.description}</p>
</div>
<main>
    <c:forEach var="product" items="${requestScope.products}">
        <div class="product">
            <a href="#">
                <h2 class="product-header"><c:out value="${product.name}"/></h2>
                <img class="main_photo" title="product1" src="${product.image}">
                <p class="price">Cena: ${product.price}zł</p>
                <p class="price-discount">Cena po obniżce: <fmt:formatNumber
                        value="${product.price - (product.price * (product.discount / 100))}" type="number"
                        maxFractionDigits="2"/>zł</p>
                <p class="in-stock-discount"> W magazynie: <c:out value="${product.in_stock}"/> Obniżka: <c:out
                        value="${product.discount}"/>%</p>
                <p class="product-detail">Opis: ${product.description}</p>
                <a href="#">
                    <button class="buy-button">Kup</button>
                </a>
            </a>
        </div>

    </c:forEach>
</main>

<div class="footer">
    <p>&copy; Kacper Brzozowski. Wszelkie prawa zastrzeżone.</p>
</div>
</body>
</html>