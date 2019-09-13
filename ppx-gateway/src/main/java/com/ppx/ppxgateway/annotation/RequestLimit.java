package com.ppx.ppxgateway.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface RequestLimit {
    /**
     * ip允许访问的次数，默认值1000
     */
    int ipCount() default 1000;

    /**
     * ip时间段，单位为毫秒，默认值一分钟
     */
    long ipTime() default 60000;

    /**
     * uri允许访问的次数，默认值600
     */
    int uriCount() default 600;

    /**
     * uri时间段，单位为毫秒，默认值一分钟
     */
    long uriTime() default 60000;
}
