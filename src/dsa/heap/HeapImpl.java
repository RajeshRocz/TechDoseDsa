package dsa.heap;

import java.util.ArrayList;
import java.util.List;

public class HeapImpl {

    public static void main(String[] args) {
        Heap heap = new Heap();
        int[] nums = new int[]{3, 8, 4, 6, 9, 1, 2};
        heap.buildHeap(nums);
        heap.printHeap();
        System.out.println("Poped value:" + heap.heapPop());
        heap.printHeap();
        heap.heapPush(10);
        heap.printHeap();
        heap.heapPop();
        heap.printHeap();
        heap.increaseValue(1, 18);
        heap.printHeap();
        heap.increaseValue(2, 28);
        heap.printHeap();
        heap.decreaseValue(1, 10);
        heap.printHeap();
        System.out.println("Sorted:" + heap.heapSort());
    }

}

class Heap {
    List<Integer> maxHeap;
    Integer size;

    public Heap() {
        size = 1024 * 1024 / 4;
        maxHeap = new ArrayList<>();
        maxHeap.add(-1);
    }

    public void maxHeapify(int pos) {

        int left = 2 * pos;
        int right = 2 * pos + 1;
        int largest = pos;

        if (left < maxHeap.size() && maxHeap.get(left) > maxHeap.get(largest)) {
            largest = left;
        }
        if (right < maxHeap.size() && maxHeap.get(right) > maxHeap.get(largest)) {
            largest = right;
        }

        if (pos != largest) {
            swapValues(pos, largest);
            maxHeapify(largest);
        }

    }


    public void buildHeap(int[] values) {
        for (int i = 0; i < values.length; i++) {
            maxHeap.add(values[i]);
        }

        for (int i = maxHeap.size() - 1; i > 0; i--) {
            maxHeapify(i);
        }
    }

    public Integer heapPop() {
        if (maxHeap.isEmpty()) {
            throw new RuntimeException("Heap is Empty");
        }
        int top = maxHeap.get(1);
        swapValues(1, maxHeap.size() - 1);
        maxHeap.removeLast();
        maxHeapify(1);
        return top;
    }

    public void heapPush(Integer value) {
        if (maxHeap.size() > size) {
            throw new RuntimeException("Heap is full");
        }
        maxHeap.addLast(value);
        int n = maxHeap.size() - 1;
        while (n > 1 && maxHeap.get(n) > maxHeap.get(n / 2)) {
            swapValues(n, n / 2);
            n /= 2;
        }
    }

    public void increaseValue(int pos, int newValue) {
        if (maxHeap.get(pos) > newValue) {
            throw new RuntimeException("Wrong operation:Already value is higher than update value");
        }
        maxHeap.set(pos, newValue);
        while (pos > 1 && maxHeap.get(pos) > maxHeap.get(pos / 2)) {
            swapValues(pos, pos / 2);
            pos /= 2;
        }
    }

    public void decreaseValue(int pos, int newValue) {
        if (maxHeap.get(pos) < newValue) {
            throw new RuntimeException("Wrong operation: existing value lesser than newValue");
        }

        maxHeap.set(pos, newValue);
        maxHeapify(pos);
    }

    public void printHeap() {
        System.out.println(maxHeap.stream().skip(1).toList());
    }

    public List<Integer> heapSort() {
        List<Integer> result = new ArrayList<>();
        int i = maxHeap.size() - 1;
        while (i > 0) {
            result.add(maxHeap.get(1));
            swapValues(1, i);
            maxHeap.removeLast();
            maxHeapify(1);
            i--;
        }
        return result.reversed();
    }

    private void swapValues(int index1, int index2) {
        int temp = maxHeap.get(index1);
        maxHeap.set(index1, maxHeap.get(index2));
        maxHeap.set(index2, temp);
    }
}
