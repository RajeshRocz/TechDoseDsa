package dsa_aug_25.bit_manipulation;


/*
137. Single Number II
Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
public class SingleNumberII {

    public static void main(String[] args) {
        int[] nums=new int[]{4,2,2,2};
        System.out.println("Result:"+singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {

        int ones=0;
        int twos=0;
        for(int num:nums){
            ones=(ones^num)&(~twos);
            twos=(twos^num)&(~ones);
        }
        return ones;
    }
    }
