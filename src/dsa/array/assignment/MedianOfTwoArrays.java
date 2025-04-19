package dsa.array.assignment;

public class MedianOfTwoArrays {

    public static void main(String[] args) {
        System.out.println("Result:"+findMedianSortedArrays(new int[]{1}, new int[]{}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums2.length < nums1.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0;
        int high = m;

        while (low <= high) {
            int cutx = (low + high)>>1;
            int cuty = (m + n +1) / 2 - cutx;

            int left1 = cutx == 0 ? Integer.MIN_VALUE : nums1[cutx - 1];
            int left2 = cuty == 0 ? Integer.MIN_VALUE : nums2[cuty - 1];

            int right1 = cutx == m ? Integer.MAX_VALUE : nums1[cutx];
            int right2 = cuty == n ? Integer.MAX_VALUE : nums2[cuty];

            if (left1 <= right2 && left2 <= right1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            } else if (left1 > right2) {
                high = cutx - 1;
            } else {
                low = cutx + 1;
            }

        }

        return 0.0;
    }
}
