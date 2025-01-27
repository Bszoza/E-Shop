package pl.figurant.myshopcomplete.client.cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.figurant.myshopcomplete.domain.cart.CartItem;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/remove-from-cart")
public class SubtractFromCart extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CartItem> cartItems = (List<CartItem>) req.getSession().getAttribute("cartItems");

        for (CartItem cartItemCheck : cartItems) {
            if (cartItemCheck.getProductName().equals(req.getParameter("productName"))) {
                BigDecimal newPrice = new BigDecimal(req.getParameter("productPrice"));
                newPrice = newPrice.divide(BigDecimal.valueOf(cartItemCheck.getQuantity()), 2, RoundingMode.HALF_UP);
                newPrice = new BigDecimal(req.getParameter("productPrice")).subtract(newPrice);
                cartItemCheck.setPrice(newPrice);
                cartItemCheck.setQuantity(cartItemCheck.getQuantity() - 1);
                break;
            }
        }

        String referer = req.getHeader("Referer"); //pobieram url strony z której przyszedł request
        if (referer != null) {
            resp.sendRedirect(referer);
        } else {
            resp.sendRedirect(req.getContextPath()); // Domyślnie na stronę główną, jeśli `Referer` nie jest dostępny
        }
    }
}
