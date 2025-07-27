package topinterviewquestions.array.singlenumber;

public class Solution {
    public int singleNumber(int[] nums) {
        int singleNum = 0;

        for(Integer num : nums) {
            singleNum ^= num;
        }

        return singleNum;
    }
}
