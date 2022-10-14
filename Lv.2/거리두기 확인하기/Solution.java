import java.util.*;
import java.util.stream.*;
class Solution {
    static Queue<int[]> queue;
    static boolean[][] visited;
    static String[][] places;
    static boolean flag;
    static int loc[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int[] solution(String[][] place) {
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < 5; i++){
            queue = new LinkedList<>();
            visited = new boolean[5][5];
            places = new String[5][5];
            flag = true;
            for (int j = 0; j < 5; j++){
                String[] temp = place[i][j].split("");
                for (int k = 0; k < 5; k++){
                    places[j][k] = temp[k];
                    if (places[j][k].equals("P")) queue.add(new int[]{j, k});
                }
            }
            
            while(!queue.isEmpty()){
                int[] value = queue.poll();
                dfs(value[0], value[1], value[0], value[1]);
            }
            answer.add(flag == true ? 1 : 0);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public static void dfs(int tx, int ty, int dx, int dy){
        visited[tx][ty] = true;
        
        for (int i = 0; i < 4; i++){
            int x = tx + loc[i][0];
            int y = ty + loc[i][1];
            
            if (x < 0 || x >= 5 || y < 0 || y >= 5 || visited[x][y]) continue;
            
            if (Math.abs(dx - x) + Math.abs(dy - y) <= 2){
                if (places[x][y].equals("P") || places[x][y].equals("O")){
                    dfs(x, y, dx, dy);
                    if (places[x][y].equals("P")) flag = false;
                }
            }
        }
    }
    
}