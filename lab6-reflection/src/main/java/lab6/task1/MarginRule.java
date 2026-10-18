package lab6.task1;

import java.lang.annotation.*;

/** Анотація рівня класу */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MarginRule {
    double minMarginPercent();
    String wholesaleField() default "wholesalePrice";
    String retailField() default "retailPrice";
}
