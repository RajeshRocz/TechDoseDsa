package dsa.exponential_gcd;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {

    public static void main(String[] args) {
        System.out.println("Result:"+getPrimeFactorization(17));
    }

    private static List<Integer> getPrimeFactorization(int n){

        List<Integer> factorizationList=new ArrayList<>();
        for(int i=2;i*i<=n;i++){
            while(n%i==0){
                factorizationList.add(i);
                n=n/i;
            }
        }
        factorizationList.add(n);

        return factorizationList;
    }
}
