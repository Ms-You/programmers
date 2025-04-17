import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int targetScore = scores[0][0] + scores[0][1];
        List<Integer> scoreList = new ArrayList<>();
        
        for (int i = 0; i < scores.length; i++) {
            boolean isPossible = true;
            
            for (int j = 0; j < scores.length; j++) {
                if (i == j) {   // 자기 자신
                    continue;
                }
                
                if (scores[i][0] < scores[j][0] && scores[i][1] < scores[j][1]) {
                    isPossible = false;
                    break;
                }
            }
            
            if (isPossible) {
                scoreList.add(scores[i][0] + scores[i][1]);
            }
            
            if (i == 0 && !isPossible) {
                return -1;
            }
        }
        
        Collections.sort(scoreList, Collections.reverseOrder());
        
        for (int score : scoreList) {
            if (score > targetScore) {
                answer++;
            }
        }
        
        return answer;
    }
}