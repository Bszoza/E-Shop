<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Potwierdzenie e-mail</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/forms.css">
    <%@ include file="../segments/stylesheets.jspf" %>
</head>
<body>
<%@ include file="../segments/header.jspf" %>

<div class="user-form">
    <h1 class="user-form-title">Potwierdzenie adresu e-mail</h1>
    <p class="category-description">Podaj kod, który wysłaliśmy Ci na Twój adres e-mail</p>

    <!-- Wyświetlanie komunikatu błędu, jeśli istnieje -->
    <c:if test="${not empty errorMessage}">
        <p class="error-message">${errorMessage}</p>
    </c:if>

    <form action="${pageContext.request.contextPath}/signup" method="GET" class="form-container">
        <input
                class="form-input"
                type="text"
                name="verificationCode"
                pattern="\d{6}"
                maxlength="6"
                required
                placeholder="Wpisz 6-cyfrowy kod"
        >
        <button type="submit" class="user-form-button">Potwierdź</button>
    </form>
</div>

<%@ include file="../segments/footer.jspf" %>
</body>
