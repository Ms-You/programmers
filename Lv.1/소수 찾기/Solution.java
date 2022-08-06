class Solution {
    public int solution(int n) {
        boolean[] bl = new boolean[n+1];
        for (int i = 2; i <= n; i++)
            bl[i] = true;
        int answer = 0;
        
        for (int i = 2; i <= n; i++){
            if (bl[i]){
                for (int j = i*2; j <= n; j+=i)
                    bl[j] = false;
            }
        }
        
        for (int i = 2; i <= n; i++){
            if (bl[i])
                answer++;
        }
        
        return answer;
    }
}