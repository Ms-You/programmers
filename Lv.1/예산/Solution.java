import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int num = 0;
        
        for (int i = 0; i < d.length; i++){
            num += d[i];
            if (num > budget)
                return i;
        }
        
        return d.length;
    }
}