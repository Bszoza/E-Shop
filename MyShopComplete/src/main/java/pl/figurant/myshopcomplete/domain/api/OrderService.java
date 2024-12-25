package pl.figurant.myshopcomplete.domain.api;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import pl.figurant.myshopcomplete.domain.order.OrderCompany;
import pl.figurant.myshopcomplete.domain.order.OrderDao;
import pl.figurant.myshopcomplete.domain.order.OrderPrivate;
import pl.figurant.myshopcomplete.domain.user.User;

import java.time.LocalDateTime;

public class OrderService {
    private OrderDao orderDao = new OrderDao();

    public void savePrivateOrder(PrivateOrderInfo privateOrderInfo) {
        OrderPrivate order = MapperPrivateOrder.map(privateOrderInfo);
        orderDao.savePrivateOrder(order);
    }

    public void saveCompanyOrder(CompanyOrderInfo companyOrderInfo) {
        OrderCompany order = MapperCompanyOrder.map(companyOrderInfo);
        orderDao.saveCompanyOrder(order);
    }

    private static class MapperPrivateOrder {
        static OrderPrivate map(PrivateOrderInfo privateOrderInfo) {
            return new OrderPrivate(
                    privateOrderInfo.getCountry(), privateOrderInfo.getName(), privateOrderInfo.getLastName(),
                    privateOrderInfo.getEmail(), privateOrderInfo.getAddress(), privateOrderInfo.getPostalCode(),
                    privateOrderInfo.getPhone(), privateOrderInfo.getProductNames(), privateOrderInfo.getPrice(),
                    privateOrderInfo.getShippingPrice(), LocalDateTime.now()
            );
        }
    }

    private static class MapperCompanyOrder {
        static OrderCompany map(CompanyOrderInfo companyOrderInfo) {
            return new OrderCompany(
                    companyOrderInfo.getCountry(), companyOrderInfo.getNIP(), companyOrderInfo.getCompanyName(),
                    companyOrderInfo.getEmail(), companyOrderInfo.getAddress(), companyOrderInfo.getPostalCode(),
                    companyOrderInfo.getPhone(), companyOrderInfo.getProductNames(), companyOrderInfo.getPrice(),
                    companyOrderInfo.getShippingPrice(), LocalDateTime.now()
            );
        }
    }

}
