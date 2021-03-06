package com.web.technical.assessment.server.controller;

import com.web.technical.assessment.server.annotation.response.DefaultUserResponseHandler;
import com.web.technical.assessment.server.bean.response.ResponseBean;
import com.web.technical.assessment.server.service.product.ProductService;
import com.web.technical.assessment.server.utility.function.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@DefaultUserResponseHandler
@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/v1/product")
public class ProductController {

    @Autowired
    Common common;

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<ResponseBean> list() {
        ResponseBean responseBean = productService.productList();
        return common.getResponseEntityBean(responseBean);
    }
}
