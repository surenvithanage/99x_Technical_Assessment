package com.web.technical.assessment.server.service.calculation;

import com.web.technical.assessment.server.bean.response.ResponseBean;
import com.web.technical.assessment.server.dto.CalculatorDTO;

public interface CalculationService {
    /**
     * @Author suren_v
     * @CreatedTime 2021-03-27 12:28:10 PM
     * @Version V1.00
     * @MethodName calculate
     * @MethodParams [calculatorDTO]
     * @MethodDescription - This method is used to calculate the final cost based on the product, units or no of cartons
     */
    ResponseBean calculate(CalculatorDTO calculatorDTO);
}
