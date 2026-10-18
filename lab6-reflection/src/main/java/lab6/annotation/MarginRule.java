package lab6.annotation;

import java.lang.annotation.*;

/** Анотація рівня класу: роздрібна ціна >= гуртова * (1 + minMarginPercent/100). Лише метадані. */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MarginRule {
    double minMarginPercent();
    String wholesaleField() default "wholesalePrice";
    String retailField() default "retailPrice";
}
