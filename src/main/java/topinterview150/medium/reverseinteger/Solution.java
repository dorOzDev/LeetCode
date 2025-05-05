package topinterview150.medium.reverseinteger;

public class Solution {

    public int reverse(int x) {
        int reversedNum = reverseInternal(x);

        if(x % 10 == 0 || x == reverseInternal(reversedNum)) {
            return reversedNum;
        }

        return 0;
    }

    private int reverseInternal(int x) {
        int reversedNum = 0;
        int copyX = x;
        int pow = totalNums(x);

        while(copyX != 0) {
            reversedNum += (copyX % 10 * (int)Math.pow(10, pow - 1));
            pow--;
            copyX /= 10;
        }

        return reversedNum;
    }

    private int totalNums(int x) {
        int totalNums = 0;
        while(x != 0) {
            totalNums++;
            x /= 10;
        }

        return totalNums;
    }

    public static void main(String[] args) {
        new Solution().reverse(-123);
    }
}
