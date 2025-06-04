class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        int[][] temp = new int[row][col];
        int x = 0, y = 0;

        for (int i = 0; i < col; i++) {
            for (int j = row-1; j >= 0; j--) {
                temp[x][y++] = matrix[j][i];
            }
            x++;
            y %= col;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
    }
}