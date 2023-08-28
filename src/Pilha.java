import java.util.ArrayList;

public class Pilha {
    private int[] stack;
    private int top;
    private final int size;

    public Pilha(int size) {
        this.size = size;
        this.top = -1;
        this.stack = new int[size];
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }


    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Pilha vazia");
        }
        int value = stack[this.top];
        stack[top] = 0;
        top--;
        return value;
    }

    public void push(int data) {
        if (top == size - 1) {
            System.out.println("Overflow");
        } else {
            top += 1;
            stack[top] = data;
        }
    }

    public void clear() {
        this.stack = new int[size];
        this.top = -1;
    }
}
