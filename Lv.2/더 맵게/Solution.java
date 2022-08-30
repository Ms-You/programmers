import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++)
            pq.offer(scoville[i]);
        
        while(pq.peek() <= K){
            if (pq.size() == 1)
                return -1;
            int fmin = pq.poll();
            int smin = pq.poll();
            pq.offer(smin*2 + fmin);
            answer++;
        }
        
        return answer;
    }
}