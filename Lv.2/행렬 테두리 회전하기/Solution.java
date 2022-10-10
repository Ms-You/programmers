class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = new int[rows][columns];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                arr[i][j] = i * columns + j + 1;
        
        for (int s = 0; s < queries.length; s++){
            int xStart = queries[s][0]-1;
            int yStart = queries[s][1]-1;
            int xEnd = queries[s][2]-1;
            int yEnd = queries[s][3]-1;
            
            int temp = arr[xStart][yStart];
            int min = temp;
            
            for (int i = xStart; i < xEnd; i++){
                arr[i][yStart] = arr[i+1][yStart];
                min = Math.min(min, arr[i][yStart]);
            }
            
            for (int i = yStart; i < yEnd; i++){
                arr[xEnd][i] = arr[xEnd][i+1];
                min = Math.min(min, arr[xEnd][i]);
            }
            
            for (int i = xEnd; i > xStart; i--){
                arr[i][yEnd] = arr[i-1][yEnd];
                min = Math.min(min, arr[i][yEnd]);
            }
            
            for (int i = yEnd; i > yStart; i--){
                arr[xStart][i] = arr[xStart][i-1];
                min = Math.min(min, arr[xStart][i]);
            }
            
            arr[xStart][yStart+1] = temp;
            answer[s] = min;
        }
        
        return answer;
    }
}