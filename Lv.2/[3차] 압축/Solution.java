import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String msg) {
        List<String> list = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        
        list.add("");
        for (int i = 65; i < 91; i++)
            list.add((char)i+"");
        
        int start = 0;
        int end = 1;
        while(true){
            if (end > msg.length()){
                answer.add(list.indexOf(msg.substring(start, end-1)));
                break;
            }
            
            if (list.contains(msg.substring(start, end))) end++;
            else {
                list.add(msg.substring(start, end));
                answer.add(list.indexOf(msg.substring(start, end-1)));
                start = end-1;
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}