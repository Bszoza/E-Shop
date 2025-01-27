<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Zarejestruj się na naszym sklepie</title>
    <%@ include file="../segments/stylesheets.jspf" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/forms.css">
</head>
<body>
<div class="container">
    <%@ include file="../segments/header.jspf" %>
    <form class="user-form" action="${pageContext.request.contextPath}/signup" method="post">
        <h2 class="user-form-title">Zarejestruj się na naszym sklepie</h2>
        <c:if test="${not empty errorMessage}">
            <p class="error-message">${errorMessage}</p>
        </c:if>
        <input name="name" placeholder="Imię" required>
        <input name="lastname" placeholder="Nazwisko" required>
        <input name="username" placeholder="Nazwa użytkownika" required>
        <input name="email" placeholder="email" type="email" required>
        <input name="password" placeholder="Hasło" type="password" required>
        <button class="user-form-button">Zarejestruj się</button>
    </form>
</div>
</body>
</html>
