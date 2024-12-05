package pl.figurant.myshopcomplete.domain.api;

public class ProductInfo {
    private String name;
    private String description;
    private double price;
    private int in_stock;
    private String image;
    private Double discount;
    private String url;

    public ProductInfo(String name, String description, double price, int in_stock, String image, Double discount, String url) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.in_stock = in_stock;
        this.image = image;
        this.discount = discount;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getIn_stock() {
        return in_stock;
    }

    public String getImage() {
        return image;
    }

    public Double getDiscount() {
        return discount;
    }

    public String getUrl() {
        return url;
    }
}
