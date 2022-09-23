import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        
        List<String> list = new ArrayList<>();
        list.add("0");
        
        int val = 0;
        while(list.size() <= t*m)
            for (String s : Integer.toString(val++, n).split(""))
                list.add(s.toUpperCase());
        
        for (int i = 0; i < t; i++){
            sb.append(list.get(p));
            p += m;
        }
        
        return sb.toString();
    }
}