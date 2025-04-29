import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Map<String, Integer> gemMap = new HashMap<>();
        Set<String> gemSet = new HashSet<>();
        int minPoint = Integer.MAX_VALUE;
        int left = 0;
        
        for (String gem : gems) {
            gemSet.add(gem);
        }
        
        for (int right = 0; right < gems.length; right++) {
            gemMap.put(gems[right], gemMap.getOrDefault(gems[right], 0) + 1);
            
            while (gemMap.get(gems[left]) > 1) {    // 중복된 보석이 있으면 초과면 left 포인터 증가
                gemMap.put(gems[left], gemMap.get(gems[left]) - 1);
                left++;
            }
            
            if (gemMap.size() == gemSet.size() && minPoint > right-left) { // 이전 최소 구간이 지금의 최소 구간보다 길면
                minPoint = right-left; // 최소 구간 업데이트
                answer[0] = left+1;
                answer[1] = right+1;
            }
        }
        
        return answer;
    }
}
/*
투포인터 문제
*/