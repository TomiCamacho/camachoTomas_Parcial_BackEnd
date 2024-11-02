package org.demo.parcialCamachoTomas.validadores;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Constraint(validatedBy = ValidadorAdn.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)

public @interface ValidacionAdn {

    String message() default "La secuencia no es válida";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}