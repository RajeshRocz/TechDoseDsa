package dsa.sorting;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int[] nums = new int[]{170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println(Arrays.toString(nums));

        System.out.println(Arrays.toString(radixSort(nums)));
    }

    private static int[] radixSort(int[] nums) {

        int maxValue = Integer.MIN_VALUE;
        for (int i : nums) {
            maxValue = Math.max(maxValue, i);
        }
        int k = (int) Math.ceil(Math.log10(maxValue));
        int m = 0;
        while (m < k) {
            int[] frequency = new int[10];
            int[] cumFrequency = new int[10];

            for (int i : nums) {
                int d = (i / (int) Math.pow(10, m));
                frequency[d % 10]++;
            }

            cumFrequency[0] = frequency[0];
            for (int i = 1; i < 10; i++) {
                cumFrequency[i] = cumFrequency[i - 1] + frequency[i];
            }
            int[] sorted = new int[nums.length];

            for (int i = nums.length - 1; i >= 0; i--) {
                int d = (nums[i] / (int) Math.pow(10, m));
                int pos = cumFrequency[d % 10]--;
                sorted[pos - 1] = nums[i];
            }
            nums = sorted;
            m++;
        }
        return nums;
    }
}
