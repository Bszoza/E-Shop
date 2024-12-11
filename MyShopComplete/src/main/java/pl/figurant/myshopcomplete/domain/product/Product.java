package pl.figurant.myshopcomplete.domain.product;

public class Product {
    private Integer id;
    private String name;
    private String description;
    private double price;
    private int in_stock;
    private String image;
    private Integer category_id;
    private Double discount;

    public Product(Integer id, String name, String description, double price, int in_stock, String image, Integer category_id, Double discount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.in_stock = in_stock;
        this.image = image;
        this.category_id = category_id;
        this.discount = discount;
    }
    public Integer getId() {
        return id;
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


    public Integer getCategory_id() {
        return category_id;
    }


    public Double getDiscount() {
        return discount;
    }

    public String getImage() {
        return image;
    }

}
