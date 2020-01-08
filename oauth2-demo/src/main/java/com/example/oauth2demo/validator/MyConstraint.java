package com.example.oauth2demo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
/*
指定校验逻辑实现类
 */
@Constraint(validatedBy = MyConstraintValidator.class)
public @interface MyConstraint {
    String message() default "自定义校验不通过";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
