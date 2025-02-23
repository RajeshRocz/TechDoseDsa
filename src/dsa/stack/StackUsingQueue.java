package dsa.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    public static void main(String[] args) {
        StackQueue stack = new StackQueue();
        System.out.println("isEmpty:" + stack.isEmpty());
        System.out.println("size:" + stack.size());

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println("stack pop:" + stack.pop());
        System.out.println("stack peek:" + stack.peek());
        System.out.println("isEmpty:" + stack.isEmpty());
        System.out.println("size:" + stack.size());

    }
}

class StackQueue {
    Queue<Integer> queue;

    public StackQueue() {
        queue = new LinkedList<>();
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        return queue.peek();
    }

    //Push O(n)
    public void push(int value) {
        queue.add(value);
        int n = queue.size() - 1;
        while (n > 0) {
            queue.add(queue.poll());
            n--;
        }
    }

    //Pop O(1)
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        return queue.poll();
    }


    //We can modify and make pop-O(n) and push-O(1) based on requirement
}
