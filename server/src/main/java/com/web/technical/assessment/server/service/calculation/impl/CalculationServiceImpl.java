package com.web.technical.assessment.server.service.calculation.impl;

import com.web.technical.assessment.server.bean.keyvalue.KeyValueBean;
import com.web.technical.assessment.server.bean.response.ResponseBean;
import com.web.technical.assessment.server.dto.CalculatorDTO;
import com.web.technical.assessment.server.dto.PriceDto;
import com.web.technical.assessment.server.mapping.Product;
import com.web.technical.assessment.server.repository.ProductRepository;
import com.web.technical.assessment.server.service.calculation.CalculationService;
import com.web.technical.assessment.server.service.product.impl.ProductServiceImpl;
import com.web.technical.assessment.server.utility.varlist.CodeVarList;
import com.web.technical.assessment.server.utility.varlist.MessageVarList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CalculationServiceImpl implements CalculationService {
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    ProductRepository productRepository;

    @Override
    public ResponseBean calculate(CalculatorDTO calculatorDTO) {
        ResponseBean responseBean = new ResponseBean();
        PriceDto priceDto = new PriceDto();
        try {
            Optional<Product> productList = productRepository.findById(Long.valueOf(calculatorDTO.getProductId()));
            if (productList.isPresent()) {
                Product product = productList.get();
                if (calculatorDTO.isSelectedCarton()) {
                    double priceOfCarton = product.getPricePerCarton();
                    // check if eligible for the discount
                    if (Double.parseDouble(calculatorDTO.getNoOfCartons()) >= product.getDiscountQty()) {
                        // calculating the discount
                        double discount = product.getPricePerCarton() * product.getDiscount() / 100;
                        priceDto.setPrice(String.valueOf((Double.parseDouble(calculatorDTO.getNoOfCartons()) * priceOfCarton) - discount));
                    } else {
                        // calculating the total cost without the discount
                        priceDto.setPrice(String.valueOf(Double.parseDouble(calculatorDTO.getNoOfCartons()) * priceOfCarton));
                    }
                    responseBean.setRequestOk(true);
                    KeyValueBean kvListUserData = new KeyValueBean(CodeVarList.CODE_PRICE_DATA, priceDto);
                    responseBean.setErrorCode("S");
                    responseBean.setData(kvListUserData);
                } else if (calculatorDTO.isSelectedUnit()) {
                    double priceOfUnit = product.getUnitPrice();
                    int numberOfCartons = Integer.parseInt(calculatorDTO.getNoOfUnits()) / product.getUnit();
                    int numberOfUnits = Integer.parseInt(calculatorDTO.getNoOfUnits()) % product.getUnit();
                    double discountAmount = 0.0;
                    if (numberOfCartons > 0) {
                        // calculating the discount amount
                        if (numberOfCartons >= product.getDiscountQty()) {
                            discountAmount = product.getPricePerCarton() * product.getDiscount() / 100;
                        }
                        // total amount
                        double totalAmount = (Double.parseDouble(calculatorDTO.getNoOfUnits()) * priceOfUnit) + (numberOfUnits * product.getUnitPrice()) - discountAmount;
                        priceDto.setPrice(String.valueOf(totalAmount));
                    } else {
                        // manual labour charges
                        double compensateAmount = (product.getPricePerCarton() * product.getCompensate()) / 100;
                        priceDto.setPrice(String.valueOf((Double.parseDouble(calculatorDTO.getNoOfUnits()) * priceOfUnit) + compensateAmount));
                    }
                    responseBean.setRequestOk(true);
                    KeyValueBean kvListUserData = new KeyValueBean(CodeVarList.CODE_PRICE_DATA, priceDto);
                    responseBean.setErrorCode("S");
                    responseBean.setData(kvListUserData);
                } else {
                    responseBean.setRequestOk(false);
                    responseBean.setErrorCode("E");
                    responseBean.setMessage(MessageVarList.TYPE_NOT_SELECTED_ERROR_MSG);
                }
            } else {
                responseBean.setRequestOk(false);
                responseBean.setErrorCode("E");
                responseBean.setMessage(MessageVarList.PRICE_CALCULATION_ERROR_MSG);
            }
        } catch (NumberFormatException e) {
            logger.error("Exception : " + e);
            responseBean.setRequestOk(false);
            responseBean.setErrorCode("E");
            responseBean.setMessage(MessageVarList.COMMON_ERROR_MSG);
        }
        return responseBean;
    }
}
