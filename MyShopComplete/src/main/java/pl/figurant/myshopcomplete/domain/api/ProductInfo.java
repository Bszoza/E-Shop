package pl.figurant.myshopcomplete.domain.api;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProductInfo {
    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    private int in_stock;
    private String image1;
    private String image2;
    private String image3;
    private Double discount;


    public ProductInfo(int id, String name, String description, BigDecimal price, int in_stock, String image, Double discount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.in_stock = in_stock;
        this.image1 = image.concat("photo1.png");
        this.image2 = image.concat("photo2.png");
        this.image3 = image.concat("photo3.png");
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal calculatePrice() {
        if (discount != null && !discount.equals("0")) {
            BigDecimal discountAmount = price.multiply(BigDecimal.valueOf(discount));
            return price.subtract(discountAmount).setScale(2, RoundingMode.HALF_UP);
        } else return price;
    }

    public int getIn_stock() {
        return in_stock;
    }

    public String getImage1() {
        return image1;
    }

    public String getImage2() {
        return image2;
    }

    public String getImage3() {
        return image3;
    }

    public Double getDiscount() {
        return discount;
    }

}
