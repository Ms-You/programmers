import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        StringBuilder sb = new StringBuilder();
        for (int i : ingredient)
            sb.append(i);
        String s = sb.toString();
        String remove = "1231";
        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < s.length(); i++){
            st.push(s.charAt(i));
            if (st.size() >= 4){
                boolean flag = true;
                for (int j = 0; j < 4; j++){
                    if (st.get(st.size() - 4 + j) != remove.charAt(j)){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    for (int j = 0; j < 4; j++)
                        st.pop();
                }
            }
        }
            
        return (s.length() - st.size())/4;
    }
}