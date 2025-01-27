package pl.figurant.myshopcomplete.domain.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderCompany {
    private int id;
    private String country;
    private String NIP;
    private String companyName;
    private String email;
    private String address;
    private String postalCode;
    private String phone;
    private String productNames;
    private BigDecimal price;
    private Double shippingPrice;
    private LocalDateTime orderDate;

    public OrderCompany() {
    }

    public OrderCompany(String country, String NIP, String companyName, String email, String address, String postalCode, String phone, String productNames, BigDecimal price, Double shippingPrice, LocalDateTime orderDate) {
        this.country = country;
        this.NIP = NIP;
        this.companyName = companyName;
        this.email = email;
        this.address = address;
        this.postalCode = postalCode;
        this.phone = phone;
        this.productNames = productNames;
        this.price = price;
        this.shippingPrice = shippingPrice;
        this.orderDate = orderDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProductNames() {
        return productNames;
    }

    public void setProductNames(String productNames) {
        this.productNames = productNames;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(Double shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
