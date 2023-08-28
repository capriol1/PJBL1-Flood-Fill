import java.util.Arrays;

public class FloodFillFila {
    private static final int NEW_COLOR = 2;

    public static void floodFillFila(int[][] matriz, int startX, int startY) {
        int rows = matriz.length;
        int cols = matriz[0].length;
        int targetColor = matriz[startX][startY];

        if (targetColor == NEW_COLOR) {
            return;
        }

        Fila fila = new Fila(rows * cols); //cria uma nova instância da classe Fila com capacidade para armazenar todos os pixels da matriz
        fila.enqueue(startX * cols + startY); // Adiciona o pixel de início na fila, convertendo as coordenadas (startX, startY) para um índice único
        while (!fila.isEmpty()) { // Enquanto a fila não estiver vazia
            int pixel = fila.dequeue(); // Remove o próximo pixel da fila
            int x = pixel / cols; // Calcula a coordenada x do pixel a partir do índice
            int y = pixel % cols; // Calcula a coordenada y do pixel a partir do índice

            // Verifica se as coordenadas estão fora dos limites da matriz ou se a cor do pixel é diferente da cor alvo
            if (x < 0 || y < 0 || x >= rows || y >= cols || matriz[x][y] != targetColor) {
                continue;
            }

            matriz[x][y] = NEW_COLOR; // Define a nova cor para o pixel atual

            fila.enqueue((x - 1) * cols + y); // Adiciona o pixel acima na fila
            fila.enqueue((x + 1) * cols + y); // Adiciona o pixel abaixo na fila
            if (y != 0) {
                fila.enqueue(x * cols + (y - 1)); // Adiciona o pixel à esquerda na fila
            }
            if (y != 9) {
                fila.enqueue(x * cols + (y + 1)); // Adiciona o pixel à direita na fila
            }
        }
    }

}
