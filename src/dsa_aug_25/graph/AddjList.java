package dsa_aug_25.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddjList {
    public static void main(String[] args) {
        int[][] addList = new int[][]{
                {1, 0},
                {0, 1}, {2, 0}
        };
        System.out.println(getAdjecencyList(addList));
    }

    private static Map<Integer, List<Integer>> getAdjecencyList(int[][] adjencyList) {

        Map<Integer, List<Integer>> result = new HashMap<>();

        for (int[] addj : adjencyList) {
            var list = result.getOrDefault(addj[1], new ArrayList<>());
            list.add(addj[0]);
            result.put(addj[1], list);
        }

        return result;

    }
}
