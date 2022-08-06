import java.util.*;

class Solution {
    public String solution(String[] seoul) {
        int idx = Arrays.asList(seoul).indexOf("Kim");
        String answer = String.format("김서방은 %d에 있다", idx);
        return answer;
    }
}