package com.engeto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//public class Purchase {
//
//    public enum Category{ OTHERS,FOOD,CONSUMABLES}
//    private Category category;
//    private String description;
//    private LocalDate purchaseDate;
//    private Double price;
//
//    public Purchase(Category category, String description, LocalDate purchaseDate, Double price) {
//        this.category = category;
//        this.description = description;
//        this.purchaseDate = purchaseDate;
//        this.price = price;
//    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public LocalDate getPurchaseDate() {
//        return purchaseDate;
//    }
//
//    public void setPurchaseDate(LocalDate purchaseDate) {
//        this.purchaseDate = purchaseDate;
//    }
//
//    public Double getPrice() {
//        return price;
//    }
//
//    public void setPrice(Double price) {
//        this.price = price;
//    }
//
//    @Override
//    public String toString() {
//        return "Purchase{" +
//                "category=" + category +
//                ", description='" + description + '\'' +
//                ", purchaseDate=" + purchaseDate +
//                ", price=" + price +
//                '}';
//    }
//}
import java.math.BigDecimal;
import java.time.LocalDate;

public class Purchase {
    private String description;
    private Category category = Category.OTHERS;
    private BigDecimal price;
    private LocalDate purchaseDate;

    // Alt+Insert => Generate...

    public Purchase(String description, Category category, BigDecimal price, LocalDate purchaseDate) {
        this.description = description;
        this.category = category;
        this.price = price;
        this.purchaseDate = purchaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "description='" + description + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
