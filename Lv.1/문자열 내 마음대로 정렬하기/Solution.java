import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        int idx = 0;
        Map<String, String> map = new LinkedHashMap<>();
        Arrays.sort(strings);
        
        for (int i = 0; i < strings.length; i++)
            map.put(strings[i], strings[i].split("")[n]);
        
        List<Map.Entry<String, String>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        
        for (Map.Entry<String, String> entry : entries)
            answer[idx++] = entry.getKey();
        
        return answer;
    }
}