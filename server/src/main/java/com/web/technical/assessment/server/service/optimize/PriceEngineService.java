package com.web.technical.assessment.server.service.optimize;

import com.web.technical.assessment.server.bean.response.ResponseBean;
import com.web.technical.assessment.server.dto.PriceEngineDTO;

public interface PriceEngineService {
    /**
     * @Author suren_v
     * @CreatedTime 2021-03-27 11:58:10 AM
     * @Version V1.00
     * @MethodName optimizePrice
     * @MethodParams [priceEngineDTO]
     * @MethodDescription - This method is used to optimize the price and obtain the number of cartons and units
     */
    ResponseBean optimizePrice(PriceEngineDTO priceEngineDTO);
}
