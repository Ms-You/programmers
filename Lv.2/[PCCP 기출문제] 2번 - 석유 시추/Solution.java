import java.util.*;
class Solution {
    static int[] maxBlock;
    static int[] dirX = {1, 0, -1, 0};
    static int[] dirY = {0, 1, 0, -1};
    
    private static void bfs(int[][] land, int x, int y, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int sameBlock = 1;
        int rightMax = x;
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dirX[i];
                int nextY = nowY + dirY[i];
                
                if (nextX < 0 || nextX >= land[0].length || nextY < 0 || nextY >= land.length) {
                    continue;
                }
                
                if (land[nextY][nextX] == 1 && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                    rightMax = Math.max(rightMax, nextX);
                    sameBlock++;
                }
            }
        }
        
        for (int i = x; i <= rightMax; i++) {
            maxBlock[i] += sameBlock;
        }
    }
    
    public int solution(int[][] land) {
        int answer = 0;
        maxBlock = new int[land[0].length];
        boolean[][] visited = new boolean[land[0].length][land.length];
        
        for (int i = 0; i < land[0].length; i++) {
            for (int j = 0; j < land.length; j++) {
                if (land[j][i] == 1 && !visited[i][j]) {
                    bfs(land, i, j, visited);
                }
            }
        }
        
        for (int block : maxBlock) {
            answer = Math.max(answer, block);
        }
        
        return answer;
    }
}
/*
0 ~ land[0].length까지 반복
0 ~ land.length까지 돌면서 1인지 체크
1이면 bfs 돌리면서 오른쪽 최대 범위를 구할 것
구하면 idx 부터 최대 범위까지 더해줌

마지막엔 결과 구한 배열에서 최대 값만 구해주면 끝
*/