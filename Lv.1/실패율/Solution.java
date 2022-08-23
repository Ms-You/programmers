import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] num = new int[N+1];
        List<Double> rate = new ArrayList<>();

        for (int i = 0; i < stages.length; i++)
            num[stages[i]-1]++;
        
        double sum = Arrays.stream(num).sum();

        for(int i = 0; i < N; i++){
            if (num[i] == 0 || sum == 0)
                rate.add(0.0);
            else 
                rate.add(num[i]/sum);
            sum -= num[i];
        }
        
        for (int i = 0; i < rate.size(); i++){
            answer[i] = rate.indexOf(Collections.max(rate))+1;
            rate.set(rate.indexOf(Collections.max(rate)), -1.0);
        }

        return answer;
    }
}