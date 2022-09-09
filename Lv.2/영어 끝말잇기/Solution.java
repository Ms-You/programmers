import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        boolean flag = true;
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        
        for (int i = 1; i < words.length; i++){
            char ch = words[i-1].charAt(words[i-1].length()-1);
            char ch2 = words[i].charAt(0);
            
            if (ch != ch2 || list.contains(words[i]) || words[i].length() == 1){
                answer[0] = i%n + 1;
                answer[1] = i/n + 1;
                flag = false;
                break;
            }
            list.add(words[i]);
        }
        
        
        return flag ? new int[]{0, 0} : answer;
    }
}