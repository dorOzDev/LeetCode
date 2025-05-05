package topinterview150.easy.validparentheses;

import java.util.LinkedList;
import java.util.Map;

public class Solution {

    private static final Map<Character, Character> mapOpenToClose = Map.of('(', ')', '{', '}', '[', ']');
    private static final Map<Character, Character> mapCloseToOpen = Map.of(')', '(', '}', '{', ']', '[');

    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for(int i = 0; i < s.length(); ++i) {
            if(mapOpenToClose.containsKey(s.charAt(i))) {
                stack.add(s.charAt(i));
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                Character expectedOpen = mapCloseToOpen.get(s.charAt(i));
                Character actualOpen = stack.removeLast();
                if(actualOpen != expectedOpen) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
     }

    public static void main(String[] args) {
        new Solution().isValid("()");
    }
}
