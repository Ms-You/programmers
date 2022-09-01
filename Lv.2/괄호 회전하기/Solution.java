import java.util.*;
class Solution {
    public int solution(String s) {
        List<String> list = new ArrayList<>(Arrays.asList(s.split("")));
        Stack<String> st = new Stack<>();

        int cnt = 0;
        for (int i = 0; i < list.size(); i++){
            for (int j = 0; j < list.size(); j++){
                if (st.isEmpty()) st.push(list.get(j));
                else {
                    if (st.peek().equals("(") && list.get(j).equals(")")) st.pop();
                    else if (st.peek().equals("{") && list.get(j).equals("}")) st.pop();
                    else if (st.peek().equals("[") && list.get(j).equals("]")) st.pop();
                    else st.push(list.get(j));
                }
            }
            if (st.isEmpty()) cnt++;
            st.clear();
            list.add(list.get(0));
            list.remove(0);
        }
        
        return cnt;
    }
}