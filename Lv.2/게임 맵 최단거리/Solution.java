import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int[][] loc = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int[][] cnt = new int[maps.length][maps[0].length];

        visited[0][0] = true;
        cnt[0][0] = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];

            for (int i = 0; i < 4; i++){
                if (x+loc[i][0] < 0 || x+loc[i][0] >= maps.length || y+loc[i][1] < 0 || y+loc[i][1] >= maps[0].length) continue;

                if (!visited[x+loc[i][0]][y+loc[i][1]] && maps[x+loc[i][0]][y+loc[i][1]] == 1){
                    visited[x+loc[i][0]][y+loc[i][1]] = true;
                    cnt[x+loc[i][0]][y+loc[i][1]] = cnt[x][y] + 1;
                    queue.add(new int[]{x+loc[i][0], y+loc[i][1]});
                }
            }
        }

        return cnt[maps.length-1][maps[0].length-1] != 0 ? cnt[maps.length-1][maps[0].length-1] : -1;
    }
}