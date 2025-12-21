package dsa.string.kmp;

public class FindShortestPalindrome1 {

    public static void main(String[] args) {
        System.out.println(getShortestPalindrome("aab"));
    }


    private static String getShortestPalindrome(String s){
        String original =s;
        s=String.valueOf(new StringBuilder(s).reverse());
        String tempString=original+"*"+s;
        int[] lps=getLps(tempString);
        int diff=s.length()-lps[tempString.length()-1];
        return s.substring(0,diff)+original;
    }

    private static int[] getLps(String s){
        int n=s.length();
        int[] lps=new int[n];
        int i=0;
        int j=1;
        lps[0]=0;
        while (j<n){
            if(s.charAt(i)==s.charAt(j)){
                lps[j]=i+1;
                i++;
                j++;
            }else {
                if(i>0){
                    i=lps[i-1];
                }else{
                    lps[j]=0;
                    j++;
                }
            }
        }
        return lps;
    }
}
