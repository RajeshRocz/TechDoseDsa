package dsa.string.kmp;

public class FindShortestPalindrome {

    public static void main(String[] args) {
        System.out.println(findShortestPalindrome("aab"));
    }

    private static String findShortestPalindrome(String s) {

        String original = s;
        s = String.valueOf(new StringBuilder(s).reverse());
        String tempString = original + "*" + s;
        int[] lps = getLpsArray(tempString);

        int difference = s.length() - lps[tempString.length() - 1];
        return s.substring(0, difference) + original;

    }

    private static int[] getLpsArray(String s) {
        int i = 0;
        int j = 1;
        int[] lps = new int[s.length() + 1];
        lps[0] = 0;

        while (j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                lps[j] = i + 1;
                i++;
                j++;
            } else {
                if (i > 0) {
                    i = lps[i - 1];
                } else {
                    lps[j] = 0;
                    j++;
                }
            }
        }
        return lps;
    }
}
