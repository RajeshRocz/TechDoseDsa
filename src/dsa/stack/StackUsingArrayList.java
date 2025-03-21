package dsa.stack;

import java.util.ArrayList;
import java.util.List;

public class StackUsingArrayList {

    public static void main(String[] args) {
        StackArrayList stack = new StackArrayList();
        System.out.println("isEmpty:" + stack.isEmpty());
        System.out.println("size:" + stack.size());

        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("stack pop:" + stack.pop());
        System.out.println("stack peek:" + stack.peek());
        System.out.println("isEmpty:" + stack.isEmpty());
        System.out.println("size:" + stack.size());

    }

}

class StackArrayList {

    private final static int MAX_SIZE = 1024 * 1024 / 4;
    private List<Integer> stack;

    public StackArrayList() {
        stack = new ArrayList<>();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        return stack.get(stack.size() - 1);
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        return stack.remove(stack.size() - 1);
    }

    public void push(int value) {
        if (stack.size() >= MAX_SIZE) {
            throw new RuntimeException("Stack is Full");
        }
        stack.add(value);
    }
}
