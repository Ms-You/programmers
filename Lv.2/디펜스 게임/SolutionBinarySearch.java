import java.util.*;
class Solution {
    private static boolean isPossible(int n, int k, int[] enemy, int round) {
        List<Integer> enemyList = new ArrayList<>();
        
        for (int i = 0; i < round; i++) {
            enemyList.add(enemy[i]);
        }
        
        Collections.sort(enemyList);
        
        for (int i = 0; i <= enemyList.size()-1-k; i++) {
            if (n >= enemyList.get(i)) {
                n -= enemyList.get(i);
            } else {
                return false;
            }
        }
        
        return true;
    }
    
    public int solution(int n, int k, int[] enemy) {
        int left = 0;
        int right = enemy.length;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (isPossible(n, k, enemy, mid)) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        
        return left-1;
    }
}