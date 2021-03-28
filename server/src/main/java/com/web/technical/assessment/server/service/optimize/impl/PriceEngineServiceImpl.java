package com.web.technical.assessment.server.service.optimize.impl;

import com.web.technical.assessment.server.bean.keyvalue.KeyValueBean;
import com.web.technical.assessment.server.bean.response.ResponseBean;
import com.web.technical.assessment.server.dto.PriceEngineDTO;
import com.web.technical.assessment.server.mapping.Product;
import com.web.technical.assessment.server.repository.ProductRepository;
import com.web.technical.assessment.server.service.optimize.PriceEngineService;
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
public class PriceEngineServiceImpl implements PriceEngineService {
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    ProductRepository productRepository;

    @Override
    public ResponseBean optimizePrice(PriceEngineDTO priceEngineDTO) {
        ResponseBean responseBean = new ResponseBean();
        PriceEngineDTO engineDTO = new PriceEngineDTO();
        try {
            Optional<Product> productList = productRepository.findById(Long.valueOf(priceEngineDTO.getProductId()));
            if (productList.isPresent()) {
                Product product = productList.get();
                if (priceEngineDTO.getNoOfUnits() != null && !priceEngineDTO.getNoOfUnits().isEmpty()) {
                    int noOfUnits = Integer.parseInt(priceEngineDTO.getNoOfUnits());
                    if (noOfUnits > product.getUnit()) {
                        int numberOfCartons = noOfUnits / product.getUnit();
                        int numberOfUnits = noOfUnits % product.getUnit();
                        engineDTO.setNoOfCartons(String.valueOf(numberOfCartons));
                        engineDTO.setNoOfUnits(String.valueOf(numberOfUnits));
                        responseBean.setRequestOk(true);
                        KeyValueBean kvListUserData = new KeyValueBean(CodeVarList.CODE_OPTIMIZE_PRICE_DATA, engineDTO);
                        responseBean.setErrorCode("S");
                        responseBean.setData(kvListUserData);
                    } else {
                        responseBean.setRequestOk(false);
                        responseBean.setErrorCode("E");
                        responseBean.setMessage(MessageVarList.PRICE_OPTIMIZE_ERROR_MSG);
                    }
                } else {
                    engineDTO.setNoOfCartons(priceEngineDTO.getNoOfCartons());
                    engineDTO.setNoOfUnits(priceEngineDTO.getNoOfUnits());
                    responseBean.setRequestOk(true);
                    KeyValueBean kvListUserData = new KeyValueBean(CodeVarList.CODE_OPTIMIZE_PRICE_DATA, engineDTO);
                    responseBean.setErrorCode("S");
                    responseBean.setData(kvListUserData);
                }
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
