import java.util.*;

class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        char[] ch = s.toCharArray();
        
        for (int i = 0; i < ch.length; i++){
            if ((int)ch[i] >= 97 && (int)ch[i] <= 122)
                sb.append(ch[i]);
            else
                answer += ch[i];
            
            if (Arrays.asList(num).contains(sb.toString())){
                answer += Arrays.asList(num).indexOf(sb.toString());
                sb.setLength(0);
            }
        }
        
        return Integer.parseInt(answer);
    }
}


// 더 나은 코드

import java.util.*;

class Solution {
    public int solution(String s) {
        String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] alphaNum = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for (int i = 0; i < 10; i++){
            s = s.replaceAll(alphaNum[i], num[i]);
        }

        return Integer.parseInt(s);
    }
}