class Solution {
    public int solution(int n, int w, int num) {
        int totalFloor = n/w;
        int totalRemains = n%w;
        int targetFloor = num/w;
        int targetRemains = num%w;
        
        if (totalRemains > 0) {
            totalFloor++;
        }
        
        if (targetRemains > 0) {
            targetFloor++;
        }
        
        int answer = totalFloor - targetFloor;
        
        boolean totalFloorDirection = totalFloor % 2 != 0;
        boolean targetFloorDirection = targetFloor % 2 != 0;
        
        if (targetRemains == 0) {
            if (targetFloorDirection) {
                targetRemains = 1;
            } else {
                targetRemains = w;
            }
        }
        
        if (totalFloorDirection == targetFloorDirection) {
            if (totalRemains == 0 || totalRemains >= targetRemains) {
                answer++;
            }
        } else {
            if (totalRemains == 0 || w-totalRemains <= targetRemains) {
                answer++;
            }
        }
        
        return answer;
    }
}