package com.web.technical.assessment.server.controller;

import com.web.technical.assessment.server.annotation.response.DefaultUserResponseHandler;
import com.web.technical.assessment.server.bean.response.ResponseBean;
import com.web.technical.assessment.server.dto.PriceEngineDTO;
import com.web.technical.assessment.server.service.optimize.PriceEngineService;
import com.web.technical.assessment.server.utility.function.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@DefaultUserResponseHandler
@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/v1/optimize")
public class OptimizeController {
    @Autowired
    Common common;

    @Autowired
    PriceEngineService priceEngineService;

    @PostMapping
    public ResponseEntity<ResponseBean> priceEngine(@RequestBody PriceEngineDTO priceEngineDTO) {
        ResponseBean responseBean = priceEngineService.optimizePrice(priceEngineDTO);
        return common.getResponseEntityBean(responseBean);
    }
}
