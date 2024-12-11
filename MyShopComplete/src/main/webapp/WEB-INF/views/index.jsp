<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Figurant Sklep</title>
    <script src="https://kit.fontawesome.com/0aada522c4.js" crossorigin="anonymous"></script> <!-- Dodaje font awesome - darmowe loga-->
    <%@include file="../segments/stylesheets.jspf"%>
</head>
<body>
<%@ include file="../segments/header.jspf"%>
<div class="flag-products">
    <section class="flag-Product-top">
        <!-- <p class="image-text-top">Sprawdź LEGO Technic Porsche 911 RSR.</br>Autentyczna replika powstała we współpracy z firmą Porsche.</br>Prezentuje majestatyczny wygląd i ostrą sylwetkę samochodu.</br><a href="#" class="flag-product1-buy-button" title="buy product 1"><button>Kup teraz</button></a></p>!-->
         <img title="product1" src="images/figurka6.jpg" class="flag-product-image1">
         <img title="product2" src="images/figurka2.png" class="flag-product-image1">
     </section>

</div>
<div class="footer">
    <%@include file="../segments/footer.jspf"%>
</div>
</body>
</html>