package dsa.string.kmp;

public class SearchPattern1 {

    public static void main(String[] args) {

        System.out.println("Result:" + isPattenExist("abxabcabcaby", "abcabyu"));
    }


    private static boolean isPattenExist(String word, String pattern){
        int[] lps=getLps(pattern);
        int i=0;
        int j=0;
        int n=word.length();
        while(i<n){
            if(word.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
            }else {
                if(j>0){
                    j=lps[j-1];
                }else{
                    i++;
                }
            }

        }
        return j == pattern.length();
    }

    private static int[] getLps(String pattern){
        int n=pattern.length();
        int i=0;
        int j=1;
        int[] lps=new int[n];
        lps[0]=0;
        while(j<n){
            if(pattern.charAt(i)==pattern.charAt(j)){
                lps[j]=i+1;
                j++;
                i++;
            }else{
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
