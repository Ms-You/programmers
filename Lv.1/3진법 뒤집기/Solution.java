class Solution {
    public int solution(int n) {
        
        int[] ternary = new int[1000];
        int answer = 0;
        int idx = 0;
        
        while(n != 0){
            ternary[idx++] = n % 3;
            n /= 3;
        }
        
        for (int i = idx-1; i >= 0; i--){
            answer += (int)Math.pow(3, idx-i-1) * ternary[i];
        }
        
        return answer;
    }
}