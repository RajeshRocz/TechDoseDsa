package dsa.exponential_gcd;

public class BinaryExponential {

    public static void main(String[] args) {
        System.out.println("findBinaryExponential:"+findBinaryExponential(2,7));
        System.out.println("Math.pow result:"+Math.pow(2,7));
        System.out.println("findBinaryExponentialModular:"+findBinaryExponentialModular(2,7, 5));
    }

    private static long findBinaryExponential(long base, long power) {

        long result = 1;

        while (power > 0) {
            if (power % 2 == 1) {
                result *= base;
            }
            base = base * base;
            power = power / 2;
        }

        return result;
    }

    private static long findBinaryExponentialModular(long base, long power, long modular){
        long result=1;

        while(power>0){
            if(power%2==1){
                result=((result%modular)*(base%modular))%modular;
            }
            base=((base%modular)*(base%modular))%modular;
            power/=2;
        }

        return result%modular;
    }
}
