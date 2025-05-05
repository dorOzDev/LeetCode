package topinterview150.easy.happynumber;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean isHappy(int n) {
        if(n == 1) {
            return true;
        }

        Set<Integer> seen = new HashSet<>();
        int squareSum = calcSquareSum(n);

        while(!seen.contains(squareSum)) {
            if(squareSum == 1) {
                return true;
            }
            seen.add(squareSum);
            squareSum = calcSquareSum(squareSum);
        }

        return false;
    }

    private int calcSquareSum(int n) {
        int sum = 0;
        while(n > 0) {
            sum += ((n % 10) * (n % 10));
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        new Solution().isHappy(3);
    }
}
