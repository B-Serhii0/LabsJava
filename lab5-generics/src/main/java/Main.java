import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    // ---------- дані для завдань 1, 4, 5 ----------
    static List<Product> products() {
        return List.of(
            new Product("P-001", "Ноутбук",      "Електроніка", 1, 32000, true,  4.6, 10),
            new Product("P-002", "Смартфон",     "Електроніка", 1, 18000, true,  4.8, 5),
            new Product("P-003", "Навушники",    "Електроніка", 1,   950, false, 3.9, 20),
            new Product("P-004", "Куртка",       "Одяг",        2,  2500, true,  4.2, 0),
            new Product("P-005", "Футболка",     "Одяг",        2,   450, true,  3.5, 30),
            new Product("P-006", "Кросівки",     "Одяг",        2,  3200, false, 4.9, 15),
            new Product("P-007", "Роман",        "Книги",       3,   320, true,  4.1, 0),
            new Product("P-008", "Енциклопедія", "Книги",       3,  1500, true,  4.0, 5),
            new Product("P-009", "Планшет",      "Електроніка", 1, 12000, true,  4.3, 0),
            new Product("P-010", "Монітор",      "Електроніка", 1,  7000, true,  3.8, 18),
            new Product("P-011", "Пальто",       "Одяг",        2,  5600, true,  4.4, 0),
            new Product("P-012", "Словник",      "Книги",       3,  1100, false, 3.2, 0));
    }

    static List<Category> categories() {
        return List.of(new Category(1, "Електроніка"), new Category(2, "Одяг"),
                       new Category(3, "Книги"), new Category(4, "Спорт"));
    }

    public static void main(String[] args) throws IOException {
        task1();
        task2();
        task3();
        task4();
        task5();
    }

    // ---------- Завдання 1 ----------
    static void task1() {
        System.out.println("=== Завдання 1: StorageManager<Product> ===");
        StorageManager<Product> storage = new StorageManager<>();
        products().forEach(storage::add);

        Product found = storage.findFirst(p -> p.article().equals("P-004"));
        System.out.println("Пошук за артикулом P-004: " + (found != null ? found : "не знайдено"));
        System.out.println("Пошук за артикулом X-000: " + storage.findFirst(p -> p.article().equals("X-000")));

        System.out.println("\n1) price >= 1000:");
        storage.filter(p -> p.price() >= 1000).forEach(System.out::println);

        System.out.println("\n2) inStock && category == \"Електроніка\":");
        storage.filter(p -> p.inStock() && p.category().equals("Електроніка")).forEach(System.out::println);

        System.out.println("\n3) rating >= 4.0 || discountPercentage > 15:");
        List<Product> res = storage.filter(p -> p.rating() >= 4.0 || p.discountPercentage() > 15);
        res.forEach(System.out::println);

        try {
            res.add(found);
        } catch (UnsupportedOperationException e) {
            System.out.println("\nРезультат фільтрації доступний лише для читання (UnsupportedOperationException).");
        }

        storage.remove(found);
        System.out.println("Після видалення P-004 у сховищі: " + storage.size() + " товарів\n");
    }

    // ---------- Завдання 2 ----------
    static void task2() throws IOException {
        System.out.println("=== Завдання 2: списки ===");
        List<String> lines = Files.readAllLines(Path.of("input_lists.txt"));
        List<Integer> l1 = parse(lines.get(0));
        List<Integer> l2 = parse(lines.get(1));

        for (int x : l2) {
            int idx = Collections.binarySearch(l1, x);
            if (idx < 0) idx = -idx - 1;
            l1.add(idx, x);
        }
        writeChunked(l1, Path.of("output_l1.txt"), 8, " ");
        System.out.println("L1 після вставки: " + l1);
        System.out.println("Збережено у output_l1.txt (по 8 елементів у рядку)\n");
    }

    static List<Integer> parse(String line) {
        List<Integer> list = new ArrayList<>();
        for (String s : line.trim().split("\\s+")) list.add(Integer.parseInt(s));
        return list;
    }

    static <E> void writeChunked(List<E> list, Path file, int perLine, String sep) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            boolean endOfLine = (i + 1) % perLine == 0 || i == list.size() - 1;
            sb.append(endOfLine ? System.lineSeparator() : sep);
        }
        Files.writeString(file, sb.toString());
    }

    // ---------- Завдання 3----------
    static void task3() throws IOException {
        System.out.println("=== Завдання 3: Map<String,String> -> обернений індекс ===");
        Map<String, String> wordToCategory = new HashMap<>();
        for (String line : Files.readAllLines(Path.of("dictionary.txt"))) {
            if (line.isBlank()) continue;
            String[] parts = line.split(";");
            wordToCategory.put(parts[0].trim(), parts[1].trim());
        }

        // базові та безпечні операції
        System.out.println("containsKey(яблуко): " + wordToCategory.containsKey("яблуко"));
        System.out.println("getOrDefault(авокадо): " + wordToCategory.getOrDefault("авокадо", "невідомо"));
        wordToCategory.put("авокадо", "фрукт");
        wordToCategory.put("сік", "рідина");
        wordToCategory.remove("молоко");

        // спеціалізована операція
        Map<String, List<String>> inverted = new TreeMap<>();
        for (Map.Entry<String, String> e : wordToCategory.entrySet()) {
            List<String> words = inverted.getOrDefault(e.getValue(), new ArrayList<>());
            words.add(e.getKey());
            inverted.put(e.getValue(), words);
        }
        for (List<String> words : inverted.values()) Collections.sort(words);

        inverted.forEach((cat, words) -> System.out.println(cat + " -> " + words));
        System.out.println();
    }

    // ---------- Завдання 4----------
    static void task4() {
        System.out.println("=== Завдання 4: Stream API, базові запити ===");
        List<Product> products = products();

        System.out.println("1) Фільтрація (price > 1000 && inStock):");
        products.stream()
                .filter(p -> p.price() > 1000 && p.inStock())
                .forEach(System.out::println);

        System.out.println("\n2) Сортування (category ↑, price ↓) + проєкція назви:");
        List<String> names = products.stream()
                .sorted(Comparator.comparing(Product::category)
                        .thenComparing(Product::price, Comparator.reverseOrder()))
                .map(Product::name)
                .toList();
        System.out.println(names);

        System.out.println("\n3) Пагінація (skip 3, limit 5):");
        products.stream().skip(3).limit(5).forEach(System.out::println);

        System.out.println("\n4) Перший товар з rating >= 4.8:");
        Optional<Product> first = products.stream().filter(p -> p.rating() >= 4.8).findFirst();
        System.out.println(first.map(Product::toString).orElse("Такого товару немає"));

        System.out.println("\n5) Найвища ціна:");
        products.stream().max(Comparator.comparingDouble(Product::price))
                .ifPresent(System.out::println);
        System.out.println();
    }

    // ---------- Завдання 5 ----------
    record ProductView(String productName, double price, String categoryName) { }

    static void task5() {
        System.out.println("=== Завдання 5: Stream API, агрегація та з'єднання ===");
        List<Product> products = products();
        List<Category> categories = categories();

        System.out.println("1) Кількість товарів за categoryId:");
        Map<Integer, Long> counts = products.stream()
                .collect(Collectors.groupingBy(Product::categoryId, TreeMap::new, Collectors.counting()));
        counts.forEach((id, n) -> System.out.println("  categoryId=" + id + " -> " + n));

        System.out.println("\n2) Середня ціна за категоріями:");
        Map<Integer, Double> avg = products.stream()
                .collect(Collectors.groupingBy(Product::categoryId, TreeMap::new,
                        Collectors.averagingDouble(Product::price)));
        avg.forEach((id, a) -> System.out.printf("  categoryId=%d -> %.2f%n", id, a));

        System.out.println("\n3) Inner Join (товар + назва категорії):");
        Map<Integer, Category> byId = categories.stream()
                .collect(Collectors.toMap(Category::id, c -> c));
        products.stream()
                .filter(p -> byId.containsKey(p.categoryId()))
                .map(p -> new ProductView(p.name(), p.price(), byId.get(p.categoryId()).name()))
                .forEach(System.out::println);

        System.out.println("\n4) GroupJoin / Left Join (категорія -> її товари):");
        categories.stream()
                .map(c -> Map.entry(c.name(),
                        products.stream().filter(p -> p.categoryId() == c.id()).map(Product::name).toList()))
                .forEach(e -> System.out.println("  " + e.getKey() + " -> " + e.getValue()));

        System.out.println("\n5) Зведена агрегація (reduce): назви через кому з пробілом:");
        String all = products.stream()
                .map(Product::name)
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
        System.out.println("  " + all);
    }
}
