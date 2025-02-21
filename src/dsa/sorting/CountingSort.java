package dsa.sorting;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        int[] nums = new int[]{1,4,1,2,7,5,2};
        System.out.println(Arrays.toString(nums));

        System.out.println(Arrays.toString(countingSort(nums)));
    }

    private static int[] countingSort(int[] nums) {

        int[] frequency = new int[10];
        int[] cumFrequency = new int[10];
        int[] sorted = new int[nums.length];

        for (int i : nums) {
            frequency[i]++;
        }
        cumFrequency[0] = frequency[0];
        for (int i = 1; i < 10; i++) {
            cumFrequency[i] = cumFrequency[i - 1] + frequency[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            int pos = cumFrequency[nums[i]]--;
            sorted[pos - 1] = nums[i];
        }

        return sorted;
    }
}
