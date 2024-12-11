package pl.figurant.myshopcomplete.home;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.figurant.myshopcomplete.domain.api.CategoryInfo;
import pl.figurant.myshopcomplete.domain.api.CategoryService;

import java.io.IOException;
import java.util.List;

@WebServlet("")
public class HomeController extends HttpServlet {
    private final CategoryService categoryService= new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CategoryInfo> categoryInfos = categoryService.findAll();
        req.setAttribute("categories", categoryInfos);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
