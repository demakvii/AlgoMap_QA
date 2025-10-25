package com.mak;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    private static String minWindow(String s, String t) {
        if (t.equals("")) return "";
        var tMap = t.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting()));
        int need = tMap.size();
        int have = 0;
        Map<Character, Long> windowMap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int j = 0;
        int[] result = new int[2];
        for(int i = 0; i< s.length(); i++){
            windowMap.put(s.charAt(i), windowMap.getOrDefault(s.charAt(i), 0L) + 1);
            if(tMap.containsKey(s.charAt(i)) && windowMap.get(s.charAt(i)).equals(tMap.get(s.charAt(i)))){
                have++;
            }
            while (have == need){
                if(i - j + 1 < min){
                    min = i - j + 1;
                    result[0] = i;
                    result[1] = j;
                }
                windowMap.put(s.charAt(j), windowMap.get(s.charAt(j)) - 1);
                if(tMap.containsKey(s.charAt(j)) && windowMap.get(s.charAt(j)).compareTo(tMap.get(s.charAt(j))) < 0){
                    have--;
                }
                j++;
            }
        }
        if (min != Integer.MAX_VALUE){
            return s.substring(Math.min(result[0], result[1]), Math.max(result[0], result[1]) + 1);
        }
        return "";
    }
}
