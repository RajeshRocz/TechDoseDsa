package dsa_aug_25.bit_manipulation;
/*
136. Single Number
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.
Example 1:

Input: nums = [2,2,1]

Output: 1

 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums=new int[]{4,1,2,1,2};
        System.out.println("Result:"+singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int result=0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }
}
