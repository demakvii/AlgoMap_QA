package com.mak;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    private static final int RIGHT = 0;
    private static final int DOWN = 1;
    private static final int LEFT = 2;
    private static final int UP = 3;

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}}));
    }


    public static List<Integer> spiralOrder(int[][] matrix) {
        var result = new ArrayList<Integer>();
        int move = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int right = n;
        int down = m;
        int left = -1;
        int up = 0;

        int i = 0;
        int j = 0;
        while (result.size() != m * n){
            if(RIGHT == move){
                while (j < right){
                    add(result, matrix[i][j]);
                    j++;
                }
                i++;
                j--;
                right--;
                move = DOWN;
            }
            else if(DOWN == move) {
                while (i < down) {
                    add(result, matrix[i][j]);
                    i++;
                }
                i--;
                j--;
                down--;
                move = LEFT;
            }
            else if(LEFT == move) {
                while (j > left){
                    add(result, matrix[i][j]);
                    j--;
                }
                i--;
                j++;
                left++;
                move = UP;
            }
            else {
                while (i > up){
                    add(result, matrix[i][j]);
                    i--;
                }
                i++;
                j++;
                up++;
                move = RIGHT;
            }
        }
        return result;
    }

    private static void add(List<Integer> numbers, int ele) {
        System.out.print(ele + " ");
        numbers.add(ele);
    }
}
