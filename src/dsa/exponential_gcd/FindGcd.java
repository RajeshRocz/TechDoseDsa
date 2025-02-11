package dsa.exponential_gcd;

public class FindGcd {

    public static void main(String[] args) {
        System.out.println("Result:"+findGcd(60,36));
    }

    private static int findGcd(int a, int b){
        if(a==0){
            return b;
        }

        return findGcd(b%a,a);
    }
}
