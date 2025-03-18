package topinterview150.medium.integertoroman;

import java.util.Map;

public class Solution {

    public static final int THOUSAND = 1000;
    private Map<Integer, Character> conversionMap = Map.of(
            1, 'I',
            5, 'V',
            10, 'X',
            50, 'L',
            100, 'C',
            500, 'D',
            THOUSAND, 'M');

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int pow = getMaxPowOfTen(num);
        while(num > 0) {
            sb.append(getRomanOfNumberPowOfTen(num, pow));
            num %= pow;
            pow /= 10;
        }

        return sb.toString();
    }

    private Integer getMaxPowOfTen(int num) {
        int pow = 1;
        while(num > 10) {
            num /= 10;
            pow *= 10;
        }

        return pow;
    }

    private String getRomanOfNumberPowOfTen(int number, int powerOfTen) {
        StringBuilder sb = new StringBuilder();
        boolean shouldReverse = false;
        Map.Entry<Integer, Character> roman = null;
        int total = (number / powerOfTen) * powerOfTen;

        while(total > 0) {
            if(total / powerOfTen == 9 || total / powerOfTen == 4) {
                roman = getUpperBound(total);
                sb.append(roman.getValue());
                total = roman.getKey() - total;
                shouldReverse = true;
            } else {
                roman = getLowerBound(total);
                sb.append(roman.getValue());
                total -= roman.getKey();
            }
        }

        if(shouldReverse) {
            return sb.reverse().toString();
        }

        return sb.toString();
    }

    private Map.Entry<Integer, Character> getLowerBound(int unit) {
        Map.Entry<Integer, Character> closetEntry = null;
        int min = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Character> entry : conversionMap.entrySet()) {
            if(Math.abs(unit - entry.getKey()) < min && unit >= entry.getKey()) {
                min = Math.abs(unit - entry.getKey());
                closetEntry = entry;
            }
        }

        return closetEntry;
    }

    private Map.Entry<Integer, Character> getUpperBound(int unit) {
        Map.Entry<Integer, Character> closetEntry = null;
        int min = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Character> entry : conversionMap.entrySet()) {
            if(Math.abs(unit - entry.getKey()) < min && unit <= entry.getKey()) {
                min = Math.abs(unit - entry.getKey());
                closetEntry = entry;
            }
        }

        return closetEntry;
    }

    public static void main(String[] args) {
        new Solution().intToRoman(1994);
    }
}
