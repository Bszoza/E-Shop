package pl.figurant.myshopcomplete.client.cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.figurant.myshopcomplete.domain.cart.CartItem;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/add-to-cart")
public class AddToCartController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CartItem> cartItems = (List<CartItem>) req.getSession().getAttribute("cartItems");
        if (cartItems == null) {
            cartItems = new ArrayList<>();
            req.getSession().setAttribute("cartItems", cartItems);
        }
        boolean typeAlreadyIn = false;
        if (!typeAlreadyIn) {
            for (CartItem cartItemCheck : cartItems) {
                if (cartItemCheck.getProductName().equals(req.getParameter("productName"))) {
                    typeAlreadyIn = true;
                    BigDecimal newPrice = new BigDecimal(req.getParameter("productPrice"));
                    newPrice = newPrice.divide(new BigDecimal(cartItemCheck.getQuantity())).setScale(2, BigDecimal.ROUND_HALF_UP);
                    newPrice = new BigDecimal(req.getParameter("productPrice")).add(newPrice);
                    cartItemCheck.setPrice(newPrice);
                    cartItemCheck.setQuantity(1 + cartItemCheck.getQuantity());
                    break;
                }
            }
            if (!typeAlreadyIn) {
                CartItem cartItem = new CartItem();
                cartItem.setProductName(req.getParameter("productName"));
                cartItem.setPrice(new BigDecimal(req.getParameter("productPrice")));
                cartItem.setQuantity(1);
                cartItems.add(cartItem);
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
