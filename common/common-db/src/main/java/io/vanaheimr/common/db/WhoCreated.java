package io.vanaheimr.common.db;

import io.micronaut.data.annotation.AutoPopulated;

import java.lang.annotation.*;
import java.time.temporal.ChronoUnit;
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
@Documented
@AutoPopulated(updateable = false)
public @interface WhoCreated {
    String NAME = WhoCreated.class.getName();

    /**
     * Allows to truncate the auto set date value.
     *
     * @return the truncated to constant
     * @since 3.4.2
     */
    ChronoUnit truncatedTo() default ChronoUnit.FOREVER;
}
