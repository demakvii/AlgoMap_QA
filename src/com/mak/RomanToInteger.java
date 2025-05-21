package com.mak;

import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        var map = Map.of('I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000);
        var count = 0;
        var i = 0;
        var n = s.length();
        while (i < n){
            if(i < n-1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))){
                count += map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
                i += 2;
            } else {
                count += map.get(s.charAt(i));
                i++;
            }

        }
        return count;
    }
}
