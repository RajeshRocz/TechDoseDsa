package practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Practice {

    public static void main(String[] args) {
        Map<String, Integer> map = Map.of(
                "Banana", 4,
                "Apple", 3,
                "Orange", 3,
                "Strawberry", 5
        );

       List<Integer> numbers=List.of(1, 2, 3, 4, 5,2,4,2,3);

       List<Integer> even=numbers.stream().filter(num->num%2==0).toList();
       Integer max=numbers.stream().mapToInt(Integer::intValue).sum();


       List<String> names=List.of("Alice Jhonson", "Bob Harris", "Charlie Lou");
       List<String> boldNames=names.stream().map(String::toUpperCase).toList();

       List<Integer> sortedNumbers=numbers.stream().sorted().toList();
       Long count=numbers.stream().filter(n->n>4).count();

       List<Integer> distinctList=numbers.stream().distinct().toList();

       Integer sum=numbers.stream().reduce(0, Integer::sum);

       Optional<Integer> resultFind=numbers.stream().filter(n->n>4).findAny();

       List<String> firstNames=names.stream().map(name->name.split(" ")[0]).toList();
        Boolean allMatch=numbers.stream().allMatch(num->num>1);
        Boolean nonMatch=numbers.stream().noneMatch(num->num<1);

        Integer findFirst=numbers.stream().findFirst().get();
        List<List<Integer>> nestedNumbers=List.of(List.of(2,1,4,3,5,7,6,8),List.of(6,3,6,4,2,7));
        List<Integer> sortedNestedNumbers=nestedNumbers.stream().flatMap(Collection::stream)
                        .sorted().toList();


        Map<String, User> userMap=Map.of("Alice", new User("Alice",25),
                "Bob",new User("Bob", 28),"Charlie", new User("Charlie", 28));

        Map<Integer, List<User>> groupByAge=userMap.values().stream().collect(Collectors.groupingBy(User::age));
        Map<String, List<User>> groupByName=userMap.values().stream().collect(Collectors.groupingBy(User::name));

        List<Integer> numbersPeek=numbers.stream().peek(System.out::println).toList();

        List<Integer> numbersLimit=numbers.stream().limit(5).toList();

        List<Integer> numbersSkip=numbers.stream().skip(5).toList();

        Set<Integer> numbersSet=numbers.stream().collect(Collectors.toSet());

        IntSummaryStatistics intSummaryStatistics=numbers.stream().mapToInt(Integer::intValue).summaryStatistics();


        System.out.println(intSummaryStatistics);



    }

     record User(String name,Integer age){

    }
}
