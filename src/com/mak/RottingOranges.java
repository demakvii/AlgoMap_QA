package com.mak;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][] {{2,1,1}, {1,1,0}, {0,1,1}}));
        System.out.println(orangesRotting(new int[][] {{2,1,1}, {0,1,1}, {1,0,1}}));
    }

    public static int orangesRotting(int[][] grid) {
        int time = 0;
        int fresh = 0;
        Queue<String> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1)
                    fresh++;
                else if(grid[i][j] == 2){
                    queue.add(i + "," + j);
                }
            }
        }
        int[][] directions = new int[][]{
                {0, 1}, {0, -1}, {1, 0}, {-1, 0}

        };
        while (!queue.isEmpty() && fresh > 0){
            int size = queue.size();
            for (int c = 0; c < size; c++){
                var ij = queue.poll();
                var i = Integer.parseInt(ij.split(",")[0]);
                var j = Integer.parseInt(ij.split(",")[1]);
                for(var direction : directions){
                    var row = direction[0] + i;
                    var column = direction[1] + j;
                    if(row < 0 || row == grid.length || column < 0 || column == grid[0].length ||
                        grid[row][column] != 1){
                        continue;
                    }
                    grid[row][column] = 2;
                    queue.add(row + "," + column);
                    fresh -= 1;
                }
            }
            time++;
        }
        return fresh > 0 ? -1 : time;
    }
}
