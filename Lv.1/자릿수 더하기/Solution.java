import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        for (char ch: Integer.toString(n).toCharArray())
            answer += Character.getNumericValue(ch);

        return answer;
    }
}