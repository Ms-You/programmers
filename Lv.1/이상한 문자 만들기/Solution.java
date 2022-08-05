class Solution {
    public String solution(String s) {
        
        String answer = "";
        int idx = 0;
        char[] ch = s.toCharArray();
        
        for (int i = 0; i < ch.length; i++){
            idx = ch[i] == ' ' ? 0 : idx + 1;
            if (idx % 2 == 0)
                answer += Character.toLowerCase(ch[i]);
            else
                answer += Character.toUpperCase(ch[i]);
        }
        
        
        return answer;
    }
}