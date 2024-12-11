<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Figurant Sklep</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/0aada522c4.js" crossorigin="anonymous"></script> <!-- Dodaje font awesome - darmowe loga-->
    <link rel="stylesheet" href="./styles/main.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Libre+Baskerville:ital,wght@0,400;0,700;1,400&family=PT+Sans:ital,wght@0,400;0,700;1,400;1,700&display=swap" rel="stylesheet">
</head>
<body>

<nav class="navigation">
    <a href="${pageContext.request.contextPath}" class="logo">
        <i class="fa-solid fa-robot" style="color: #B8860B;"></i><!--kod do konkretnego loga-->
            Figurant
    </a>
    <aside class="categories">
        <ul>
        <c:forEach var="category" items="${requestScope.categories}">
            <li class="category"><a href="${pageContext.request.contextPath.concat('/category?id=').concat(category.id)}">${category.name}</a></li><!--Zwróci link typu aplikacja/category?id=1 -->
        </c:forEach>
        </ul>
    </aside>
    <aside class="user-actions">
        <a href="#" class="help-link"><img src="images/help_icon.png" class="help-button" title="Pomoc"></a>
        <a href="#" class="shopping-cart"><img src="images/shopping-cart.png" class="cart-button" title="Koszyk"></a>
        <a href="#" class="login-link"><img src="images/login.png" class="login-button" title="Zaloguj"></a>
    </aside>
</nav>

<div class="flag-products">
    <section class="flag-Product-top">
        <!-- <p class="image-text-top">Sprawdź LEGO Technic Porsche 911 RSR.</br>Autentyczna replika powstała we współpracy z firmą Porsche.</br>Prezentuje majestatyczny wygląd i ostrą sylwetkę samochodu.</br><a href="#" class="flag-product1-buy-button" title="buy product 1"><button>Kup teraz</button></a></p>!-->
         <img title="product1" src="images/figurka6.jpg" class="flag-product-image1">
         <img title="product2" src="images/figurka2.png" class="flag-product-image1">
     </section>
 <!--
     <section class="flag-Product-mid">
         <p class="image-text">Gundam Dynames z Gundam 00 w wersji Master Grade!</br>Z łatwością odtworzy kultowe pozy snajpera, jest kompatybilny zjednostkami LED.</br>Posiada gimmick głowy i rozkładane osłony GN Full.</br><a href="#" class="flag-product2-buy-button" title="buy product 2"><button>Kup teraz</button></a></p>
         <img title="Gundam Dynames" src="images/figurka5.jpg" class="flag-product-image2">
     </section>

     <section class="flag-Product-bot">
         <p class="image-text">Wing Gundam Zero EW Ver. Ka.</br>Przeszedł intensywne badania na potrzeby pozowania.</br>Nowa funkcja umożliwia przechowywanie karabinów Twin Buster w skrzydłach.</br><a href="#" class="flag-product3-buy-button" title="buy product 3"><button>Kup teraz</button></a></p>
         <img title="Gundam Wing" src="images/figurka4.jpg" class="flag-product-image3">
     </section>
     !-->
</div>
<div class="footer">
    <p>&copy; Kacper Brzozowski. Wszelkie prawa zastrzeżone.</p>
</div>
</body>
</html>