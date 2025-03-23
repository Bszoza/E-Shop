package pl.figurant.myshopcomplete.client.signup;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.figurant.myshopcomplete.domain.api.MailSender;
import pl.figurant.myshopcomplete.domain.api.UserRegistration;
import pl.figurant.myshopcomplete.domain.api.UserService;
import java.io.IOException;
import java.util.Random;

@WebServlet("/signup")
public class SignupController extends HttpServlet {
    private final UserService userService = new UserService();
    UserRegistration userRegistration;
    String code = "";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String verificationCode = req.getParameter("verificationCode");

        
        if (verificationCode != null) {
            if (verificationCode.equals(code)) {
                userService.registerUser(userRegistration);
                req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
                return;
            } else {
                req.setAttribute("errorMessage", "Nieprawidłowy kod weryfikacyjny. Podaj kod ponownie.");
                req.getRequestDispatcher("/WEB-INF/views/emailConfirmation.jsp").forward(req, resp); 
                return;
            }
        }

        
        req.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userRegistration = getUserData(req);

      
        if (userService.getemails().contains(userRegistration.getEmail())) {
            req.setAttribute("errorMessage", "Istnieje już konto z tym adresem e-mail.");
            req.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(req, resp);
            return;
        }
      
        if (userService.getUsernames().contains(userRegistration.getUsername())) {
            req.setAttribute("errorMessage", "Istnieje już konto z tym username.");
            req.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(req, resp);
            return;
        }

        code = generateCode();
        MailSender mailSender = new MailSender();
        try {
            String basePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
            mailSender.sendAccountConfirmation(userRegistration, basePath,code);
            req.getRequestDispatcher("/WEB-INF/views/emailConfirmation.jsp").forward(req, resp); 
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private UserRegistration getUserData(HttpServletRequest request) {
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        return new UserRegistration(name, lastname, username, email, password);
    }

    private String generateCode() {
        Random rand = new Random();
        String code = "";
        for (int i = 0; i < 6; i++) {
            code += rand.nextInt(10);
        }
        return code;
    }
}
