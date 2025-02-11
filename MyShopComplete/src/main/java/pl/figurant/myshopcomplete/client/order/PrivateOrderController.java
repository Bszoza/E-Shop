package pl.figurant.myshopcomplete.client.order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.figurant.myshopcomplete.domain.api.MailSender;
import pl.figurant.myshopcomplete.domain.api.OrderService;
import pl.figurant.myshopcomplete.domain.api.PrivateOrderInfo;
import pl.figurant.myshopcomplete.domain.cart.CartItem;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/privateform")
public class PrivateOrderController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CartItem> cartItems = (List<CartItem>) req.getSession().getAttribute("cartItems");
        if (cartItems == null) {
            cartItems = new ArrayList<>();
            req.getSession().setAttribute("cartItems", cartItems);
        }
        PrivateOrderInfo order = new PrivateOrderInfo();
        order.setCountry(req.getParameter("country"));
        order.setName(req.getParameter("name"));
        order.setLastName(req.getParameter("lastName"));
        order.setEmail(req.getParameter("email"));
        order.setPhone("+" + req.getParameter("areaCode") + " " + req.getParameter("phone"));
        order.setPostalCode(req.getParameter("postalCode"));
        order.setAddress(createAddress(req.getParameter("place"), req.getParameter("street"), req.getParameter("houseNumber"), req.getParameter("localNumber")));
        String items = "";
        for (CartItem cartItem : cartItems) {
            items += cartItem.getProductName();
            items += ", ";
        }
        items = items.substring(0, items.length() - 2);//usuwam spację i przecinek który niepotrzebnie dopisuje w ostatnim kroku petli
        order.setProductNames(items);
        order.setShippingPrice(5.00);
        BigDecimal cartPrice = BigDecimal.valueOf(order.getShippingPrice());
        for (CartItem cartItem : cartItems) {
            cartPrice=cartPrice.add(cartItem.getPrice());
        }
        order.setPrice(cartPrice);
        OrderService orderService = new OrderService();
        orderService.savePrivateOrder(order);
        cartItems.clear();
        MailSender mailSender = new MailSender();
        try {
            mailSender.sendPrivateOrderConfirmation(order);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect(req.getContextPath()+"/");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/privateOrderForm.jsp").forward(req, resp);
    }

    private String createAddress(String place, String street, String houseNumber, String localNumber) {
        if (houseNumber == null || houseNumber.isEmpty()) {
            return place + " " + street + " " + localNumber;
        } else return place + " " + street + " " + houseNumber;
    }
}
