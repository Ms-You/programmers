// 참고한 풀이 (기존 풀이는 시간 초과)
import java.util.*;
import java.util.stream.*;
class Solution {
    public static Map<String, List<Integer>> map;
    public static int binarySearch(List<Integer> list, int score) {
        int low = 0, high = list.size()-1;
    	int mid;
    
    	while(low <= high) {
    		mid = (low + high) / 2;
    
    		if(list.get(mid) < score) low = mid+1;
    		else high = mid - 1;
    	}
    
    	return list.size() - low;
    }
    
    public static void dfs(String s, String[] str, int cnt){
        if (cnt == 4){
            if (!map.containsKey(s))
                map.put(s, new ArrayList<>());
            
            map.get(s).add(Integer.parseInt(str[4]));
            return;
        }
        
        dfs(s+"-", str, cnt+1);
        dfs(s+str[cnt], str, cnt+1);
    }
        
    public int[] solution(String[] info, String[] query) {
        List<Integer> answer = new ArrayList<>();
	    map = new HashMap<>();
	    
	    for (int i = 0; i < info.length; i++){
	        String[] str = info[i].split(" ");
	        dfs("", str, 0);
	    }
	    
	    for (String key : map.keySet())
	        Collections.sort(map.get(key));
	    
	    
	    for (int i = 0; i < query.length; i++){
	        String[] temp = query[i].replaceAll(" and ", "").split(" ");
	        if (map.containsKey(temp[0]))
	            answer.add(binarySearch(map.get(temp[0]), Integer.parseInt(temp[1])));
	        else
	            answer.add(0);
	    }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}