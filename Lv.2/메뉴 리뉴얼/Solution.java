import java.util.*;
class Solution {
    static int M;
    static String[] input;
    static Map<String, Integer> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    
    // 조합 사용
    public static void comb(int cnt, int start, String[] selected){
        if (cnt == M){
            for (int i = 0; i < cnt; i++)
                sb.append(selected[i]);
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            sb.setLength(0);
            return;
        }
        for (int i = start; i < input.length; i++){
            selected[cnt] = input[i];
            comb(cnt+1, i+1, selected);
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < course.length; i++){
            M = course[i];
            for (int j = 0; j < orders.length; j++){
                String[] s = orders[j].split("");
                Arrays.sort(s);
                input = s;
                comb(0, 0, new String[M]);
            }
            
            List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
            entryList.sort(new Comparator<Map.Entry<String, Integer>>(){
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
                    return o2.getValue() - o1.getValue();
                }
            });
            
            int max = -1;
            for (Map.Entry<String, Integer> entry : entryList){
                if (entry.getValue() == 1) break;
                if (max == -1){
                    list.add(entry.getKey());
                    max = entry.getValue();
                } else if (max == entry.getValue())
                    list.add(entry.getKey());
                else
                    break;
            }
            map.clear();
        }
        Collections.sort(list);
        
        return list.toArray(new String[list.size()]);
    }
}