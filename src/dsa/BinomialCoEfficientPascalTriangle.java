package dsa;


//Find NCR=(N!)/(N-R)! R! using pascal triangle
public class BinomialCoEfficientPascalTriangle {

    public static void main(String[] args) {
        System.out.println("NCR result:"+getNcrResultUsingPascalTriangle(70,65));
    }

    private static long getNcrResultUsingPascalTriangle(long n, long r){

        long[][] pascalMatrix=new long[(int) (n+1)][(int) (n+1)];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=i;j++){
                if(j==0 || i==j){
                    pascalMatrix[i][j]=1;
                }else {
                    pascalMatrix[i][j]=pascalMatrix[i-1][j]+pascalMatrix[i-1][j-1];
                }
            }
        }

        return pascalMatrix[(int) n][(int) r];
    }
}
