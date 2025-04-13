import java.util.*;
import java.util.stream.*;
class Solution {
    static int[] input;
    static int answer = 0;
    
    private static void comb(int cnt, int start, int[] selected, int[][] q, int[] ans) {
        if (cnt == 5) {
            List<Integer> combList = Arrays.stream(selected)
                .boxed()
                .collect(Collectors.toList());
            
            checkSecretCode(combList, q, ans);
            return;
        }
        
        for (int i = start; i < input.length; i++) {
            selected[cnt] = input[i];
            comb(cnt+1, i+1, selected, q, ans);
        }
    }
    
    private static void checkSecretCode(List<Integer> combList, int[][] q, int[] ans) {
        for (int i = 0; i < q.length; i++) {
            int same = 0;
            
            for (int j = 0; j < q[i].length; j++) {
                if (combList.contains(q[i][j])) {
                    same++;
                }
            }
            
            if (same != ans[i]) {
                return;
            }
        }
        
        answer++;
    }
    
    public int solution(int n, int[][] q, int[] ans) {
        input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = i+1;
        }
        
        comb(0, 0, new int[5], q, ans);
        
        return answer;
    }
}
/*
1. 1~10까지 조합을 구한다.
2. q[i]랑 비교해서 ans[i]개가 일치하는지 확인한다.
*/