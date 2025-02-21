package dsa.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums=new int[]{2, 3, 8,1, 4, 5};
        mergeSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    private static void mergeSort(int[] nums, int l, int h){
        if(l==h){
            return;
        }

        int mid=l+((h-l)/2);

        mergeSort(nums,l,mid);
        mergeSort(nums, mid+1, h);
        mergeValues(nums, l, mid,h);
    }
//TODO need to fix
    private static void mergeValues(int[] nums, int l, int mid, int h) {
        /*
        int n1=mid-l+1;
        int n2=h-mid;
        int i=l,j=mid+1;
        while(i<n1 && j<n2){
            if(nums[i]>nums[j]){
                int t=nums[i];
                nums[i]=nums[j];
                nums[j]=t;
                i++;
            }else{
                j++;
            }
        }

        while (j+1<=h){
            if(nums[j]>nums[j+1]){
                int s=nums[j];
                nums[j]=nums[j+1];
                nums[j]=s;
            }
            j++;
        }

         */
        // Find the sizes of the two subarrays to be merged
        int n1 = mid - l + 1;
        int n2 = h - mid;

        // Create temporary arrays to hold the values of the left and right subarrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays left[] and right[]
        System.arraycopy(nums, l, leftArray, 0, n1);
        System.arraycopy(nums, mid + 1, rightArray, 0, n2);

        // Merge the temporary arrays back into arr[left..right]
        int i = 0, j = 0, k = l;

        // Merge the two arrays until one of them is fully processed
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                nums[k++] = leftArray[i++];
            } else {
                nums[k++] = rightArray[j++];
            }
        }

        // Copy any remaining elements from leftArray, if any
        while (i < n1) {
            nums[k++] = leftArray[i++];
        }

        // Copy any remaining elements from rightArray, if any
        while (j < n2) {
            nums[k++] = rightArray[j++];
        }
    }

}
