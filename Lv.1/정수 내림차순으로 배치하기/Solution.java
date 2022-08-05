import java.util.*;

class Solution {
    public long solution(long n) {
        Stack<Integer> st = new Stack<>();
        char[] ch = Long.toString(n).toCharArray();
        Arrays.sort(ch);
        
        for(char c: ch)
            st.push(Character.getNumericValue(c));
        
        String str = "";
        while(!st.isEmpty())
            str += st.pop();
        
        long answer = Long.parseLong(str);

        return answer;
    }
}

/*
// 개선된 코드
import java.util.*;

class Solution {
    public long solution(long n) {
        String[] str = String.valueOf(n).split("");
        Arrays.sort(str);
        
        StringBuilder sb = new StringBuilder();
        for (String s: str)
            sb.append(s);
        
        long answer = Long.parseLong(sb.reverse().toString());
        return answer;
    }
}
*/