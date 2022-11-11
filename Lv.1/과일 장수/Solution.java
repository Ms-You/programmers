import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        List<Integer> sc = IntStream.of(score).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        if (sc.size() >= m){
            for (int i = m-1; i < sc.size(); i+=m)
                answer += sc.get(i) * m;
        }
        
        return answer;
    }
}