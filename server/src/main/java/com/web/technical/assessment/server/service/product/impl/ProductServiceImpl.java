package com.web.technical.assessment.server.service.product.impl;

import com.web.technical.assessment.server.bean.data.ResponseDataBean;
import com.web.technical.assessment.server.bean.keyvalue.KeyValueBean;
import com.web.technical.assessment.server.bean.response.ResponseBean;
import com.web.technical.assessment.server.dto.ProductDTO;
import com.web.technical.assessment.server.mapper.response.ProductResponseMapper;
import com.web.technical.assessment.server.repository.ProductRepository;
import com.web.technical.assessment.server.service.product.ProductService;
import com.web.technical.assessment.server.utility.varlist.CodeVarList;
import com.web.technical.assessment.server.utility.varlist.MessageVarList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductResponseMapper productResponseMapper;

    @Override
    public ResponseBean productList() {
        ResponseBean responseBean = new ResponseBean();
        ResponseDataBean responseDataBean = new ResponseDataBean<>();
        try {
            if (productRepository.findAll().size() > 0) {
                List<ProductDTO> productDTOList = productResponseMapper.responseToDtoList(productRepository.findAll());
                responseBean.setRequestOk(true);
                responseDataBean.setFullCount(productDTOList.size());
                responseDataBean.setData(productDTOList);
                KeyValueBean kvListUserData = new KeyValueBean(CodeVarList.CODE_PRODUCT_MGT_PRODUCTLISTDATA, responseDataBean);
                responseBean.setErrorCode("S");
                responseBean.setData(kvListUserData);
            } else {
                responseBean.setRequestOk(false);
                responseBean.setErrorCode("E");
                responseBean.setMessage(MessageVarList.PRODUCT_EMPTY_ERROR_MSG);
            }
        } catch (Exception e) {
            logger.error("Exception : " + e);
            responseBean.setRequestOk(false);
            responseBean.setErrorCode("E");
            responseBean.setMessage(MessageVarList.COMMON_ERROR_MSG);
        }
        return responseBean;
    }
}
