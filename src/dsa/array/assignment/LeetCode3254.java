package dsa.array.assignment;

import java.util.ArrayList;
import java.util.List;

public class LeetCode3254 {
    public static void main(String[] args) {

    }

    public static int[] resultsArray(int[] nums, int k) {
        int start = 0;
        int end = k - 1;
        List<Integer> result = new ArrayList<>();
        while (end < nums.length) {
            result.add(getMaxElement(nums, start, end));
            start++;
            end++;
        }

        return result.stream().mapToInt(e->e).toArray();

    }

    private static int getMaxElement(int[] nums, int start, int end) {
        int prev = nums[start];
        for (int i = start + 1; i <= end; i++) {
            if (prev > nums[i]) {
                return -1;
            }
            prev = nums[i];
        }
        return nums[end];
    }
}
