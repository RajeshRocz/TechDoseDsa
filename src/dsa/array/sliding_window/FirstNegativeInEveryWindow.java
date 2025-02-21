package dsa.array.sliding_window;

import java.util.*;

public class FirstNegativeInEveryWindow {

    public static void main(String[] args) {
        int[] nums = new int[]{2, -3, 4, -1, -2, 1, 5, 3};
        int k = 3;
        System.out.println("GetFirstNegative number list:" + getFirstNegativeInEveryWindow(nums, k));
        System.out.println("GetFirstNegative number list(dequeue):" + FirstNegativeInteger(nums, k));

    }

    private static List<Integer> getFirstNegativeInEveryWindow(int[] nums, int k) {
        int start = 0, end = k - 1;
        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        while (end < n) {
            int negativeNumber = getFirstNegativeNumber(nums, start, end);
            result.add(negativeNumber);
            start++;
            end++;
        }
        return result;
    }

    private static int getFirstNegativeNumber(int[] nums, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (nums[i] < 0) {
                return nums[i];
            }
        }
        return 0;
    }

    private static List<Integer> FirstNegativeInteger(int arr[], int k) {
        // A Double Ended Queue to store indexes of useful array elements for the
        // current window of size k. The useful elements are all negative integers.
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;

        // Process first k (or first window) elements of array
        for (int i = 0; i < k; i++) {
            // Add current element at the rear of deque if it is a negative integer
            if (arr[i] < 0) {
                deque.addLast(i);
            }
        }

        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for (int i = k; i < arr.length; i++) {
            // If deque is not empty, then the element at the front of the queue is the
            // first negative integer of the previous window
            if (!deque.isEmpty()) {
                ans.add(arr[deque.peekFirst()]);
            } else {
                // Else the window does not have a negative integer
                ans.add(0);
            }

            // Remove the elements which are out of this window
            while (!deque.isEmpty() && deque.peekFirst() < (i - k + 1)) {
                deque.removeFirst(); // Remove from front of queue
            }

            // Add current element at the rear of deque if it is a negative integer
            if (arr[i] < 0) {
                deque.addLast(i);
            }
        }

        // Print the first negative integer of the last window
        if (!deque.isEmpty()) {
            ans.add(arr[deque.peekFirst()]);
        } else {
            ans.add(0);
        }

        return ans;
    }
}
