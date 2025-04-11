package topinterview150.easy.lengthoflastword;

public class Solution {

    public int lengthOfLastWord(String s) {
        s = s.stripTrailing();
        int i = s.length() - 1;

        while(i >= 0 && !Character.isSpaceChar(s.charAt(i))) {
            i--;
        }

        return s.length() - i - 1;
    }
}
