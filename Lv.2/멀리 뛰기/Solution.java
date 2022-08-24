class Solution {
    public long solution(int n) {
        if (n <= 1) return n;

        long a = 1, b = 2, answer = 0;

        for (int i = 2; i < n; i++){
            answer = (a + b) % 1234567;
            a = b;
            b = answer;
        }
        
        return answer;
    }
}