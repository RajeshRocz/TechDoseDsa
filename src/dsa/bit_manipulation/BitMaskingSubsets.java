package dsa.bit_manipulation;

import java.util.HashSet;
import java.util.Set;

public class BitMaskingSubsets {

    public static void main(String[] args) {
        //Calculate all possible subsets
        int[] nums = new int[]{2, 3, 4, 5}; // 2^4
        System.out.println("2^4: " + Math.pow(2, 4));
        Set<Set<Integer>> resultSet = getSubSets(nums);
        System.out.println("Result set size: " + getSubSets(nums).size());
        System.out.println("Result Subsets: " + resultSet);
    }

    private static Set<Set<Integer>> getSubSets(int[] nums) {
        int n = nums.length;
        Set<Set<Integer>> resultSet = new HashSet<>();
        for (int i = 0; i < (1 << n); i++) {
            Set<Integer> subSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subSet.add(nums[j]);
                }
            }
            resultSet.add(subSet);
        }
        return resultSet;
    }
}
