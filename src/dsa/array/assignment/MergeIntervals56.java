package dsa.array.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals56 {
    public static void main(String[] args) {

        int[][] intervals=new int[][]{
                {1,3},{2,6},{8,10},{15,18}
        };
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    public static int[][] merge(int[][] intervals) {

        List<List<Integer>> result=new ArrayList<>();
        int start=intervals[0][0];
        int end=intervals[0][1];
        int n=intervals.length;
        for(int i=1;i<n;i++){
            if(end>=intervals[i][0]){
                end=intervals[i][1];
            }else{
                result.add(new ArrayList<>(List.of(start,end)));
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        result.add(new ArrayList<>(List.of(start,end)));
        int rows = result.size();
        int columns = result.get(0).size();
        int[][] array = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            List<Integer> row = result.get(i);
            for (int j = 0; j < row.size(); j++) {
                array[i][j] = row.get(j);
            }
        }
        return array;
    }
}
