import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= len)
                break;
            len -= 1;
        }
        
        return len;
    }
}