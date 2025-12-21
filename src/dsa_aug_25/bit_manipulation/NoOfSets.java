package dsa_aug_25.bit_manipulation;

import java.util.ArrayList;
import java.util.List;

public class NoOfSets {

    public static void main(String[] args){
        int[] nums=new int[]{1,2,3};
        List<List<Integer>> result=getNoOfSets(nums);
        System.out.println(result);
    }

    private static List<List<Integer>> getNoOfSets(int[] nums) {

        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int mask = 0; mask < (1 << n); mask++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {

                if ((mask & (1 << j)) != 0) {
                    list.add(nums[j]);
                }

            }
            result.add(list);
        }

        return result;
    }
}
