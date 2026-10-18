package task1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Клас відповідає ВИКЛЮЧНО за запис готової матриці у текстовий файл.
 */
public class MatrixWriter implements AutoCloseable {

    private final BufferedWriter writer;

    public MatrixWriter(String filePath) throws IOException {
        this.writer = new BufferedWriter(new FileWriter(filePath));
    }

    /**
     * Записує матрицю у файл
     */
    public void write(int[][] matrix) throws IOException {
        for (int[] row : matrix) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < row.length; j++) {
                sb.append(row[j]);
                if (j < row.length - 1) {
                    sb.append(' ');
                }
            }
            writer.write(sb.toString());
            writer.newLine();
        }
        writer.flush();
    }

    @Override
    public void close() throws IOException {
        writer.close();
        System.out.println("MatrixWriter: файловий потік закрито.");
    }
}
