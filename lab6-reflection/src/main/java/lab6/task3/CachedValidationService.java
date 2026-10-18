package lab6.task3;

import lab6.task2.ValidationResult;
import lab6.task2.ValidationRules;
import lab6.task2.Validator;

import lab6.task1.MarginRule;

import java.util.HashMap;
import java.util.Map;

/** Валідатор*/
public class CachedValidationService implements Validator {

    private final Map<Class<?>, ClassValidationMetadata> cache = new HashMap<>();

    @Override
    public ValidationResult validate(Object entity) {
        ValidationResult result = new ValidationResult();
        Class<?> cls = entity.getClass();

        ClassValidationMetadata meta = cache.get(cls);
        if (meta == null) {
            meta = new ClassValidationMetadata(cls);
            cache.put(cls, meta);
        }

        try {
            MarginRule rule = meta.getMarginRule();
            if (rule != null) {
                double wholesale = ((Number) meta.getWholesaleField().get(entity)).doubleValue();
                double retail = ((Number) meta.getRetailField().get(entity)).doubleValue();
                if (ValidationRules.marginViolated(wholesale, retail, rule.minMarginPercent())) {
                    result.addError(rule.retailField(), "роздрібна ціна має перевищувати гуртову щонайменше на "
                            + rule.minMarginPercent() + "%");
                }
            }

            for (ClassValidationMetadata.FieldMetadata fm : meta.getFields()) {
                Object value = fm.field().get(entity);
                if (fm.notBlank() != null && ValidationRules.isBlank(value)) {
                    result.addError(fm.field().getName(), "значення не може бути порожнім або містити самі пробіли");
                }
                if (fm.range() != null && ValidationRules.isOutOfRange(value, fm.range().min(), fm.range().max())) {
                    result.addError(fm.field().getName(), "значення " + value + " поза діапазоном ["
                            + fm.range().min() + "; " + fm.range().max() + "]");
                }
            }
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Помилка рефлексії при валідації", e);
        }
        return result;
    }

    public int getCacheSize() {
        return cache.size();
    }
}
