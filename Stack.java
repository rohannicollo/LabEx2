// Teope, Rohan Nicollo M., Tucay, Jack Andie C.
// ICS 2605 1CSD
// Lab Exercise 2

public class Stack<T> {
    private Object[] objects;
    private int size = 100;
    private int top = -1;
    
    public Stack() {
        objects = new Object[size];
    }
    
    public Stack(int size) {
        if (size >= 1) {
            this.size = size;
            objects = new Object[size];
        }
    }
    
    public void push(T value) {
        top++;
        objects[top] = value;
    }
    
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        return (T) objects[top--];
    }
    
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return (T) objects[top];
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public boolean isFull() {
        return top == size - 1;
    }
    
    public void clear() {
        top = -1;
    }
}