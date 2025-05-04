package topinterview150.medium.evaluatereversepolishnotation;

import java.util.Set;
import java.util.Stack;

public class Solution {

    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        Set<String> supportedOperations = Set.of("+", "-", "*", "/");
        for(String token : tokens) {
            if(!supportedOperations.contains(token)) {
                nums.add(Integer.valueOf(token));
            } else {
                Integer right = nums.pop();
                Integer left = nums.pop();
                Integer evaluation = evaluateExpressions(left, right, token);
                nums.add(evaluation);
            }
        }

        return nums.pop();
    }

    private Integer evaluateExpressions(Integer left, Integer right, String token) {
        if(token.equals("+")) {
            return left + right;
        } else if (token.equals("-")) {
            return left - right;
        } else if(token.equals("*")) {
            return left * right;
        } else {
            return left / right;
        }
    }

    public static void main(String[] args) {
        new Solution().evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"});
    }
}
