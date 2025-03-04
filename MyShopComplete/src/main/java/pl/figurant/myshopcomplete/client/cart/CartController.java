package pl.figurant.myshopcomplete.client.cart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.figurant.myshopcomplete.domain.cart.CartItem;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/cart")
public class CartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BigDecimal cartPrice = new BigDecimal("0.00");
        List<CartItem> cartItems = (List<CartItem>) req.getSession().getAttribute("cartItems");
        if (cartItems == null) {
            cartItems = List.of();
        }
        for (CartItem cartItem : cartItems) {
            cartPrice=cartPrice.add(cartItem.getPrice());
        }
        cartPrice=cartPrice.add(BigDecimal.valueOf(5.00));//wysyłka
        req.setAttribute("cartPrice", cartPrice);
        req.setAttribute("cartItems", cartItems);
        req.getRequestDispatcher("WEB-INF/views/cart.jsp").forward(req, resp);
    }

}
