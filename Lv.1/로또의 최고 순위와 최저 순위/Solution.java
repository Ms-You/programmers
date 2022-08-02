import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCnt = 0;
        int matched = 0;
        
        for (int l: lottos){
            if (l == 0)
                zeroCnt++;
        }
        
        Arrays.sort(lottos);

        for (int i = zeroCnt; i < 6; i++){
            int num = lottos[i];
            if (Arrays.stream(win_nums).anyMatch(x -> x == num)){
                matched++;
            }
        }
        
        int[] answer = {Math.min(7 - matched - zeroCnt, 6), Math.min(7 - matched, 6)};
        return answer;
    }
    
}