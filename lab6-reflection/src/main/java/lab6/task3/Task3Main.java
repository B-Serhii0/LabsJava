package lab6.task3;

import lab6.task1.Product;
import lab6.task2.Validator;
import lab6.task2.ValidatorService;

import java.util.Random;

public class Task3Main {
    private static final int ITERATIONS = 500_000;
    private static final int WARMUP = 20_000;

    public static void main(String[] args) {
        Random rnd = new Random(42);
        Product[] data = new Product[1000];
        for (int i = 0; i < data.length; i++) {
            double wholesale = rnd.nextDouble() * 1000;
            data[i] = new Product(
                    rnd.nextBoolean() ? "Товар-" + i : "  ",
                    wholesale,
                    wholesale * (1 + rnd.nextDouble() * 0.4),
                    rnd.nextInt(12_000),
                    rnd.nextBoolean());
        }

        ValidatorService plain = new ValidatorService();
        CachedValidationService cached = new CachedValidationService();

        run(plain, data, WARMUP);
        run(cached, data, WARMUP);

        long tPlain = run(plain, data, ITERATIONS);
        long tCached = run(cached, data, ITERATIONS);

        System.out.println("Ітерацій: " + ITERATIONS);
        System.out.println("+-------------------------+--------------+");
        System.out.printf("| %-23s | %-12s |%n", "Сервіс", "Час, мс");
        System.out.println("+-------------------------+--------------+");
        System.out.printf("| %-23s | %12.2f |%n", "ValidatorService", tPlain / 1e6);
        System.out.printf("| %-23s | %12.2f |%n", "CachedValidationService", tCached / 1e6);
        System.out.println("+-------------------------+--------------+");
        System.out.printf("Прискорення: %.2fx%n", (double) tPlain / tCached);
    }

    private static long run(Validator v, Product[] data, int n) {
        int valid = 0;
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            if (v.validate(data[i % data.length]).isValid()) valid++;
        }
        long time = System.nanoTime() - start;
        if (valid < 0) System.out.println(valid);
        return time;
    }
}
