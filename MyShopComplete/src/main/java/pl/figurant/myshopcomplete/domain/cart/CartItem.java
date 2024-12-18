package pl.figurant.myshopcomplete.domain.cart;

public class CartItem {
    private Double price;
    private Integer quantity;
    private String productName;
    public CartItem() {
    }

    public CartItem(Double price, Integer quantity, String productName) {
        this.price = price;
        this.quantity = quantity;
        //this.productId = productId;
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
