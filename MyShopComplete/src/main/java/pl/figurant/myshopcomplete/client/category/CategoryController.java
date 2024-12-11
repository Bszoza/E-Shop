package pl.figurant.myshopcomplete.client.category;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.figurant.myshopcomplete.domain.api.CategoryInfo;
import pl.figurant.myshopcomplete.domain.api.CategoryService;
import pl.figurant.myshopcomplete.domain.api.ProductInfo;
import pl.figurant.myshopcomplete.domain.api.ProductService;


import java.io.IOException;
import java.util.List;

@WebServlet("/category")
public class CategoryController extends HttpServlet {
    private final CategoryService categoryService = new CategoryService();
    private final ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CategoryInfo> categoryInfos = categoryService.findAll();
        req.setAttribute("categories", categoryInfos);
        int categoryId = Integer.parseInt(req.getParameter("id"));
        CategoryInfo categoryInfo = categoryService.findById(categoryId).orElseThrow();
        req.setAttribute("category", categoryInfo);
        List<ProductInfo> productInfos = productService.findByCategoryId(categoryId);
        req.setAttribute("products", productInfos);
        req.getRequestDispatcher("/category.jsp").forward(req, resp);
    }
}
