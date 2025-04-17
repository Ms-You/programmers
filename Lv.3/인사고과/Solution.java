class Solution {
    private static boolean isPossible(int scoreX, int scoreY, int[][] scores) {
        for (int i = 0; i < scores.length; i++) {
            if (scoreX < scores[i][0] && scoreY < scores[i][1]) {
                return false;
            }
        }
        
        return true;
    }
    
    public int solution(int[][] scores) {
        int answer = 1;
        
        for (int i = 1; i < scores.length; i++) {
            if (scores[i][0] > scores[0][0] && scores[i][1] > scores[0][1]) {
                return -1;
            }
        }
        
        for (int i = 0; i < scores.length; i++) {
            if (scores[i][0] + scores[i][1] > scores[0][0] + scores[0][1]) {
                if (isPossible(scores[i][0], scores[i][1], scores)) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}