package NumberThoery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDivisors {

    public static void main(String[] args) {
        System.out.println("Result: " + Arrays.toString(getDivisors(34)));
    }

    private static int[] getDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (n / i != i) {
                    divisors.add(n / i);
                }
            }
        }
        return divisors.stream().mapToInt(Integer::intValue).toArray();
    }
}
