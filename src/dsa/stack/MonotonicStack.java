package dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class MonotonicStack {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 4, 6, 1};
        System.out.println("Input Elements:" + Arrays.toString(nums));

        System.out.println("Next Largest Elements:" + Arrays.toString(getNextLargestElement(nums)));
    }

    public static int[] getNextLargestElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[n - 1] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.add(nums[n - 1]);

        for (int i = nums.length - 2; i >= 0; i--) {
            if (stack.peek() > nums[i]) {
                result[i] = stack.peek();
                stack.add(nums[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() < nums[i]) {
                    stack.pop();
                }
                result[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.add(nums[i]);
            }
        }

        return result;
    }
}
