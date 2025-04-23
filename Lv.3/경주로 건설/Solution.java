import java.util.*;
class Solution {
    static int[] dirX = {1, 0, -1, 0};
    static int[] dirY = {0, 1, 0, -1};
    
    private static int bfs(int[][] board) {
        Queue<int[]> queue = new LinkedList<>();    // x, y, 방향, 비용
        queue.add(new int[]{0, 0, -1, 0});
        int[][][] visited = new int[board.length][board[0].length][4];  // x, y, 상하좌우 네 방향
        
        for (int[][] arr : visited) {
            for (int[] a : arr) {
                Arrays.fill(a, Integer.MAX_VALUE);
            }
        }
        
        visited[0][0][0] = 0;   // 아래 방향 초기화
        visited[0][0][1] = 0;   // 오른쪽 방향 초기화
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            int nowDirection = now[2];
            int nowCost = now[3];
            
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dirX[i];
                int nextY = nowY + dirY[i];
                
                if (nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board[0].length || board[nextX][nextY] == 1) {
                    continue;
                }
                
                int nextCost = nowCost + 100;   // 현재 비용 + 칸 이동 비용
                if (nowDirection != -1 && nowDirection != i) {  // 곡선 지점일 때
                    nextCost += 500;    // 500원 추가
                }
                
                if (nextCost < visited[nextX][nextY][i]) {
                    visited[nextX][nextY][i] = nextCost;
                    queue.add(new int[]{nextX, nextY, i, nextCost});
                }
            }
        }
        
        int minCost = Integer.MAX_VALUE;
        
        for (int i = 0; i < 4; i++) {
            minCost = Math.min(minCost, visited[board.length-1][board[0].length-1][i]);
        }
        
        return minCost;
    }
    
    public int solution(int[][] board) {
        int answer = bfs(board);
        
        return answer;
    }
}