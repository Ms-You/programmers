import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i= 0; i < commands.length; i++){
            int idx = commands[i][0];
            int jdx = commands[i][1];
            int kdx = commands[i][2];

            int[] arr = Arrays.copyOfRange(array, idx-1, jdx);
            
            Arrays.sort(arr);
            answer[i] = arr[kdx-1];

        }        
        
        return answer;
    }

}