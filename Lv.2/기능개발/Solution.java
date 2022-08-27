import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> days = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        int day = 0;
        for (int i = 0; i < progresses.length; i++){
            while(progresses[i] + (speeds[i] * day) < 100) day++;
            days.add(day);
        }

        int cnt = 1;
        for (int i = 0; i < days.size()-1; i++){
            if (days.get(i) < days.get(i+1)){
                answer.add(cnt);
                cnt = 1;
            } else cnt++;
        }
        answer.add(cnt);

        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}