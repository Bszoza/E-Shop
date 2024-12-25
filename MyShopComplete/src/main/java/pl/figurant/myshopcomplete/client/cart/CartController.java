package pl.figurant.myshopcomplete.client.cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.figurant.myshopcomplete.domain.cart.CartItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart")
public class CartController extends HttpServlet {
    //ArrayList<CartItem> cartItems = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Double cartPrice = 0.00;
        List<CartItem> cartItems = (List<CartItem>) req.getSession().getAttribute("cartItems");
        if (cartItems == null) {
            cartItems = List.of();
        }
        for (CartItem cartItem : cartItems) {
            cartPrice+=cartItem.getPrice();
        }
        req.setAttribute("cartPrice", cartPrice);
        req.setAttribute("cartItems", cartItems);
        req.getRequestDispatcher("WEB-INF/views/cart.jsp").forward(req, resp);
    }

}
