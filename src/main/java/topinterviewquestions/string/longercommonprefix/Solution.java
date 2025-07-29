package topinterviewquestions.string.longercommonprefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String longestCommonPrefix = strs[0];

        for(int i = 1; i < strs.length; ++i) {
            int minLength = Math.min(longestCommonPrefix.length(), strs[i].length());
            StringBuilder sb = new StringBuilder();
            int j = 0;
            while(j < minLength && longestCommonPrefix.charAt(j) == strs[i].charAt(j)) {
                sb.append(longestCommonPrefix.charAt(j));
                j++;
            }

            longestCommonPrefix = sb.toString();
        }

        return longestCommonPrefix;
    }
}
