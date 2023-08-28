import java.util.Arrays;

public class FloodFillPilha {
    private static final int NEW_COLOR = 2;

    public static void floodFillPilha(int[][] matriz, int startX, int startY) {
        int rows = matriz.length;
        int cols = matriz[0].length;
        int targetColor = matriz[startX][startY];

        if (targetColor == NEW_COLOR) {
            return;
        }

        Pilha pilha = new Pilha(rows * cols); // Cria uma nova instância da classe Pilha com capacidade para armazenar todos os pixels da matriz
        pilha.push(startX * cols + startY); // Adiciona o pixel de início na pilha, convertendo as coordenadas (startX, startY) para um índice único

        while (!pilha.isEmpty()) { // Enquanto a pilha não estiver vazia
            int pixel = pilha.pop(); // Remove o próximo pixel da pilha
            int x = pixel / cols; // Calcula a coordenada x do pixel a partir do índice
            int y = pixel % cols; // Calcula a coordenada y do pixel a partir do índice

            // Verifica se as coordenadas estão fora dos limites da matriz ou se a cor do pixel é diferente da cor alvo
            if (x < 0 || y < 0 || x >= rows || y >= cols || matriz[x][y] != targetColor) {
                continue;
            }

            matriz[x][y] = NEW_COLOR; // Define a nova cor para o pixel atual

            pilha.push((x - 1) * cols + y); // Adiciona o pixel acima na pilha
            pilha.push((x + 1) * cols + y); // Adiciona o pixel abaixo na pilha
            if (y != 0) {
                pilha.push(x * cols + (y - 1)); // Adiciona o pixel à esquerda na pilha
            }
            if (y != cols - 1) {
                pilha.push(x * cols + (y + 1)); // Adiciona o pixel à direita na pilha
            }
        }
    }
}


