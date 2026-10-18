# Лабораторні роботи (Java)

Кожна лабораторна — окремий Maven-проєкт. Потрібен **JDK 21**.

| Папка | Тема | Точка входу |
|-------|------|-------------|
| `lab3-basic-constructs` | Масиви, ресурси, ООП | `Main` (меню 1–4) |
| `lab4-modern-data` | Records, sealed, switch patterns, enum, java.time | `lab4.Task12Main`, `lab4.Task3Main`, `lab4.Task4Main` |
| `lab5-generics` | Generics, колекції, Stream API | `Main` |
| `lab6-reflection` | Анотації та Reflection | `lab6.Task2Demo`, `lab6.Task3Benchmark`, `lab6.task4.Task4Demo` |

## Як запустити в IntelliJ IDEA

1. `File → Open` і оберіть **папку однієї лаби** (де лежить `pom.xml`), а не корінь репозиторію.
2. Натисніть **Load Maven Project**, якщо IDEA запропонує.
3. Переконайтесь, що SDK проєкту — 21 (`File → Project Structure → Project`).
4. Відкрийте потрібний клас і натисніть зелену стрілку біля `main`.

`lab5-generics` читає `dictionary.txt` та `input_lists.txt` з кореня лаби, тому запускайте її саме з цієї папки
(IDEA робить це автоматично, коли лаба відкрита як окремий проєкт).
