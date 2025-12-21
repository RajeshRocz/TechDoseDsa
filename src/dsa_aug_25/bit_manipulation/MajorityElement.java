package dsa_aug_25.bit_manipulation;

/*
169. Majority Element
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 2, 2, 3, 3, 3, 3};
        System.out.println("Result:" + majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int numbers = 0;

        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                if ((num & (1 << i)) != 0) {
                    count++;
                }
            }
            if (count > nums.length / 2) {
                numbers += 1 << i;
            }
        }
        int count = 0;
        for (int num : nums) {
            if (num == numbers) {
                count++;
            }
        }

        return count > nums.length / 2 ? numbers : -1;
    }

}
