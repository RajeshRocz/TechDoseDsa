package NumberThoery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFactorization {

    public static void main(String[] args){
        System.out.println("Result: "+ Arrays.toString(getPrimeFactorization(34)));
    }

    private static int[] getPrimeFactorization(int n){
        List<Integer> factor=new ArrayList<>();

        for(int i=2;i*i<=n;i++){
            while(n>1 && n%i==0){
                factor.add(i);
                n/=i;
            }
        }
        if(n>1){
            factor.add(n);
        }
        return factor.stream().mapToInt(Integer::intValue).toArray();
    }
}
