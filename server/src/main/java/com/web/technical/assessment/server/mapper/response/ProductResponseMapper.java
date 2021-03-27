package com.web.technical.assessment.server.mapper.response;

import com.web.technical.assessment.server.dto.ProductDTO;
import com.web.technical.assessment.server.mapping.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Scope("prototype")
public class ProductResponseMapper {

    /**
     * @Author suren_v
     * @CreatedTime 2020-03-27 10:53:27 AM
     * @Version V1.00
     * @MethodName responseToProductDto
     * @MethodParams [product]
     * @MethodDescription - This method convert product response to dto
     */
    public ProductDTO responseToDto(Product product) {
        ProductDTO productDto = new ProductDTO();
        try {
            productDto.setId(String.valueOf(product.getId()));
            if (product.getCode() != null && !product.getCode().isEmpty()) {
                productDto.setCode(product.getCode());
            } else {
                productDto.setCode("--");
            }
            if (product.getName() != null && !product.getName().isEmpty()) {
                productDto.setName(product.getName());
            } else {
                productDto.setName("--");
            }
            if (!String.valueOf(product.getUnit()).isEmpty()) {
                productDto.setUnit(String.valueOf(product.getUnit()));
            } else {
                productDto.setUnit("--");
            }
            if (!String.valueOf(product.getPricePerCarton()).isEmpty()) {
                productDto.setPricePerCarton(String.valueOf(product.getPricePerCarton()));
            } else {
                productDto.setPricePerCarton("--");
            }
            if (!String.valueOf(product.getUnitPrice()).isEmpty()) {
                productDto.setUnitPrice(String.valueOf(product.getUnitPrice()));
            } else {
                productDto.setUnitPrice("--");
            }
            if (!String.valueOf(product.getCompensate()).isEmpty()) {
                productDto.setCompensate(String.valueOf(product.getCompensate()));
            } else {
                productDto.setCompensate("--");
            }
            if (!String.valueOf(product.getDiscountQty()).isEmpty()) {
                productDto.setDiscountQty(String.valueOf(product.getDiscountQty()));
            } else {
                productDto.setDiscountQty("--");
            }
            if (!String.valueOf(product.getDiscount()).isEmpty()) {
                productDto.setDiscount(String.valueOf(product.getDiscount()));
            } else {
                productDto.setDiscount("--");
            }
        } catch (Exception e) {
            throw e;
        }
        return productDto;
    }

    /**
     * @Author suren_v
     * @CreatedTime 2020-03-27 10:53:27 AM
     * @Version V1.00
     * @MethodName getProductDtoList
     * @MethodParams [productList]
     * @MethodDescription - This method convert product response to dto list
     */
    public List<ProductDTO> responseToDtoList(List<Product> productList) {
        List<ProductDTO> productDTOList = null;
        try {
            //check product list is not null and its size
            if (productList != null && productList.size() > 0) {
                //map product list to product dto list
                productDTOList = productList.stream().map(product -> this.responseToDto(product)).sorted(Comparator.comparing(ProductDTO::getName)).collect(Collectors.toList());
            }
        } catch (Exception e) {
            throw e;
        }
        return productDTOList;
    }
}
