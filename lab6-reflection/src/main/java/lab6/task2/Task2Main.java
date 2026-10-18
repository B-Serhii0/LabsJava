package lab6.task2;

import lab6.task1.Product;

public class Task2Main {
    public static void main(String[] args) {
        ValidatorService validator = new ValidatorService();

        Product valid = new Product("Ноутбук", 20000, 25000, 50, true);
        // порушення
        Product invalid = new Product("   ", 0, 0, 20000, true);
        Product badMargin = new Product("Мишка", 100, 105, 10, true);

        print(valid, validator.validate(valid));
        print(invalid, validator.validate(invalid));
        print(badMargin, validator.validate(badMargin));
    }

    private static void print(Product p, ValidationResult r) {
        System.out.println(p);
        System.out.println("  IsValid: " + r.isValid());
        r.getErrors().forEach(e -> System.out.println("  - " + e));
        System.out.println();
    }
}
