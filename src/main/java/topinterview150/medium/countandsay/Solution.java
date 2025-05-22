package topinterview150.medium.countandsay;

public class Solution {

    public String countAndSay(int n) {
       String ans = "1";

        for(int i = 1; i < n; i++) {
            ans = countAndSay(ans);
        }

        return ans;
    }

    private String countAndSay(String ans) {
      StringBuilder sb = new StringBuilder();
      Character prev = ans.charAt(0);
      int counter = 0;

      for(Character curr : ans.toCharArray()) {
          if(curr == prev) {
              counter++;
          } else {
              sb.append(counter);
              sb.append(prev);
              counter = 1;
              prev = curr;
          }
      }

      sb.append(counter);
      sb.append(prev);
      return sb.toString();
    }

    public static void main(String[] args) {
        new Solution().countAndSay(4);
    }
}
