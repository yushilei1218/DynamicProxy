package com.yushilei.dynamicproxy.proxy;

/**
 * @auther by yushilei.
 * @time 2017/6/22-16:09
 * @desc
 */

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
@Documented
@Target(METHOD)
@Retention(RUNTIME)
@Inherited
public @interface MyAnnotation {
    String value() default "";
}
