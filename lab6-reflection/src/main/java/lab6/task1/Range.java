package lab6.task1;

import java.lang.annotation.*;

/** Анотація поля */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface Range {
    double min();
    double max();
}
