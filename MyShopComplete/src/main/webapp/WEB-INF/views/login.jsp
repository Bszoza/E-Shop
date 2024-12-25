
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Zaloguj się</title>
    <%@ include file="../segments/stylesheets.jspf" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/forms.css">
</head>
<body>
<div class="container">
    <%@ include file="../segments/header.jspf" %>

    <form action="j_security_check" method="post" class="user-form">
        <h2 class="user-form-title">Zaloguj się do sklepu</h2>
        <input name="j_username" placeholder="Nazwa użytkownika" required>
        <input name="j_password" placeholder="Hasło" type="password" required>
        <button class="user-form-button">Zaloguj się</button>
        <a class="register_text" href="${pageContext.request.contextPath}/signup">Zarejestruj się</a>
    </form>

    <%@ include file="../segments/footer.jspf" %>
</div>
</body>
</html>