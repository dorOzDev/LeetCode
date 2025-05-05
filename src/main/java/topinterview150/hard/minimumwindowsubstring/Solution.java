package topinterview150.hard.minimumwindowsubstring;

public class Solution {

    public String minWindow(String s, String t) {
        if(s.length() < t.length()) {
            return "";
        }

        int left = 0;
        int right = t.length();
        int[] sBucket = fillBucket(s, 0, right);
        int[] tBucket = fillBucket(t, 0, right);

        int leftAns = left;
        int rightAns = right;
        int min = Integer.MAX_VALUE;
        boolean bucketContainsOther = isBucketContainsOther(sBucket, tBucket);
        boolean found = false;
        while(bucketContainsOther || right < s.length()) {
            if(bucketContainsOther) {
                found = true;
                if(min >= right - left) {
                    leftAns = left;
                    rightAns = right;
                    min = right - left;
                }
                sBucket[s.charAt(left) - 'A']--;
                left++;
            } else {
                sBucket[s.charAt(right) - 'A']++;
                right++;
            }
            bucketContainsOther = isBucketContainsOther(sBucket, tBucket);
        }

        if(found) {
            return s.substring(leftAns, rightAns);
        }
        return "";
    }

    private boolean isBucketContainsOther(int[] left, int[] right) {
        for(int i = 0; i < left.length; ++i) {
            if(right[i] > left[i]) {
                return false;
            }
        }

        return true;
    }

    private int[] fillBucket(String str, int from, int to) {
        int[] bucket = new int[58];

        for(int i = from; i < to; ++i) {
            bucket[str.charAt(i) - 'A']++;
        }

        return bucket;
    }

    public static void main(String[] args) {
        String s = new Solution().minWindow("a", "b");
        System.out.println(s);
    }
}
