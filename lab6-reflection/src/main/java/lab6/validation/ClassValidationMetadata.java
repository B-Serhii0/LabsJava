package lab6.validation;

import lab6.annotation.MarginRule;
import lab6.annotation.NotBlank;
import lab6.annotation.Range;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/** Підготовлені (закешовані) метадані одного типу. */
public class ClassValidationMetadata {

    public record FieldMetadata(Field field, NotBlank notBlank, Range range) {}

    private final MarginRule marginRule;
    private final Field wholesaleField;
    private final Field retailField;
    private final List<FieldMetadata> fields = new ArrayList<>();

    public ClassValidationMetadata(Class<?> cls) {
        try {
            this.marginRule = cls.getAnnotation(MarginRule.class);
            if (marginRule != null) {
                wholesaleField = cls.getDeclaredField(marginRule.wholesaleField());
                retailField = cls.getDeclaredField(marginRule.retailField());
                wholesaleField.setAccessible(true);
                retailField.setAccessible(true);
            } else {
                wholesaleField = null;
                retailField = null;
            }
            for (Field f : cls.getDeclaredFields()) {
                NotBlank nb = f.getAnnotation(NotBlank.class);
                Range r = f.getAnnotation(Range.class);
                if (nb != null || r != null) {      // зберігаємо лише поля з анотаціями
                    f.setAccessible(true);
                    fields.add(new FieldMetadata(f, nb, r));
                }
            }
        } catch (NoSuchFieldException e) {
            throw new IllegalStateException("Поле з @MarginRule не знайдено", e);
        }
    }

    public MarginRule getMarginRule() { return marginRule; }
    public Field getWholesaleField() { return wholesaleField; }
    public Field getRetailField() { return retailField; }
    public List<FieldMetadata> getFields() { return fields; }
}
