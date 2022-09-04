class Solution {
    public int solution(String word) {
        int answer = 0;
        String words = "AEIOU";
        int value = 781;
        
        for (int i = 0; i < word.length(); i++){
            int s = word.charAt(i);
            if (s == 'A'){
                answer += words.indexOf(s) * (value) + 1;
                value/=5;
            } else if (s == 'E'){
                answer += words.indexOf(s) * (value) + 1;
                value/=5;
            } else if (s == 'I'){
                answer += words.indexOf(s) * (value) + 1;
                value/=5;
            } else if (s == 'O'){
                answer += words.indexOf(s) * (value) + 1;
                value/=5;
            } else if (s == 'U'){
                answer += words.indexOf(s) * (value) + 1;
                value/=5;
            }
        }
        
        return answer;
    }
}