import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        long fac = 1;
        for (int i = 1; i <= n; i++){
            list.add(i);
            fac *= i;
        }
        
        long value = k-1;
        for (int i = 0; i < n; i++){
            fac /= (n-i);
            answer[i] = list.remove((int)(value / fac));
            value %= fac;
        }
        
        return answer;
    }
}