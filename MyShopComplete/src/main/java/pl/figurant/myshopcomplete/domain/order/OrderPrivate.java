package pl.figurant.myshopcomplete.domain.order;

import java.time.LocalDateTime;

public class OrderPrivate {
    private int id;
    private String country;
    private String name;
    private String lastName;
    private String email;
    private String address;
    private String postalCode;
    private String phone;
    private String productNames;
    private Double price;
    private Double shippingPrice;
    private LocalDateTime orderDate;

    public OrderPrivate() {
    }

    public OrderPrivate(String country, String name, String lastName, String email, String address, String postalCode, String phone, String productNames, Double price, Double shippingPrice, LocalDateTime orderDate) {
        this.country = country;
        this.name = name;
        this.lastName = lastName;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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
