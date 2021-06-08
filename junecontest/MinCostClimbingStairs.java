package leetcode.junecontest;

public class MinCostClimbingStairs {

    public static void main(String[] args) {

        int[] cost = { 10, 15, 20 };
        Solution solution = new Solution();
        System.out.println(solution.minCostClimbingStairs(cost));
    }

    static class Solution {
        public int minCostClimbingStairs(int[] cost) {

            if(cost.length == 1) return 0;

            if(cost.length == 2) return Math.min(cost[0], cost[1]);

            int[] minCostArray = new int[cost.length];
            minCostArray[0] = cost[0];
            minCostArray[1] = cost[1];

            for(int i = 2; i < cost.length; ++i) {
                minCostArray[i] = Math.min(minCostArray[i - 1], minCostArray[i - 2]) + cost[i];
            }

            return Math.min(minCostArray[minCostArray.length - 1], minCostArray[minCostArray.length - 2]);
        }
    }
}
