class Solution {
    public int[] solution(int n) {
        int sum = 0;
        for(int i = 1; i <= n; i++)
            sum += i;
        
        int[] answer = new int[sum];
        int[][] tempArray = new int[n][n];
        
        int x = -1;
        int y = 0;
        int num = 1;
        
        for (int i = 0; i < n; i++){
            int temp = n;
            while(temp > i){
                if (i % 3 == 0) x++;  // 아래쪽
                else if (i % 3 == 1) y++;   // 오른쪽
                else if (i % 3 == 2){ // 왼쪽위 대각선
                    x--;
                    y--;
                }
                tempArray[x][y] = num++;
                temp--;
            }
        }
        
        int idx = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j <= i; j++)
                answer[idx++] = tempArray[i][j];
            
        return answer;
    }
}