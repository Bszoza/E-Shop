package pl.figurant.myshopcomplete.domain.api;

import java.math.BigDecimal;

public class CompanyOrderInfo {
    private String country;
    private String companyName;
    private String NIP;
    private String email;
    private String address;
    private String postalCode;
    private String areaCode;
    private String phone;
    private String productNames;
    private BigDecimal price;
    private Double shippingPrice;

    public CompanyOrderInfo() {
    }

    public CompanyOrderInfo(String country, String companyName, String NIP, String email, String address, String postalCode, String areaCode, String phone, String productNames, BigDecimal price, Double shippingPrice) {
        this.country = country;
        this.companyName = companyName;
        this.NIP = NIP;
        this.email = email;
        this.address = address;
        this.postalCode = postalCode;
        this.areaCode = areaCode;
        this.phone = phone;
        this.productNames = productNames;
        this.price = price;
        this.shippingPrice = shippingPrice;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
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

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
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

    @Override
    public String toString() {
        return "Firma: " + companyName + "\nAdres: "+address + "\nKod pocztowy: " + postalCode + "\nCena produktów: " + price + "\nCena wysyłki: 5zł" + "\nProdukty: " + productNames;
    }
}
