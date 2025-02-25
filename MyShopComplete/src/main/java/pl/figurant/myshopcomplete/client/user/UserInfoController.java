package pl.figurant.myshopcomplete.client.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pl.figurant.myshopcomplete.domain.api.UserInfo;
import pl.figurant.myshopcomplete.domain.api.UserInfoService;
import pl.figurant.myshopcomplete.domain.api.UserOrderHistoryInfo;

import java.io.IOException;
import java.util.List;

@WebServlet("/userinfo")
public class UserInfoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        UserInfoService userInfoService = new UserInfoService();
        UserInfo userInfo = userInfoService.getUserInfo(username);
        List <UserOrderHistoryInfo> userOrderHistoryInfo = userInfoService.getUserOrderHistoryInfo(userInfo.getEmail());
        req.setAttribute("userOrderHistoryInfo", userOrderHistoryInfo);
        req.setAttribute("userInfo", userInfo);
        req.getRequestDispatcher("WEB-INF/views/userInformation.jsp").forward(req, resp);
    }
}
