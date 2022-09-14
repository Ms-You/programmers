import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int sec = 0;
        
        for (int truck: truck_weights){
            while(true){
                if (queue.isEmpty()){
                    queue.add(truck);
                    sum += truck;
                    sec++;
                    break;
                } else if (queue.size() == bridge_length){
                    sum -= queue.poll();
                } else {
                    if (sum + truck <= weight){
                        queue.add(truck);
                        sum += truck;
                        sec++;
                        break;
                    } else {
                        queue.add(0);
                        sec++;
                    }
                }
            }
        }
        
        return sec + bridge_length;
    }
}