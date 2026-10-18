package lab6.validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidationResult {
    private final List<String> errors = new ArrayList<>();

    public boolean isValid() {
        return errors.isEmpty();
    }

    public void addError(String fieldName, String message) {
        errors.add(fieldName + ": " + message);
    }

    public List<String> getErrors() {
        return Collections.unmodifiableList(errors);
    }

    @Override
    public String toString() {
        return isValid() ? "IsValid = true" : "IsValid = false, errors = " + errors;
    }
}
