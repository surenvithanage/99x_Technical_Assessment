package com.web.technical.assessment.server.annotation.loggable;

import com.web.technical.assessment.server.utility.function.Common;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Project server
 * User : suren_v
 * Date : 03/27/2021
 * Time : 11:14 AM
 */
@Aspect
@Component
public class LoggableServiceAspect {

    @Autowired
    private Common common;

    @Before(value = "@annotation(LoggableService) && args(o, ..)")
    public void beforeServiceLog(JoinPoint joinPoint, Object o) {
        common.writeLog(joinPoint, o);
    }

    @AfterReturning(value = "@annotation(LoggableService)", returning = "o")
    public void afterServiceLog(JoinPoint joinPoint, Object o) {
        common.writeLog(joinPoint, o);

    }
}
