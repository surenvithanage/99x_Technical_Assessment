package com.web.technical.assessment.server.controller;

import com.web.technical.assessment.server.annotation.response.DefaultUserResponseHandler;
import com.web.technical.assessment.server.bean.response.ResponseBean;
import com.web.technical.assessment.server.dto.CalculatorDTO;
import com.web.technical.assessment.server.service.calculation.CalculationService;
import com.web.technical.assessment.server.utility.function.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@DefaultUserResponseHandler
@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/v1/calculate")
public class CalculationController {
    @Autowired
    Common common;

    @Autowired
    CalculationService calculationService;

    @PostMapping
    public ResponseEntity<ResponseBean> calculate(@RequestBody CalculatorDTO calculatorDTO) {
        ResponseBean responseBean = calculationService.calculate(calculatorDTO);
        return common.getResponseEntityBean(responseBean);
    }
}
