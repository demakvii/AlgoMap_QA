package com.mak;

public class MergeStringsAlternately {

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqr"));
        System.out.println(mergeAlternately("ab", "pqrs"));
        System.out.println(mergeAlternately("abcd", "pq"));
    }

    public static String mergeAlternately(String word1, String word2) {
        int aLen = word1.length(), bLen = word2.length();
        int a = 0, b = 0;
        StringBuilder result = new StringBuilder();

        while (a < aLen && b < bLen) {
            result.append(word1.charAt(a++));
            result.append(word2.charAt(b++));
        }

        while (a < aLen) {
            result.append(word1.charAt(a++));
        }

        while (b < bLen) {
            result.append(word2.charAt(b++));
        }

        return result.toString();
    }
}
