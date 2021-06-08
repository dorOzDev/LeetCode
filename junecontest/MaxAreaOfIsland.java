package leetcode.junecontest;

import java.util.LinkedList;

class MaxAreaOfIsland {

    static int[][] grid;
    static int[] adjRow = {-1, 0, 1, 0};
    static int[] adjCol = {0, -1, 0, 1};

    public static void main(String[] args) {

        int [][]grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {

        MaxAreaOfIsland.grid = grid;
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int maxArea = 0;

        for(int row = 0; row < grid.length; ++row) {

            for(int col = 0; col < grid[row].length; ++col) {
                if(grid[row][col] == 1 && !seen[row][col]) {
                    maxArea = Math.max(maxArea, bfsArea(row, col, seen));
                }
            }
        }

        return maxArea;
    }

    private static int bfsArea(int x, int y, boolean[][] seen) {

        int size = 0;
        LinkedList<MyPair> queue = new LinkedList<>();
        queue.add(new MyPair(x, y));
        seen[x][y] = true;

        while(!queue.isEmpty()) {
            size++;
            MyPair currElem = queue.pop();
            for(int i = 0; i < 4; ++i) {
                int adjX = currElem.first + adjRow[i];
                int adjY = currElem.second + adjCol[i];

                if(isValidAdj(adjX, adjY) && grid[adjX][adjY] == 1 && !seen[adjX][adjY]) {
                    queue.add(new MyPair(adjX, adjY));
                    seen[adjX][adjY] = true;
                }
            }
        }
        return size;
    }

    private static boolean isValidAdj(int x, int y) {

        return (x >= 0 && grid.length > x) && (y >= 0 && grid[0].length > y);
    }

    static class MyPair {

        int first;
        int second;

        public MyPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
