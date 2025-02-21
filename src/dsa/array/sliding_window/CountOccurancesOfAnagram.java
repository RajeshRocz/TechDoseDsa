package dsa.array.sliding_window;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CountOccurancesOfAnagram {
    public static void main(String[] args) {
        System.out.println("Anagram count:"+search("kkkkk","kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"));
    }

    static int search(String pat, String txt) {

        Map<Character,Integer> patFrequency=new HashMap<>();
        for(char c: pat.toCharArray()){
            patFrequency.put(c, patFrequency.getOrDefault(c,0)+1);
        }

        int k=pat.length();
        int n=txt.length();
        int start=0;
        int end=k;
        int count=0;
        while(end<=n){
            if(isAnagram(patFrequency, txt.substring(start, end))){
                count++;
            }
            start++;
            end++;
        }
        return count;
    }

    static boolean isAnagram(Map<Character,Integer> frequency, String partString){

        Map<Character,Integer> partFrequency=new HashMap<>();
        for(char c: partString.toCharArray()){
            partFrequency.put(c, partFrequency.getOrDefault(c,0)+1);
        }

        for(Map.Entry<Character, Integer> m:frequency.entrySet()){
            if(!partFrequency.containsKey(m.getKey()) || !Objects.equals(partFrequency.get(m.getKey()), m.getValue())){
                return false;
            }
                partFrequency.remove(m.getKey());
        }

        return partFrequency.isEmpty();

    }
}
