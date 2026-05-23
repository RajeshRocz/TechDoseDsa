package NumberThoery;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MooseAlgorithm {

    public static void main(String[] args){
        distinctValues();
    }

    private static void distinctValues(){
        int[] numbers=new int[]{5,1,5,2,1,3,5,2,4,1,3};
        int[][] queries=new int[][]{
                {0,10},
                {1,3},
                {2,8},
                {0,4},
                {5,10},
                {3,6}
        };

        int n=numbers.length;
        int blockSize= (int) Math.sqrt(n);
        List<int[]> sorted = Arrays.stream(queries).sorted((a, b)->
                {
                    if(a[0]/blockSize == b[0]/blockSize){
                        return Integer.compare(a[1],b[1]);
                    }
                    return Integer.compare(a[0],b[0]);
                }
        ).toList();

        Map<Integer, Long> frequency= Arrays.stream(numbers).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int curL=0;
        int curR=-1;
        int distinct=0;

        for(int[] query: sorted){
            int l=query[0];
            int r=query[1];
                while(curL>l){
                    add(frequency, numbers, curL--);
                }
                while(curL<l){
                    remove(frequency, numbers, curL++);
                }

                while(curR>r){
                remove(frequency, numbers, curR--);
                }
                while(curR<r){
                    add(frequency, numbers, curR++);
                }

                System.out.println(frequency);
        }




    }

    private static void add(Map<Integer, Long> frequency, int[] numbers, int i){
        frequency.put(numbers[i], frequency.getOrDefault(numbers[i], 0L)+1);

    }

    private static void remove(Map<Integer, Long> frequency, int[] numbers, int i){
        frequency.put(numbers[i], frequency.get(numbers[i])-1);

    }
}
