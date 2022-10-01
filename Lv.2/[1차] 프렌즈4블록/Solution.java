// 보고 품
import java.util.*;
class Solution {
    public static void isSame(char[][] temp, boolean[][] visited, int i, int j){
        char val = temp[i][j];
        if (i+1 < temp.length && j+1 < temp[i].length){
            if (val == temp[i+1][j] && val == temp[i][j+1] && val == temp[i+1][j+1]){
                visited[i][j] = true;
                visited[i+1][j] = true;
                visited[i][j+1] = true;
                visited[i+1][j+1] = true;
            }
        }
    }
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char[][] temp = new char[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                temp[i][j] = board[i].charAt(j);
         
        while(true){
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    char val = temp[i][j];
                    if (i+1 < m && j+1 < n){
                        if (val >= 'A' && val <= 'Z' && val == temp[i+1][j] && val == temp[i][j+1] && val == temp[i+1][j+1]){
                            visited[i][j] = true;
                            visited[i+1][j] = true;
                            visited[i][j+1] = true;
                            visited[i+1][j+1] = true;
                            isSame(temp, visited, i+1, j);
                            isSame(temp, visited, i, j+1);
                            isSame(temp, visited, i+1, j+1);
                        }
                    } else continue;
                }
            }
            
            List<Character>[] list = new ArrayList[n];
            for (int i = 0; i < n; i++)
                list[i] = new ArrayList<>();
            
            for (int i = 0; i < n; i++)
                for (int j = m-1; j >= 0; j--)
                    if (!visited[j][i]) list[i].add(temp[j][i]);
             
            int cnt = 0;
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    if (visited[i][j]) cnt++;
            
            if (cnt == 0) break;
            temp = new char[m][n];
            for (int i = 0; i < n; i++){
                for (int j = m-1; j >= 0; j--){
                    if (list[i].size() > 0){
                        temp[j][i] = list[i].get(0);
                        list[i].remove(0);
                    }
                }
            }
        }
        
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (temp[i][j] >= 'A' && temp[i][j] <= 'Z') answer++;
            
        return m*n - answer;
    }
}