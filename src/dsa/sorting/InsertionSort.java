package dsa.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionSort {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 6, 3, 7, 1, 2};
        System.out.println(Arrays.toString(nums));
        List<Integer> result = new ArrayList<>();
        for (int i : nums) {
            result.add(i);
            insertionSort(result);
        }
        System.out.println(result);
    }

    //TODO Need fix
    private static void insertionSort(List<Integer> result) {
        int i = result.size() - 1;

        while (i > 0) {
            if (result.get(i) < result.get(i - 1)) {
                int t = result.get(i);
                int s=result.get(i-1);
                result.remove(i);
                result.remove(i-1);
                result.add(t);
                result.add(s);
            }
            i--;
        }
    }
}
