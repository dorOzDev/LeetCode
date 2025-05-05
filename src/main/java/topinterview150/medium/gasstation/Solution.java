package topinterview150.medium.gasstation;

public class Solution {

    public static final int UNREACHABLE = -1;

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diffArray = new int[gas.length];
        int total = 0;
        for(int i = 0; i < gas.length; ++i) {
            diffArray[i] = gas[i] - cost[i];
            total += diffArray[i];
        }

        if(total < 0) {
            return UNREACHABLE;
        }

        int currIndex = 0;
        int currTotal = 0;
        int currCountStations = 0;
        while(currCountStations < cost.length) {
            currTotal += diffArray[currIndex];
            if(currTotal < 0) {
                currCountStations = 0;
                currTotal = 0;
            } else {
                currCountStations++;
            }
            currIndex = (currIndex + 1) % gas.length;
        }

        return currIndex;
    }

    public static void main(String[] args) {
        int sol = new Solution().canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2});
        System.out.println(sol);
    }
}
