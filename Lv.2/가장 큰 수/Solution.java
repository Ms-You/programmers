import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] arr = new String[numbers.length];
        
        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.toString(numbers[i]);
        
        Arrays.sort(arr, (a1, a2) -> {
           return (a1+a2).compareTo(a2+a1);
        });
        
        for (int i = arr.length-1; i >= 0; i--)
            sb.append(arr[i]);
        
        if (sb.charAt(0) == '0')
            return "0";
        
        return sb.toString();
    }
}