package lab6.task2;

import lab6.task1.MarginRule;
import lab6.task1.NotBlank;
import lab6.task1.Range;

import java.lang.reflect.Field;

/** Базовий валідатор */
public class ValidatorService implements Validator {

    @Override
    public ValidationResult validate(Object entity) {
        ValidationResult result = new ValidationResult();
        Class<?> cls = entity.getClass();
        try {
            MarginRule rule = cls.getAnnotation(MarginRule.class);
            if (rule != null) {
                Field w = cls.getDeclaredField(rule.wholesaleField());
                Field r = cls.getDeclaredField(rule.retailField());
                w.setAccessible(true);
                r.setAccessible(true);
                double wholesale = ((Number) w.get(entity)).doubleValue();
                double retail = ((Number) r.get(entity)).doubleValue();
                if (ValidationRules.marginViolated(wholesale, retail, rule.minMarginPercent())) {
                    result.addError(rule.retailField(), "роздрібна ціна має перевищувати гуртову щонайменше на "
                            + rule.minMarginPercent() + "%");
                }
            }

            //Валідація полів
            for (Field field : cls.getDeclaredFields()) {
                field.setAccessible(true);
                Object value = field.get(entity);

                NotBlank notBlank = field.getAnnotation(NotBlank.class);
                if (notBlank != null && ValidationRules.isBlank(value)) {
                    result.addError(field.getName(), "значення не може бути порожнім або містити самі пробіли");
                }

                Range range = field.getAnnotation(Range.class);
                if (range != null && ValidationRules.isOutOfRange(value, range.min(), range.max())) {
                    result.addError(field.getName(), "значення " + value + " поза діапазоном ["
                            + range.min() + "; " + range.max() + "]");
                }
            }
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException("Помилка рефлексії при валідації", e);
        }
        return result;
    }
}
