// 풀이 참조
class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int len = s.length();
        int sign = 1;
        int result = 0;

        while (i < len && s.charAt(i) == ' ') {
            i++;
        }

        if (i < len && s.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        if (i < len && s.charAt(i) == '+') {
            if (i != 0 && s.charAt(i-1) == '-') {
                return 0;
            }

            sign = 1;
            i++;
        }

        while (i < len && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            if (result > (Integer.MAX_VALUE - digit)/10) {
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }

            result = result * 10 + digit;
            i++;
        }

        return sign * result;
    }
}