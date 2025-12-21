package dsa.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 6, 3, 7, 1, 2};
        System.out.println(Arrays.toString(nums));
        quickSort1(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] nums, int i, int j) {
        int pivot = j;
        if (i >= j) {
            return;
        }
        while (i < j) {
            if (nums[i] > nums[pivot]) {
                j--;
                int t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
            } else {
                i++;
            }
        }
        int s = nums[pivot];
        nums[pivot] = nums[i];
        nums[i] = s;
        quickSort(nums, 0, i - 1);
        quickSort(nums, i + 1, pivot);
    }

    private static void quickSort1(int[] nums, int i, int j ){
        int pivot=j;
        if(i>=j){
            return;
        }
        while(i<j) {
            if (nums[i] > nums[pivot]) {
                j--;
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            } else {
                i++;
            }
        }

        int t=nums[pivot];
        nums[pivot]=nums[i];
        nums[i]=t;
        quickSort1(nums, 0, i-1);
        quickSort1(nums,i+1,pivot);
    }
}
