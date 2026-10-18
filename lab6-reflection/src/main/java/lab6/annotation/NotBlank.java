package lab6.annotation;

import java.lang.annotation.*;

/** Анотація поля: рядок не може бути null, порожнім або складатися лише з пробілів. Лише метадані. */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface NotBlank {
}
