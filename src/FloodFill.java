import java.util.Arrays;

public class FloodFill {
    private static final int BACKGROUND_COLOR = 1;
    private static final int NEW_COLOR = 2;

    public static void floodFill(int[][] image, int startX, int startY) {
        int rows = image.length;
        int cols = image[0].length;
        int targetColor = image[startX][startY];

        if (targetColor == NEW_COLOR) {
            return;
        }

        Fila<Integer> fila = new Fila<>(rows * cols);
        fila.enqueue(startX * cols + startY);

        while (!fila.isEmpty()) {
            int pixel = fila.dequeue();
            int x = pixel / cols;
            int y = pixel % cols;
            if (x < 0 || y < 0 || x >= rows  || y >= cols || image[x][y] != targetColor) {
                continue;
            }

            image[x][y] = NEW_COLOR;

            fila.enqueue((x - 1) * cols + y); // Up
            fila.enqueue((x + 1) * cols + y); // Down
            if (y != 0) {
                fila.enqueue(x * cols + (y - 1)); // Left
            }
            fila.enqueue(x * cols + (y + 1)); // Right
        }
    }

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        int startX = 7;
        int startY = 8;

        floodFill(image, startX, startY);

        for (int[] row : image) {
            System.out.println(Arrays.toString(row));
        }
    }
}
