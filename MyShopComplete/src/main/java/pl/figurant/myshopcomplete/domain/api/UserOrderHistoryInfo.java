package pl.figurant.myshopcomplete.domain.api;

import java.math.BigDecimal;
import java.sql.Date;

public class UserOrderHistoryInfo {
    private String productNames;
    private Date orderDate;
    private BigDecimal totalPrice;
    private String address;
    private String phoneNumber;

    public UserOrderHistoryInfo(String productNames, Date orderDate, BigDecimal totalPrice, String address, String phoneNumber) {
        this.productNames = productNames;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getProductNames() {
        return productNames;
    }

    public void setProductNames(String productNames) {
        this.productNames = productNames;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
