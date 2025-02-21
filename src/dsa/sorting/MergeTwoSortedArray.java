package dsa.sorting;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 8};
        int[] b = new int[]{1, 4, 5};
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] > b[j]) {
                int t = a[i];
                a[i] = b[j];
                b[j] = t;
                i++;
            } else {
                j++;
            }

        }
        while (j+1 < b.length) {
            if (b[j] > b[j + 1]) {
                int s = b[j];
                b[j] = b[j + 1];
                b[j + 1] = s;
            }
            j++;
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));


    }
}
