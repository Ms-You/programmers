import java.util.*;
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        boolean isDown = true;
        int row = 0;

        for (char ch : s.toCharArray()) {
            list.get(row).append(ch);

            if (row == numRows-1) {
                isDown = false;
            } else if (row == 0) {
                isDown = true;
            }

            if (isDown) {
                row++;
            } else {
                row--;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (StringBuilder sb : list) {
            answer.append(sb);
        }

        return answer.toString();
    }
}