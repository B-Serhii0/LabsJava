package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас відповідає за порядкове зчитування матриці з текстового файлу
 * і відтворення її у вигляді двовимірного масиву в оперативній пам'яті.
 * Реалізує AutoCloseable для безпечного звільнення файлового ресурсу.
 */
public class MatrixReader implements AutoCloseable {

    private final BufferedReader reader;

    public MatrixReader(String filePath) throws IOException {
        this.reader = new BufferedReader(new FileReader(filePath));
    }

    /**
     * Зчитує файл порядково та повертає відновлену матрицю.
     */
    public int[][] read() throws IOException {
        List<int[]> rows = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.isBlank()) {
                continue;
            }
            String[] parts = line.trim().split("\\s+");
            int[] row = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                row[i] = Integer.parseInt(parts[i]);
            }
            rows.add(row);
        }
        return rows.toArray(new int[0][]);
    }

    @Override
    public void close() throws IOException {
        reader.close();
        System.out.println("MatrixReader: файловий потік закрито.");
    }
}
