class Solution {
    public int solution(int distance, int[][] scope, int[][] times) {
        for (int i = 1; i <= distance; i++){
            for (int j = 0; j < scope.length; j++){
                int max = Math.max(scope[j][0], scope[j][1]);
                int min = Math.min(scope[j][0], scope[j][1]);
                if (min <= i && i <= max){
                    if ((i-1) % (times[j][0]+times[j][1]) < times[j][0]) return i;
                }
            }
        }
        
        return distance;
    }
}