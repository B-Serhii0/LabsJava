package lab6.annotation;

import java.lang.annotation.*;

/** Анотація поля: числове значення має входити в діапазон [min; max]. Лише метадані. */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface Range {
    double min();
    double max();
}
