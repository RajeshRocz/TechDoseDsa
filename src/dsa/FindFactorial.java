package dsa;

import java.util.Arrays;

public class FindFactorial {

    public static void main(String[] args) {
        System.out.println("Result:" + getFactorial(5));
        int n=5,r=3,m=5;
        int[] factorialMod = getFactorialMod(n, m);
       int nF=factorialMod[5];
       long b=factorialMod[n-r]*factorialMod[r];
       long bP=getExponenetial(b,m-2, m);
       long result=((nF%5)*(bP%5))%m;
        System.out.println("Factorial mod values:"+result);

        int t=5;
        String s= String.valueOf(t);

        System.out.println(Math.pow(10,Math.ceil(Math.log10(1001))));

        System.out.println((int) 1e9 + 7);
    }

    private static long getExponenetial(long base, long power, int m){
        long result=1;
        while(power>0){
            if(power%2==1){
                result=((base%m) * (result%5))%m;
            }
            power=power/2;
            base=((base%m)*(base%m))%m;
        }
        return result;
    }

    private static long getFactorial(int n) {

        if (n == 1) {
            return 1;
        }
        return n * getFactorial(n - 1);
    }

    private static int[] getFactorialMod(int n, int m){
        int[] fact=new int[n+1];
        Arrays.fill(fact, 1);
        for(int i=2;i<=n;i++){
            fact[i]= ((i%m) * (fact[i-1]%m))%m;
        }
        return fact;
     }
}
