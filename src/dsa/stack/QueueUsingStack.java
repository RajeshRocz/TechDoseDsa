package dsa.stack;

import java.util.Stack;

public class QueueUsingStack {

    public static void main(String[] args) {
        QueueStack queue = new QueueStack();
        System.out.println("isEmpty:" + queue.isEmpty());
        System.out.println("size:" + queue.size());

        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println("queue poll:" + queue.poll());
        System.out.println("queue poll:" + queue.poll());
        System.out.println("queue peek:" + queue.peek());
        System.out.println("isEmpty:" + queue.isEmpty());
        System.out.println("size:" + queue.size());

    }

}

class QueueStack {
    Stack<Integer> stack;
    private static final int MAX_SIZE = 1024 * 1024 / 4;//1MB integers size

    public QueueStack() {
        stack = new Stack<>();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    //add-O(1)
    public void add(int value) {
        if (stack.size() >= MAX_SIZE) {
            throw new RuntimeException("Queue is Full");
        }
        stack.add(value);
    }

    //poll-O(n)
    public int poll() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        Stack<Integer> temp = new Stack<>();
        int n = size() - 1;
        while (n > 0) {
            temp.add(stack.pop());
            n--;
        }

        int value = stack.pop();
        while (!temp.isEmpty()) {
            stack.add(temp.pop());
        }
        return value;
    }

    //peek-O(n)
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            temp.add(stack.pop());
        }
        int value = temp.peek();

        while (!temp.isEmpty()) {
            stack.add(temp.pop());
        }
        return value;
    }
}
