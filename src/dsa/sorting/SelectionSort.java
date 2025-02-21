package dsa.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 6, 3, 7, 1, 2};
        System.out.println(Arrays.toString(nums));
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void selectionSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int t = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = t;
            }
        }
    }
}
