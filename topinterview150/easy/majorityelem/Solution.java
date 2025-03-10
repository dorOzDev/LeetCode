package topinterview150.easy.majorityelem;

public class Solution {

    public int majorityElement(int[] nums) {
        int ans = nums[0];
        int counter = 0;
        for(Integer num : nums) {
            if(num == ans) {
                counter++;
            } else {
                counter--;
                if(counter == 0) {
                    counter = 1;
                    ans = num;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        new Solution().majorityElement(new int[] {3, 2, 3});
    }
}
