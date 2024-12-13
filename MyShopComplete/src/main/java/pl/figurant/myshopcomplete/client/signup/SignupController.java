package pl.figurant.myshopcomplete.client.signup;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.figurant.myshopcomplete.domain.api.UserRegistration;
import pl.figurant.myshopcomplete.domain.api.UserService;

import java.io.IOException;

@WebServlet("/signup")
public class SignupController extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRegistration userRegistration = getUserData(req);
        userService.registerUser(userRegistration);
        resp.sendRedirect(req.getContextPath());
    }

    //String name, String lastName, String email, String password, String username, LocalDate registrationDate
    private UserRegistration getUserData(HttpServletRequest request) {
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        return new UserRegistration(name, lastname, username, email, password);
    }
}
