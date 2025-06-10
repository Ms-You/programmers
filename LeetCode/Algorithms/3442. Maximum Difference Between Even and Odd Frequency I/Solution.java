import java.util.*;
class Solution {
    public int maxDifference(String s) {
        int[] arr = new int[26];

        for (char ch : s.toCharArray()) {
            arr[ch-'a']++;
        }

        Arrays.sort(arr);

        int oddIdx = 25;
        while (arr[oddIdx] % 2 == 0) {
            oddIdx--;
        }

        int evenIdx = 0;
        while (arr[evenIdx] % 2 != 0 || arr[evenIdx] == 0) {
            evenIdx++;
        }
        
        return arr[oddIdx] - arr[evenIdx];
    }
}