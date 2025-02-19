package dsa.binary_search;

public class SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] matrix=new int[][]{
                {1}
        };

        System.out.println(searchMatrix(matrix, 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int h = m - 1;
        while (l <= h) {
            int mid = l + ((h - l) / 2);
            if (matrix[mid][0] <= target && matrix[mid][n - 1] >= target) {
                break;
            } else if (matrix[mid][n - 1] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        if(l>h){
            return false;
        }

        int r = l + ((h - l) / 2);
        l = 0;
        h = n - 1;

        while (l <= h) {
            int mid = l + ((h - l) / 2);
            if (matrix[r][mid] == target) {
                return true;
            } else if (matrix[r][mid] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return false;

    }
}
