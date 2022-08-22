class Solution {
    public String solution(String new_id) {
        // 1단계
        String answer = new_id.toLowerCase();
        
        // 2단계
        answer = answer.replaceAll("[^a-z0-9-_.]", "");
        
        // 3단계
        answer = answer.replaceAll("[.]{2,}", ".");
        
        // 4단계
        answer = answer.replaceAll("^[.]|[.]$", "");
        
        // 5단계
        if (answer.length() == 0)
            answer += "a";
        
        // 6단계
        if (answer.length() > 15){
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }
        
        // 7단계
        if (answer.length() <= 2){
            while(answer.length() < 3)
                answer += answer.substring(answer.length()-1, answer.length());
        }
        
        return answer;
    }
}