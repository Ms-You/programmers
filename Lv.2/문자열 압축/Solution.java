import java.util.*;
class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        
        for (int i = 1; i <= s.length()/2; i++){
            int cnt = 1;
            for (int j = 0; j < s.length(); j+=i){
                if (j+i*2 <= s.length()){
		            if (s.substring(j, j+i).equals(s.substring(j+i, j+i*2))){
		                cnt++;
		            } else {
                        if (cnt == 1) sb.append("*" + s.substring(j, j+i));
		                else sb.append(cnt + s.substring(j, j+i));
		                cnt = 1;
		            }
		        } else {
                    if (cnt == 1) sb.append("*" + s.substring(j, s.length()));
		            else sb.append(cnt + s.substring(j, s.length()));
                    break;
		        }
            }
            list.add(sb.toString().replace("*", ""));
            sb.setLength(0);
        }
        
        int answer = s.length();
        for (int i = 0; i < list.size(); i++)
            if (answer > list.get(i).length())
                answer = list.get(i).length();
        
        return answer;
    }
}