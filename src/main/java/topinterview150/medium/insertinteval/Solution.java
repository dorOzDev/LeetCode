
package topinterview150.medium.insertinteval;

import utils.GeneralUtils;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalsList = new ArrayList<>();
        int i = 0;

        while(i < intervals.length && intervals[i][1] < newInterval[0]) {
            intervalsList.add(intervals[i]);
            i++;
        }

        int minLeft = newInterval[0];
        int maxRight = newInterval[1];
        while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
            minLeft = Math.min(minLeft, intervals[i][0]);
            maxRight = Math.max(maxRight, intervals[i][1]);
            i++;
        }
        intervalsList.add(new int[]{minLeft, maxRight});

        while(i < intervals.length) {
            intervalsList.add(intervals[i]);
            i++;
        }


        return intervalsList.toArray(new int[intervalsList.size()][]);
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3},
                {6, 9}
        };

        GeneralUtils.print2DArray(new Solution().insert(matrix, new int[]{2, 5}));
    }
}
