// 아래 코드 이전에 푼 풀이도 있는데 테스트 케이스는 성공하지만, 효율성에서 실패떴음
import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(long begins, long ends) {
        int begin = (int) begins;
        int end = (int) ends;
        
        List<Integer> list = new ArrayList<>();
        for (int i = begin; i <= end; i++){
            if (i == 1) list.add(0);
            else list.add(findValue(i));
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public static int findValue(int n){
        for (int i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0){
                if (n/i > 10000000) continue;
                return n/i;
            }
        }
        return 1;
    }
}