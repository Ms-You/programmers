import java.util.*;
class Solution {
    public void setZeroes(int[][] matrix) {
        List<int[]> zeroList = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeroList.add(new int[]{i, j});
                }
            }
        }

        for (int i = 0; i < zeroList.size(); i++) {
            int x = zeroList.get(i)[0];
            int y = zeroList.get(i)[1];

            // column
            for (int j = 0; j < n; j++) {
                matrix[x][j] = 0;
            }

            // row
            for (int j = 0; j < m; j++) {
                matrix[j][y] = 0;
            }
        }

    }
}