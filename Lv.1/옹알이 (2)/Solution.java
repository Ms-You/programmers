class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] canSay = {"aya", "ye", "woo", "ma"};
        
        for (int i = 0; i < babbling.length; i++){
            for (int j = 0; j < 4; j++)
                babbling[i] = babbling[i].replaceAll(canSay[j], j+"");
            int len = babbling[i].length();
            babbling[i] = babbling[i].replaceAll("[a-z]", "").replaceAll("[0]{2,}", "").replaceAll("[1]{2,}", "").replaceAll("[2]{2,}", "").replaceAll("[3]{2,}", "");
            if (len == babbling[i].length()) answer++;
        }
        
        return answer;
    }
}