package com.web.technical.assessment.server.dto;

import org.springframework.stereotype.Component;

@Component
public class CalculatorDTO {
    private String productId;
    private String noOfCartons;
    private String noOfUnits;
    private boolean selectedCarton;
    private boolean selectedUnit;

    public CalculatorDTO() {
    }

    public CalculatorDTO(String productId, String noOfCartons, String noOfUnits, boolean selectedCarton, boolean selectedUnit) {
        this.productId = productId;
        this.noOfCartons = noOfCartons;
        this.noOfUnits = noOfUnits;
        this.selectedCarton = selectedCarton;
        this.selectedUnit = selectedUnit;
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

    public boolean isSelectedCarton() {
        return selectedCarton;
    }

    public void setSelectedCarton(boolean selectedCarton) {
        this.selectedCarton = selectedCarton;
    }

    public boolean isSelectedUnit() {
        return selectedUnit;
    }

    public void setSelectedUnit(boolean selectedUnit) {
        this.selectedUnit = selectedUnit;
    }
}
