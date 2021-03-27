package com.web.technical.assessment.server.mapper.request;

import com.web.technical.assessment.server.dto.ProductDTO;
import com.web.technical.assessment.server.mapping.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ProductRequestMapper {

    /**
     * @Author suren_v
     * @CreatedTime 2020-03-27 10:59:29 AM
     * @Version V1.00
     * @MethodName dtoToProduct
     * @MethodParams [productDTO]
     * @MethodDescription - This method return product.
     */
    public Product dtoToProduct(ProductDTO productDTO) {
        Product product = new Product();
        try {
            product.setCode(productDTO.getCode());
            product.setName(productDTO.getName());
            product.setUnit(Integer.parseInt(productDTO.getUnit()));
            product.setPricePerCarton(Double.parseDouble(productDTO.getPricePerCarton()));
            product.setUnitPrice(Double.parseDouble(productDTO.getUnitPrice()));
            product.setCompensate(Integer.parseInt(productDTO.getCompensate()));
            product.setDiscountQty(Integer.parseInt(productDTO.getDiscountQty()));
            product.setDiscount(Integer.parseInt(productDTO.getDiscount()));
        } catch (Exception e) {
            throw e;
        }
        return product;
    }
}
