package topinterview150.medium.reversewordsinastring;

public class Solution {

    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = split.length - 1; i >= 0; --i) {
            if(!split[i].equals("")) {
                sb.append(split[i]);
                sb.append(" ");
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        new Solution().reverseWords("the sky is blue");
    }
}
