package task1;

import java.io.IOException;
import java.util.Random;

/**
 * Завдання 1. Варіант 1.
 */
public class Task1 {

    private static final int EMPLOYEES = 10;
    private static final int MONTHS = 12;
    private static final int APRIL_INDEX = 3;
    private static final String FILE_PATH = "salary_matrix.txt";

    public static void run() {

        // 1. Генерація даних
        int[][] salaryMatrix = generateSalaryMatrix(EMPLOYEES, MONTHS);

        System.out.println("Згенерована матриця зарплат (рядок = співробітник, стовпчик = місяць):");
        printMatrix(salaryMatrix);

        // 2. Запис даних у файл
        try (MatrixWriter writer = new MatrixWriter(FILE_PATH)) {
            writer.write(salaryMatrix);
            System.out.println("\nМатрицю успішно записано у файл: " + FILE_PATH);
        } catch (IOException e) {
            System.out.println("Помилка запису у файл: " + e.getMessage());
            return;
        }

        // 3. Зчитування даних з файлу (try-with-resources)
        int[][] restoredMatrix;
        try (MatrixReader reader = new MatrixReader(FILE_PATH)) {
            restoredMatrix = reader.read();
            System.out.println("Матрицю успішно зчитано з файлу.");
        } catch (IOException e) {
            System.out.println("Помилка читання файлу: " + e.getMessage());
            return;
        }

        // 4. Обробка відновленої матриці
        long totalYearBudget = 0;
        long totalApril = 0;

        for (int[] employeeRow : restoredMatrix) {
            for (int month = 0; month < employeeRow.length; month++) {
                totalYearBudget += employeeRow[month];
                if (month == APRIL_INDEX) {
                    totalApril += employeeRow[month];
                }
            }
        }

        double averageApril = (double) totalApril / restoredMatrix.length;

        System.out.println("\n--- Результати обробки ---");
        System.out.println("Загальний бюджет зарплати за рік: " + totalYearBudget + " грн.");
        System.out.println("Загальна зарплата за квітень: " + totalApril + " грн.");
        System.out.printf("Середня зарплата за квітень: %.2f грн.%n", averageApril);
    }

    private static int[][] generateSalaryMatrix(int employees, int months) {
        Random random = new Random();
        int[][] matrix = new int[employees][months];
        for (int i = 0; i < employees; i++) {
            for (int j = 0; j < months; j++) {
                matrix[i][j] = 5000 + random.nextInt(15001);
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            StringBuilder sb = new StringBuilder();
            for (int value : row) {
                sb.append(String.format("%6d", value));
            }
            System.out.println(sb);
        }
    }
}
