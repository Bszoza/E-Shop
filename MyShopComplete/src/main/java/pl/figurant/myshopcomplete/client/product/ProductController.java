package pl.figurant.myshopcomplete.client.product;

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

@WebServlet("/product")
public class ProductController extends HttpServlet {
    private final ProductService productService = new ProductService();
    private final CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CategoryInfo> categoryInfos = categoryService.findAll();
        req.setAttribute("categories", categoryInfos);
        int categoryId = Integer.parseInt(req.getParameter("id"));
        CategoryInfo categoryInfo = categoryService.findById(categoryId).orElseThrow();
        int id = Integer.parseInt(req.getParameter("id"));
        ProductInfo productInfo = productService.findById(id).orElseThrow();
        req.setAttribute("product", productInfo);
        req.getRequestDispatcher("WEB-INF/views/product.jsp").forward(req, resp);
    }
}
