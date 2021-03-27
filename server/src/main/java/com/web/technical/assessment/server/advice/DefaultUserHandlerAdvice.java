package com.web.technical.assessment.server.advice;

import com.web.technical.assessment.server.annotation.response.DefaultUserResponseHandler;
import com.web.technical.assessment.server.bean.response.ResponseBean;
import com.web.technical.assessment.server.utility.function.Common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * Project server
 * User : suren_v
 * Date : 03/27/2021
 * Time : 11:25 PM
 */
@RestControllerAdvice(annotations = {DefaultUserResponseHandler.class})
public class DefaultUserHandlerAdvice implements ResponseBodyAdvice<Object> {

    private static final Logger logger = LoggerFactory.getLogger(DefaultUserHandlerAdvice.class);

    @Autowired
    Common common;

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest request, ServerHttpResponse response) {
        request.getHeaders().add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        try {
            if (o instanceof ResponseBean) {
                ResponseBean responseBean = (ResponseBean) o;
                // retrieving the error code
                String errorCode = responseBean.getErrorCode();
                responseBean.setMessageType(errorCode);
            }
        } catch (Exception e) {
            logger.error("Exception : " + e);
        }
        return o;
    }
}

