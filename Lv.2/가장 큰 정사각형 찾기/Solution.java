class Solution
{
    public int solution(int [][]board)
    {
        boolean flag = true;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                if (board[i][j] == 1) flag = false;
        
        if (flag) return 0;
        
        
        int result = 1;
        for (int i = 1; i < board.length; i++){
            for (int j = 1; j < board[i].length; j++){
                board[i][j] = Math.min(board[i-1][j], Math.min(board[i][j-1], board[i-1][j-1])) + 1;
                if (result < board[i][j]) result = board[i][j];
            }
        }
        
        return result * result;
    }
}