class Solution {
    static int lim;
    static int pow;
    
    public static int divisor(int num){
        int cnt = 0;
        for (int i = 1; i*i <= num; i++){
            if (i*i == num) cnt++;
            else if (num % i == 0) cnt += 2;
            
            if (cnt > lim) return pow;
        }
        
        return cnt;
    }
    
    public int solution(int number, int limit, int power) {        
        lim = limit;
        pow = power;
        
        int answer = 0;
        for (int i = 1; i <= number; i++)
            answer += divisor(i);
        
        return answer;
    }
}