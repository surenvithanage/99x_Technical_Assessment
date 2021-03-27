package com.web.technical.assessment.server.dto;

import org.springframework.stereotype.Component;

@Component
public class ProductDTO {
    private String id;
    private String code;
    private String name;
    private String unit;
    private String pricePerCarton;
    private String unitPrice;
    private String compensate;
    private String discountQty;
    private String discount;

    public ProductDTO() {
    }

    public ProductDTO(String id, String code, String name, String unit, String pricePerCarton, String unitPrice, String compensate, String discountQty, String discount) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getPricePerCarton() {
        return pricePerCarton;
    }

    public void setPricePerCarton(String pricePerCarton) {
        this.pricePerCarton = pricePerCarton;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getCompensate() {
        return compensate;
    }

    public void setCompensate(String compensate) {
        this.compensate = compensate;
    }

    public String getDiscountQty() {
        return discountQty;
    }

    public void setDiscountQty(String discountQty) {
        this.discountQty = discountQty;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
