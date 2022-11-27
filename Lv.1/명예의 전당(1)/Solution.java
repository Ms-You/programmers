import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> list = new ArrayList<>();
        int min = 2001;
        int idx = 0;
        
        while(list.size() < k && idx < score.length){
            if (min > score[idx]) min = score[idx];
            list.add(score[idx]);
            answer[idx++] = min;
        }
        
        for (int i = idx; i < score.length; i++){
            if (min < score[i]){
                list.remove(list.indexOf(min));
                list.add(score[i]);
                min = Collections.min(list);
            }
            answer[i] = min;
        }
        
        return answer;
    }
}