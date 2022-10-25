class Solution {
    static int cnt0 = 0;
    static int cnt1 = 0;
    static int[][] array;
    public static void rec(int x, int y, int val){
        if (val == 1){
            if (array[x][y] == 0) cnt0++;
            else cnt1++;
            return;
        }
        
        int sum = 0;
        for (int i = x; i < x+val; i++){
            for (int j = y; j < y+val; j++){
                sum += array[i][j];
            }
        }
        
        if (sum == 0) cnt0++;
        else if (sum == val*val) cnt1++;
        else {
            rec(x, y, val/2);
            rec(x, y+val/2, val/2);
            rec(x+val/2, y, val/2);
            rec(x+val/2, y+val/2, val/2);
        }
    }
    
    public int[] solution(int[][] arr) {
        array = arr;
        rec(0, 0, arr.length);
        
        int[] answer = {cnt0, cnt1};
        
        return answer;
    }
}