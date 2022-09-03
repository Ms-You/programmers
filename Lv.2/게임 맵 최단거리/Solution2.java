import java.util.*;
class Solution2 {
    public int solution(int[][] maps) {
        int[][] loc = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int[][] visited = new int[maps.length][maps[0].length];
        visited[0][0] = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()){
            int[] value = queue.poll();
            int tx = value[0];
            int ty = value[1];

            for (int i = 0; i < 4; i++){
                int x = tx + loc[i][0];
                int y = ty + loc[i][1];

                if (x < 0 || x >= maps.length || y < 0 || y >= maps[0].length) continue;

                if (visited[x][y] == 0 && maps[x][y] == 1){
                    visited[x][y] = visited[tx][ty] + 1;
                    queue.add(new int[]{x, y});
                }
            }
        }

        int answer = visited[maps.length-1][maps[0].length-1];
        if (answer == 0) answer = -1;

        return answer;
    }
}