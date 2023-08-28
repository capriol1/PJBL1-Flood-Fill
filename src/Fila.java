import java.util.ArrayList;

public class Fila {
    private int[] queue;
    private int front;
    private int end;
    private final int size;

    public Fila(int size) {
        this.size = size;
        this.front = 0;
        this.end = -1;
        this.queue = new int[size];
    }

    public boolean isFull() {
        return end == size - 1;
    }

    public boolean isEmpty() {
        return end == -1;
    }

    public void enqueue(int value) {
        if (isFull()) {
            throw new IllegalStateException("Fila cheia");
        }
        this.end++;
        this.queue[end] = value;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia!");
        }
        int value = queue[front];

        for (int i = 0; i < size -1; i++){
            queue[i] = queue[i + 1];
        }

        queue[end] = -1;
        end--;
        return value;
    }

    public void clear() {
        queue = new int[size];
        front = -1;
        end = -1;
    }
}