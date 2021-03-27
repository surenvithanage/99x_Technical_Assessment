package com.web.technical.assessment.server.mapping;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class Product implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String name;
    private int unit;
    private double pricePerCarton;
    private double unitPrice;
    private int compensate;
    private int discountQty;
    private int discount;

    public Product() {
    }

    public Product(Long id, String code, String name, int unit, double pricePerCarton, double unitPrice, int compensate, int discountQty, int discount) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.unit = unit;
        this.pricePerCarton = pricePerCarton;
        this.unitPrice = unitPrice;
        this.compensate = compensate;
        this.discountQty = discountQty;
        this.discount = discount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public double getPricePerCarton() {
        return pricePerCarton;
    }

    public void setPricePerCarton(double pricePerCarton) {
        this.pricePerCarton = pricePerCarton;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getCompensate() {
        return compensate;
    }

    public void setCompensate(int compensate) {
        this.compensate = compensate;
    }

    public int getDiscountQty() {
        return discountQty;
    }

    public void setDiscountQty(int discountQty) {
        this.discountQty = discountQty;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
