// 이분탐색 및 우선순위 큐 사용한 참고 풀이
import java.util.*;
class Solution {
    private static int binarySearch(int n, int k, int[] enemy){
        int left = 0, right = enemy.length;
        
        while(left < right){
            int mid = (left + right)/2;
            if (defence(mid, n, k, enemy)) left = mid + 1;
            else right = mid;
        }
        
        return left;
    }
    
    private static boolean defence(int mid, int n, int k, int[] enemy){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < mid+1; i++)
            pq.add(enemy[i]);
        
        while(!pq.isEmpty()){
            int val = pq.poll();
            if (val <= n){
                n -= val;
                continue;
            }
            
            pq.add(val);
            return k >= pq.size();
        }
        return true;
    }
    
    public int solution(int n, int k, int[] enemy) {
        
        return binarySearch(n, k, enemy);
    }
}