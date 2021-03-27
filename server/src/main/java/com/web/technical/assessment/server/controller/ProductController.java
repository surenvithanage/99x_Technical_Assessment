package com.web.technical.assessment.server.controller;

import com.web.technical.assessment.server.annotation.response.DefaultUserResponseHandler;
import com.web.technical.assessment.server.bean.response.ResponseBean;
import com.web.technical.assessment.server.service.product.ProductService;
import com.web.technical.assessment.server.utility.function.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<ResponseBean> list() {
        ResponseBean responseBean = productService.productList();
        return common.getResponseEntityBean(responseBean);
    }
}
