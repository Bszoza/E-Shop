package pl.figurant.myshopcomplete.client.authentication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;

@WebServlet("/login")
@ServletSecurity(
        httpMethodConstraints = {@HttpMethodConstraint(value = "GET", rolesAllowed = "USER")}
)

public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Principal userPrincipal = req.getUserPrincipal();
        if (userPrincipal != null) {
            HttpSession session = req.getSession();
            session.setAttribute("username", userPrincipal.getName());
        }
        resp.sendRedirect(req.getContextPath());
    }
}
