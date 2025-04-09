package topinterview150.easy.romantointeger;

import java.util.Map;

public class Solution {

    private Map<Character, Integer> romanToIntegerMap = Map.of(
      'I', 1,
      'V', 5,
      'X', 10,
      'L', 50,
      'C', 100,
      'D', 500,
      'M', 1000
    );

    public int romanToInt(String s) {
        int total = 0;
        char prev = '$';

        for(int i = s.length() - 1; i >= 0; --i) {
            char currentChar = s.charAt(i);
            int subtract = 0;
            if(currentChar == 'I') {
                if(prev == 'V' || prev == 'X') {
                    subtract = romanToIntegerMap.get('I');
                }
            } else if(currentChar == 'X') {
                if(prev == 'L' || prev == 'C') {
                    subtract = romanToIntegerMap.get('X');
                }
            } else if(currentChar == 'C') {
                if(prev == 'D' || prev == 'M') {
                    subtract = romanToIntegerMap.get('C');
                }
            }
            subtract *= 2;
            total += romanToIntegerMap.get(currentChar) - subtract;
            prev = currentChar;
        }

        return total;
    }

    public static void main(String[] args) {
        int sum = new Solution().romanToInt("MCMXCIV");
        System.out.println(sum);
    }
}
