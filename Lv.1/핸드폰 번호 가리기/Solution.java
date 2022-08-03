class Solution {
    public String solution(String phone_number) {
        int replaceLen = phone_number.length()-4;
        String answer = phone_number.replaceAll(phone_number.substring(0, replaceLen), "*".repeat(replaceLen));
        
        return answer;
    }
}