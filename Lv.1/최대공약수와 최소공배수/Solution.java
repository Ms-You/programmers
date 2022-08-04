import java.util.*;

class Solution {
    public int[] solution(int n, int m) {
        int gcd = 0;
        int min = Math.min(n, m);
        
        for (int i = 1; i <= min; i++){
            if (n % i == 0 && m % i == 0)
                gcd = i;
        }
        
        int[] answer = {gcd, n*m/gcd};
        
        return answer;
    }
}