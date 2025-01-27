package pl.figurant.myshopcomplete.domain.cart;

import java.math.BigDecimal;

public class CartItem {
    private BigDecimal price;
    private Integer quantity;
    private String productName;
    public CartItem() {
    }

    public CartItem(BigDecimal price, Integer quantity, String productName) {
        this.price = price;
        this.quantity = quantity;
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
