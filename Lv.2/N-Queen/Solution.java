class Solution {
    static int answer = 0;
    static int[] input;
    static int n;
    
    public int solution(int m) {
        n = m;
        input = new int[n];
        
        dfs(0);
        
        return answer;
    }
    
    public static void dfs(int row){
        if (row == n){
            answer++;
            return;
        }
        
        for (int col = 0; col < n; col++){
            boolean flag = true;
            for (int r = 0; r < row; r++){
                if (input[r] == col || Math.abs(r - row) == Math.abs(input[r] - col)) flag = false;
            }
            
            if (flag){
                input[row] = col;
                dfs(row+1);
            }
        }
    }
}