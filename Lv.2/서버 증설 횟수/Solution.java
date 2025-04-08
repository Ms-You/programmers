import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Map<Integer, Integer> serverMap = new HashMap<>();
        
        for (int i = 0; i < 24; i++) {
            serverMap.put(i, 0);
        }
        
        for (int i = 0; i < players.length; i++) {
            if (players[i] >= m) {
                int need = players[i]/m - serverMap.get(i);
                
                if (need > 0) {
                    answer += need;
                    
                    for (int j = 0; j < k; j++) {
                        if (i+j < 24) {
                            serverMap.put(i+j, serverMap.get(i+j) + need);
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}