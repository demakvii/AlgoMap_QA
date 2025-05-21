package com.mak;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String... strs) {
        int window = 0;
        var result = new StringBuilder("");
        var ch = new int[26];
        while (true) {
            var break1 = false;
            for (var str : strs) {
                if (window >= str.length()) {
                    break1 = true;
                    break;
                }
                ch[str.charAt(window) - 'a']++;
            }
            if (break1)
                break;
            for(var ch1 : ch){
                if(ch1 % strs.length != 0) {
                    break1 = true;
                    break;
                }
            }
            if (break1) {
                break;
            }
            result.append(strs[0].charAt(window));
            window++;
        }

        return result.toString();
    }
//
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix("flower","flow","flight"));
        System.out.println(longestCommonPrefix("dog","racecar","car"));
        System.out.println(longestCommonPrefix("aaa","aaaa","aaaa"));
    }


}
