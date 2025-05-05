package topinterview150.medium.reversewordsinastring;

public class Solution {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb = cleanRedundantSpaces(sb);
        int indexLastWord = findStartIndexOfrLastWord(sb);
        if(indexLastWord == 0) {
            return sb.toString();
        }
        return sb.toString();
    }

    private int findStartIndexOfrLastWord(StringBuilder sb) {
        int j = sb.length() - 1;
        while(j > 0 && sb.charAt(j) != ' ') {
            j--;
        }

        return j;
    }

    private StringBuilder cleanRedundantSpaces(StringBuilder sb) {
        int j = sb.length() - 1;
        while(sb.charAt(j) == ' ') {
            j--;
        }
        if(j < sb.length() - 1) {
            sb.replace(j + 1, sb.length(), "");
        }

        int i = 0;
        while(sb.charAt(i) == ' ') {
            i++;
        }

        if(i > 0) {
            sb.replace(0, i, "");
        }

        return sb;
    }

    public static void main(String[] args) {
        new Solution().reverseWords("blue   ");
    }
}
