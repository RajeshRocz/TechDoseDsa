package dsa.string.kmp;

public class SearchPattern {
    public static void main(String[] args) {

        System.out.println("Result:" + isPatternExist("abxabcabcaby", "abcaby"));
    }

    private static boolean isPatternExist(String text, String pattern) {

        int[] lps = getLpsArray(pattern);
        int i = 0;
        int j = 0;
        int n = text.length();
        while (i < n) {

            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;

            } else {

                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }


        }
        if (j == pattern.length()) {
            return true;
        }
        return false;

    }

    private static int[] getLpsArray(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        lps[0] = 0;
        int i = 0;
        int j = 1;
        while (j < n) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
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
