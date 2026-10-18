# Лабораторна №6 — Анотації та Reflection (Java, варіант 1: Product)

| Завдання | Пакет | Файли | Запуск (main) |
|----------|-------|-------|---------------|
| 1. Анотації + Product | `lab6.task1` | `MarginRule`, `Range`, `NotBlank`, `Product` | не запускається (перевіряється через Завд. 2) |
| 2. ValidatorService | `lab6.task2` | `Validator`, `ValidationResult`, `ValidationRules`, `ValidatorService`, `Task2Main` | `Task2Main` |
| 3. Кеш + бенчмарк | `lab6.task3` | `ClassValidationMetadata`, `CachedValidationService`, `Task3Main` | `Task3Main` |
| 4. @Component-сканер | `lab6.task4` | `Component`, `ClassScanner`, `components/*` (10 класів), `Task4Main` | `Task4Main` |

## Запуск
```
mvn compile
java -cp target/classes lab6.task2.Task2Main
java -cp target/classes lab6.task3.Task3Main
java -cp target/classes lab6.task4.Task4Main
```
Або в IntelliJ: відкрити папку як Maven-проєкт і запускати `main` потрібного класу.
