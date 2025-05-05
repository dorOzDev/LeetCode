package topinterview150.easy.containsduplicate2;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();

        for(int i = 0; i < nums.length; ++i) {
            if (seen.containsKey(nums[i])) {
                if (i - seen.get(nums[i]) <= k) {
                    return true;
                }
            }
            seen.put(nums[i], i);
        }

        return false;
    }

    public static void main(String[] args) {
        new Solution().containsNearbyDuplicate(new int[] {1, 2, 3, 1, 2, 3}, 2);
    }
}
