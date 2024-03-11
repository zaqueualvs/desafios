package com.alves.lanchonete.commons.customannotations;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface EventPublisherAdapter {
    String value() default "";
}
