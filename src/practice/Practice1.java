package practice;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Practice1 {

    public static void main(String[] args){
        String s="Java is a powerful programming language";
       Map<String, Long> frequencyMap=Arrays.stream(s.split("")).map(String::toLowerCase)
               .collect(
               Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())
       );

       System.out.println(frequencyMap);


       

    }
}
