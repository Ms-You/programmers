import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        int emptyMax = 0;   // 가장 넓은 빈자리의 길이
        
        int[][] maps = new int[park.length][park[0].length];
        
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length; j++) {
                if (park[i][j].equals("-1")) {
                    maps[i][j] = 1;
                } else {
                    maps[i][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < maps.length; i++) {
            for (int j = 1; j < maps[i].length; j++) {
                if (maps[i][j] == 0) {  // 알파벳이면 패스
                    continue;
                } else {
                    maps[i][j] = Math.min(maps[i][j-1], Math.min(maps[i-1][j], maps[i-1][j-1])) + 1;
                    emptyMax = Math.max(emptyMax, maps[i][j]);
                }
            }
        }
        
        Arrays.sort(mats);
        
        for (int mat : mats) {
            if (emptyMax < mat) {
                break;
            }
            
            answer = mat;
        }
        
        return answer;
    }
}
/*
 * 1. 가장 큰 정사각형 찾기 (이를 위해 정수형 배열 생성)
 * 1-1. -1은 1, -1이 아닌 알파벳은 0으로 치환
 * 2. 배열을 돌면서 가장 넓은 빈자리의 길이 찾기
**/