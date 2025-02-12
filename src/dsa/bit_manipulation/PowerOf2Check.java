package dsa.bit_manipulation;

public class PowerOf2Check {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(8));
        System.out.println(toBinaryString(8));
        System.out.println("IsPower of two:"+isPowerOf2(8));
        System.out.println("IsPower of two:"+isPowerOf2AnotherWay(32));

    }

    private static boolean isPowerOf2(int n){
        int actual=Integer.parseInt(toBinaryString(n));
        int pre=Integer.parseInt(toBinaryString(n-1));
        int result= (n & (n-1)) ;
        return result==0;
    }

    private static boolean isPowerOf2AnotherWay(int n){
       int count=0;
       for(int i=0;i<32;i++) {
           if ((n & (1<<i))!=0) {
               count++;
           }
       }
       return  count==1;
    }

    private static String toBinaryString(int n){
        StringBuilder sb =new StringBuilder();
        while(n!=0){
            sb.append(n%2);
            n=n/2;
        }
        return sb.reverse().toString();
    }

}
