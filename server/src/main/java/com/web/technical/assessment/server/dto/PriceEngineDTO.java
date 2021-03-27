package com.web.technical.assessment.server.dto;

import org.springframework.stereotype.Component;

@Component
public class PriceEngineDTO {
    private String productId;
    private String noOfCartons;
    private String noOfUnits;

    public PriceEngineDTO() {
    }

    public PriceEngineDTO(String productId, String noOfCartons, String noOfUnits) {
        this.productId = productId;
        this.noOfCartons = noOfCartons;
        this.noOfUnits = noOfUnits;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getNoOfCartons() {
        return noOfCartons;
    }

    public void setNoOfCartons(String noOfCartons) {
        this.noOfCartons = noOfCartons;
    }

    public String getNoOfUnits() {
        return noOfUnits;
    }

    public void setNoOfUnits(String noOfUnits) {
        this.noOfUnits = noOfUnits;
    }
}
