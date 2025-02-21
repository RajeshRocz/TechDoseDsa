package dsa.array.sliding_window;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaxSumInSubarray {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 6, 2, 3, 7};
        int k = 3;
        System.out.println("Max sum subarray:" + getMaxSumSubarray(nums, k));
        System.out.println("Min sum subarray:" + getMinSumSubarray(nums, k));
    }

    private static int getMaxSumSubarray(int[] nums, int k) {
        String s="jkdsbfckj";
        Map<Character,Long> frequencyMap=s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int left = 0, right = 0;
        int n = nums.length;
        int result = Integer.MIN_VALUE;
        int currentSum = 0;
        int prevValue = 0;

        while (right < n) {
            currentSum += nums[right];
            if (right - left + 1 == k) {
                currentSum -= prevValue;
                result = Math.max(result, currentSum);
                prevValue = nums[left];
                left++;
            }
            right++;
        }
        return result;
    }

    private static int getMinSumSubarray(int[] nums, int k) {
        int left = 0, right = 0;
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        int currentSum = 0;
        int prevValue = 0;

        while (right < n) {
            currentSum += nums[right];
            if (right - left + 1 == k) {
                currentSum -= prevValue;
                result = Math.min(result, currentSum);
                prevValue = nums[left];
                left++;
            }
            right++;
        }
        return result;
    }
}
