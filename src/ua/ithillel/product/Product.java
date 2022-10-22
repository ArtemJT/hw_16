package ua.ithillel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Product {

    private final ProductTypes type;
    private final Integer id;
    private Double price;
    private Integer discount;
    private final String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd-HH:mm:ss"));

    public Product(ProductTypes type, Integer id, Double price) {
        this.type = type;
        this.id = id;
        this.price = price;
        ProductList.add(this);
    }

    public Product(ProductTypes type, Integer id, Double price, Integer discount) {
        this(type, id, price);
        this.discount = discount;
        setDiscount(discount);
    }

    public String getType() {
        return type.name();
    }

    public Double getPrice() {
        return price;
    }

    public Integer getId() {
        return id;
    }

    public Integer getDiscount() {
        return discount;
    }

    public String getDate() {
        return date;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDiscount(Integer discount) {
        Double newPrice = price - (price * discount / 100);
        Product prod = ProductList.getProduct(this);
        if (prod != null) prod.setPrice(newPrice);
    }

    @Override
    public String toString() {
        String withDiscount = "Product{type=%s, id=%d, price=%.2f, discount=%d%%, date='%s'}";
        String withoutDiscount = "Product{type=%s, id=%d, price=%.2f, date='%5$s'}";
        String formatPattern = discount != null ? withDiscount : withoutDiscount;
        return String.format(Locale.US, formatPattern, type, id, price, discount, date);
    }
}
