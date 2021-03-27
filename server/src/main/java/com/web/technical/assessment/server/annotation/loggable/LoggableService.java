package com.web.technical.assessment.server.annotation.loggable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Project server
 * User : suren_v
 * Date : 03/27/2021
 * Time : 11:10 AM
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LoggableService {
}
