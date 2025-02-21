package dsa.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 6, 3, 7, 1, 2};
        System.out.println(Arrays.toString(nums));
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int t = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = t;
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                return;
            }
        }
    }

}
