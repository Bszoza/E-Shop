package pl.figurant.myshopcomplete.client.order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.figurant.myshopcomplete.domain.api.CompanyOrderInfo;
import pl.figurant.myshopcomplete.domain.api.OrderService;
import pl.figurant.myshopcomplete.domain.cart.CartItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/companyform")
public class CompanyOrderController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CartItem> cartItems = (List<CartItem>) req.getSession().getAttribute("cartItems");
        if (cartItems == null) {
            cartItems = new ArrayList<>();
            req.getSession().setAttribute("cartItems", cartItems);
        }
        CompanyOrderInfo order = new CompanyOrderInfo();
        order.setCountry(req.getParameter("country"));
        order.setCompanyName(req.getParameter("name"));
        order.setNIP(req.getParameter("NIP"));
        order.setEmail(req.getParameter("email"));
        order.setPhone("+" + req.getParameter("areaCode") + " " + req.getParameter("phone"));
        order.setPostalCode(req.getParameter("postalCode"));
        order.setAddress(createAddress(req.getParameter("place"), req.getParameter("street"), req.getParameter("houseNumber"), req.getParameter("localNumber")));
        String items = "";
        for (CartItem cartItem : cartItems) {
            items += cartItem.getProductName();
            items += ", ";
        }
        order.setProductNames(items);
        order.setShippingPrice(5.00);
        Double cartPrice = 0.00;
        for (CartItem cartItem : cartItems) {
            cartPrice += cartItem.getPrice();
        }
        order.setPrice(cartPrice);
        OrderService orderService = new OrderService();
        orderService.saveCompanyOrder(order);
        resp.sendRedirect(req.getContextPath()+"/");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/companyOrderForm.jsp").forward(req, resp);
    }

    private String createAddress(String place, String street, String houseNumber, String localNumber) {
        if (houseNumber == null || houseNumber.isEmpty()) {
            return place + " " + street + " " + localNumber;
        } else return place + " " + street + " " + houseNumber;
    }
}
