package dsa_aug_25.dp;

import java.util.Arrays;

public class LongestSubSquence {

    public static void main(String[] args){
        String s1="AABBBBC";
        String s2="AABBBCC";
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        long start=System.currentTimeMillis();
        System.out.println(lcs(dp,s1,s2,s1.length(),s2.length()));
        long end= System.currentTimeMillis();
        System.out.println("Total time taken:"+(end-start));

         start=System.currentTimeMillis();
        System.out.println(lcs(s1,s2));
         end= System.currentTimeMillis();
        System.out.println("Total time taken:"+(end-start));
    }

    private static int lcs(int[][] dp,String s1,String s2,int m,int n){

        if(m==0 || n==0){
            return 0;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        if(s1.charAt(m-1)==s2.charAt(n-1)){
             dp[m][n]=1+lcs(dp,s1,s2,m-1,n-1);
             return dp[m][n];
        }
         dp[m][n]=Math.max(lcs(dp,s1,s2,m-1,n),lcs(dp,s1,s2,m,n-1));
        return dp[m][n];
    }

    private static int lcs(String s1,String s2){
        int[][] dp=new int[s1.length()+1][s2.length()+1];

        int m=s1.length();
        int n=s2.length();

        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
                else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
