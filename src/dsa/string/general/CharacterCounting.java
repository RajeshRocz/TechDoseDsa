package dsa.string.general;

import java.util.HashMap;
import java.util.Map;

//Count number of substrings with exactly k distinct characters
public class CharacterCounting {

    public static void main(String[] args) {
        System.out.println(getSubStringCountExactkDistinctElements("aba", 2));
    }

    private static int getSubStringCountExactkDistinctElements(String str, int k) {

        return getSubStringCountAtmostkDistinctElements(str, k) - getSubStringCountAtmostkDistinctElements(str, k - 1);

    }

    private static int getSubStringCountAtmostkDistinctElements(String str, int k) {
        int left = 0;
        Map<Character, Integer> count = new HashMap<>();
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
            while ((count.size() > k)) {
                char c1 = str.charAt(left++);
                count.put(c1, count.getOrDefault(c1, 0) - 1);
                if (count.get(c1) == 0) {
                    count.remove(c1);
                }
            }
            num = num + i - left + 1;

        }

        return num;
    }
}
