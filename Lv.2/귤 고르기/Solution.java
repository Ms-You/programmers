import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : tangerine)
            map.put(i, map.getOrDefault(i, 0) + 1);
        
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        
        for (Map.Entry<Integer, Integer> e : entryList){
            if (k <= 0) break;
            k -= e.getValue();
            answer++;
        }

        return answer;
    }
}