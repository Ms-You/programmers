import java.util.*;
class Solution {
    public int[] solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        s = s.replaceAll("[{}]", "");
        for (String ss : s.split(","))
            map.put(ss, map.getOrDefault(ss, 0) + 1);
        
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>(){
           @Override
            public int compare(Map.Entry<String, Integer>o1, Map.Entry<String, Integer>o2){
                return o2.getValue() - o1.getValue();
            }
        });
        
        int idx = 0;
        int[] answer = new int[map.size()];
            
        for (Map.Entry<String, Integer> entry : entryList)
            answer[idx++] = Integer.parseInt(entry.getKey());
            
        return answer;
    }
}