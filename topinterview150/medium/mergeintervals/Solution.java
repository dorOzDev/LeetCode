package topinterview150.medium.mergeintervals;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int[][] merge(int[][] intervals) {
        int[][] ans = new int[intervals.length][2];
        Arrays.sort(intervals, Comparator.comparingInt(entry -> entry[0]));
        int lowerBound = intervals[0][0];
        int upperBound = intervals[0][1];
        int writeIndex = 0;
        for(int i = 0; i < intervals.length; ++i) {
            int localLowerBound = intervals[i][0];
            int localUpperBound = intervals[i][1];
            if(localLowerBound <= upperBound) {
                upperBound = Math.max(upperBound, localUpperBound);
            } else {
                lowerBound = localLowerBound;
                upperBound = localUpperBound;
                writeIndex++;
            }

            ans[writeIndex][0] = lowerBound;
            ans[writeIndex][1] = upperBound;
        }

        return Arrays.copyOf(ans, writeIndex + 1);
    }

    public static void main(String[] args) {
        new Solution().merge(new int[][] { {1, 4}, {0, 2}, {3, 5} });
    }
}
