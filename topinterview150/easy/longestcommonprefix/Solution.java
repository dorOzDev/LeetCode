package topinterview150.easy.longestcommonprefix;

public class Solution {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        String commonPrefix = strs[0];
        int start = 0;
        int end = commonPrefix.length();
        for (String str : strs) {
            int localEndCommonPrefix = 0;
            while (localEndCommonPrefix < end && localEndCommonPrefix < str.length() && commonPrefix.charAt(localEndCommonPrefix) == str.charAt(localEndCommonPrefix)) {
                localEndCommonPrefix++;
            }
            end = localEndCommonPrefix;
        }
        return commonPrefix.substring(start, end);
    }

    public static void main(String[] args) {
        new Solution().longestCommonPrefix(new String[]{"flower","flow","flight"});
    }
}
