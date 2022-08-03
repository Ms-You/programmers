import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] temp = new int[arr.length];
        temp[0] = arr[0];
        int idx = 1;

        for(int i = 1; i < arr.length; i++){
            if (arr[i] != arr[i-1])
                temp[idx++] = arr[i];
        }
        
        int[] answer = Arrays.copyOfRange(temp, 0, idx);

        return answer;
    }
}