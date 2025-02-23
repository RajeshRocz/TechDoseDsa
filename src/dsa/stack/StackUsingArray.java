package dsa.stack;

public class StackUsingArray {
    public static void main(String[] args) {
        StackArray stack = new StackArray();
        System.out.println("isEmpty:" + stack.isEmpty());
        System.out.println("size:" + stack.size());

        stack.push(10);
        stack.push(20);
        System.out.println("stack pop:" + stack.pop());
        System.out.println("stack peek:" + stack.peek());
        System.out.println("isEmpty:" + stack.isEmpty());
        System.out.println("size:" + stack.size());

    }
}

class StackArray {
    private final int MAX_SIZE = 1024 * 1024 / 4;
    private final int[] stack;
    private int top;

    public StackArray() {
        stack = new int[MAX_SIZE];
        top = -1;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        return stack[top--];

    }

    public void push(int value) {
        if (top >= MAX_SIZE - 1) {
            throw new RuntimeException("Stack is full");
        }
        stack[++top] = value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

}
