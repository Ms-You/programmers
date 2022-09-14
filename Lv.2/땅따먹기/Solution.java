import java.util.*;
class Solution {
    int solution(int[][] land) {
        
        for(int i = 1; i < land.length; i++){
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
        }
        
        int[] result = new int[4];
	    result[0] = land[land.length-1][0];
	    result[1] = land[land.length-1][1];
	    result[2] = land[land.length-1][2];
	    result[3] = land[land.length-1][3];
	    Arrays.sort(result);
        
        return result[3];
    }
}