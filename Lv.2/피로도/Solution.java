import java.util.*;
class Solution {
    
    static List<Integer> list = new ArrayList<>();
    
    public int solution(int k, int[][] dungeons) {
        perm(0, new int[dungeons.length][dungeons.length], new boolean[dungeons.length], dungeons, k);
        return Collections.max(list);
    }
    
    public static void perm(int cnt, int[][] selected, boolean[] visited, int[][] dungeons, int k){
        if (cnt == dungeons.length){
            int[][] temp = new int[dungeons.length][dungeons.length];
            for (int i = 0; i < cnt; i++){
                temp[i][0] = selected[i][0];
                temp[i][1] = selected[i][1];
            }
            int p = k;
            int count = 0;
            for (int i = 0; i < temp.length; i++){
                if (p >= temp[i][0]){
                    p -= temp[i][1];
                    count++;
                }
            }
            list.add(count);
            return;
        }
        
        for (int i = 0; i < dungeons.length; i++){
            if (!visited[i]){
                visited[i] = true;
                selected[cnt][0] = dungeons[i][0];
                selected[cnt][1] = dungeons[i][1];
                perm(cnt+1, selected, visited, dungeons, k);
                visited[i] = false;
            }
        }
    }
    
}