package dsa_aug_25.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = new int[]{7,2,6,4,8,1,9};//{1, 2, 3, 4, 5, 6};
        System.out.println("Before Sort");
        Arrays.stream(a).forEach(i -> System.out.print(i + " "));
        bubbleSort(a);
        System.out.println("\nAfter Sort");
        Arrays.stream(a).forEach(i -> System.out.print(i + " "));
    }

    public static void bubbleSort(int[] a) {
        int n = a.length;
        for (int gap = 1; gap < n - 1; gap++) {
            boolean swapped = false;
            for (int i = 0; i < n - gap; i++) {
                if (a[i] > a[i + 1]) {
                    int t = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = t;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }

        }
    }
}
