package com.web.technical.assessment.server.utility.function;

import com.web.technical.assessment.server.bean.response.ResponseBean;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
@Scope("prototype")
public class Common {
    private static final Logger logger = LoggerFactory.getLogger(Common.class);

    public void writeLog(JoinPoint joinPoint, Object o) {
        try {
            if (o != null) {
                this.logObjectContent(joinPoint, o);
            }
        } catch (Exception e) {
            logger.error("Exception : ", e);
        }
    }

    public void logObjectContent(JoinPoint joinPoint, Object o) throws IllegalAccessException {
        String result = "";
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        logger.info("------------------------------------------------------------");
        logger.info("className and methodName : " + className + "  " + methodName);
        for (Field field : o.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            String name = field.getName();
            Object value = field.get(o);
            result += "  " + name + " : " + value;
        }
        logger.info("object attributes :" + result);
        logger.info("------------------------------------------------------------");
    }


    public ResponseEntity<ResponseBean> getResponseEntityBean(ResponseBean responseBean) {
        if (responseBean.isRequestOk()) {
            return new ResponseEntity<>(responseBean, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(responseBean, HttpStatus.BAD_REQUEST);
        }
    }
}
