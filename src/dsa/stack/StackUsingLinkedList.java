package dsa.stack;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StackUsingLinkedList {
    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();
        System.out.println("isEmpty:" + stack.isEmpty());
        System.out.println("size:" + stack.size());

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.print();
        stack.reverse();
        System.out.println("");
        stack.print();
        System.out.println("");
        System.out.println("stack pop:" + stack.pop());
        System.out.println("stack peek:" + stack.peek());
        System.out.println("isEmpty:" + stack.isEmpty());
        System.out.println("size:" + stack.size());

    }
}

class StackLinkedList {
    Node top;
    int size;
    final static int MAX_SIZE = 1024 * 1024 / 4;

    public StackLinkedList() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }

        return top.value;
    }

    public void push(int value) {
        if (size >= MAX_SIZE) {
            throw new RuntimeException("Stack is Full");
        }
        Node node = new Node(value);
        node.next = top;
        top = node;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        int value = top.value;
        top = top.next;
        size--;
        return value;
    }

    public void print(){
        Node temp=top;
        while(temp!=null){
            System.out.print(temp.value+"->");
            temp=temp.next;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> positionMap = new TreeMap<>();
        for (int i = 0; i < position.length; i++) {
            positionMap.put(position[i], speed[i]);
        }

        Stack<Double> stack = new Stack<>();

        for (Map.Entry<Integer, Integer> entry:positionMap.entrySet()) {

            Double time = (target - entry.getKey()) / (double) entry.getValue();
            if (!stack.isEmpty() && time >= stack.peek()) {
                stack.pop();
            }

            stack.push(time);

        }
        return stack.size();
    }

    public void reverse(){
        Node currentNode=top;
        Node prev=null;
        while(currentNode!=null){
            Node nextNode=currentNode.next;
            currentNode.next=prev;
            prev=currentNode;
            currentNode=nextNode;
        }
        top=prev;
    }

}

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}
