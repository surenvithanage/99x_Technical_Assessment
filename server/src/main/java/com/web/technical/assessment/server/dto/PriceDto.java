package com.web.technical.assessment.server.dto;

import org.springframework.stereotype.Component;

@Component
public class PriceDto {
    private String price;

    public PriceDto() {
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
