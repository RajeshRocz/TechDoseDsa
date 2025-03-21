package dsa.string.general;


//DP problem
public class LongestCommonSubstring {

    public static void main(String[] args) {
        System.out.println("LargestCommonSubstringLength:"+getLargestCommonSubstring("geeksforgeeks","geeksquiz"));
    }

    private static int getLargestCommonSubstring(String s1, String s2){
        int m=s1.length();
        int n=s2.length();
        int res=0;

        if(m==0 || n==0){
            return res;
        }
        int[][] LCSuff= new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    LCSuff[i][j]=LCSuff[i-1][j-1]+1;
                }else{
                    LCSuff[i][j]=0;
                }
                res=Math.max(res, LCSuff[i][j]);
            }
        }
        return res;
    }
}
