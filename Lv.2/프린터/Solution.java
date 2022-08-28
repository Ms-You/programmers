import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int cnt = 0;
        
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < priorities.length; i++)
            pq.offer(priorities[i]);
        
        while(!pq.isEmpty()){
            for (int i = 0; i < priorities.length; i++){
                if (pq.peek() == priorities[i]){
                    if (i == location){
                        cnt++;
                        return cnt;
                    }
                    pq.poll();
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}