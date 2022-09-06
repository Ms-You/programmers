import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        int[][] arr = new int[n+1][n+1];
        for (int i = 0; i < wires.length; i++){
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }
        
        for (int i = 0; i < wires.length; i++){
            int x = wires[i][0];
            int y = wires[i][1];
            
            arr[x][y] = 0;
            arr[y][x] = 0;
            
            answer = Math.min(bfs(x, arr, n), answer);
            
            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        return answer;
    }
    
    public static int bfs(int start, int[][] arr, int n){
        int cnt = 1;
        boolean[] visited = new boolean[n+1];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int v = queue.poll();
            visited[v] = true;
            
            for (int i = 1; i <= n; i++){
                if (!visited[i] && arr[v][i] == 1){
                    cnt++;
                    queue.add(i);
                }
            }
        }
         return Math.abs(cnt - (n - cnt));
    }
    
}